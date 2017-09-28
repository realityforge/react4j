package react.processor;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import java.util.List;
import java.util.StringJoiner;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.NestingKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import jsinterop.base.JsConstructorFn;
import jsinterop.base.JsPropertyMap;
import org.realityforge.braincheck.Guards;
import react.core.NativeAdapterComponent;
import react.core.ReactConfig;

final class Generator
{
  private Generator()
  {
  }

  @Nonnull
  static TypeSpec buildConstructorFactory( @Nonnull final ComponentDescriptor descriptor )
  {
    final TypeElement element = descriptor.getElement();

    final StringBuilder name = new StringBuilder( descriptor.getConstructorFactoryName() );

    TypeElement t = element;
    while ( NestingKind.TOP_LEVEL != t.getNestingKind() )
    {
      t = (TypeElement) t.getEnclosingElement();
      name.insert( 0, t.getSimpleName() + "$" );
    }

    final TypeSpec.Builder builder = TypeSpec.classBuilder( name.toString() );

    ProcessorUtil.copyAccessModifiers( element, builder );

    //Ensure it can not be subclassd
    builder.addModifiers( Modifier.FINAL );

    // Mark it as generated
    builder.addAnnotation( AnnotationSpec.builder( Generated.class ).
      addMember( "value", "$S", ReactProcessor.class.getName() ).
      build() );
    final ClassName nativeComponent =
      ClassName.get( descriptor.getPackageElement().getQualifiedName().toString(),
                     "React_" + descriptor.getElement().getSimpleName().toString() );
    final TypeName constructorType =
      ParameterizedTypeName.get( ClassName.get( JsConstructorFn.class ), nativeComponent );

    final FieldSpec.Builder field =
      FieldSpec.builder( constructorType,
                         "TYPE",
                         Modifier.STATIC,
                         Modifier.FINAL,
                         Modifier.PUBLIC ).
        initializer( "getConstrutorFunction()" );
    builder.addField( field.build() );

    final MethodSpec.Builder method =
      MethodSpec.methodBuilder( "getConstrutorFunction" ).
        addAnnotation( Nonnull.class ).
        addModifiers( Modifier.STATIC, Modifier.PRIVATE ).
        returns( constructorType );

    method.addStatement( "final $T constructorFn = $T.of( $T.class ) ",
                         constructorType,
                         JsConstructorFn.class,
                         nativeComponent );
    method.addStatement( "$T.invariant( () -> null != constructorFn,\n" +
                         "              () -> \"Unable to locate constructor function for " +
                         descriptor.getName() + " defined by class " + element.getQualifiedName().toString() + "\" )",
                         Guards.class );
    method.addStatement( "assert null != constructorFn" );

    final CodeBlock.Builder codeBlock = CodeBlock.builder();
    codeBlock.beginControlFlow( "if ( $T.enableComponentNames() )", ReactConfig.class );
    codeBlock.addStatement( "$T.of( constructorFn ).set( \"displayName\", $S )",
                            JsPropertyMap.class,
                            descriptor.getName() );
    codeBlock.endControlFlow();

    method.addCode( codeBlock.build() );
    method.addStatement( "return constructorFn" );

    builder.addMethod( method.build() );

    return builder.build();
  }

  @Nonnull
  static TypeSpec buildNativeComponent( @Nonnull final ComponentDescriptor descriptor )
  {
    final TypeElement element = descriptor.getElement();

    final StringBuilder name = new StringBuilder( descriptor.getNativeComponentName() );

    TypeElement t = element;
    while ( NestingKind.TOP_LEVEL != t.getNestingKind() )
    {
      t = (TypeElement) t.getEnclosingElement();
      name.insert( 0, t.getSimpleName() + "$" );
    }

    final TypeSpec.Builder builder = TypeSpec.classBuilder( name.toString() );

    //Ensure it can not be subclassed
    builder.addModifiers( Modifier.FINAL );

    builder.addAnnotation( AnnotationSpec.builder( JsType.class ).build() );
    // Mark it as generated
    builder.addAnnotation( AnnotationSpec.builder( Generated.class ).
      addMember( "value", "$S", ReactProcessor.class.getName() ).
      build() );

    final TypeName superType =
      ParameterizedTypeName.get( ClassName.get( NativeAdapterComponent.class ),
                                 ClassName.get( descriptor.getPropsType().asType() ),
                                 ClassName.get( descriptor.getStateType().asType() ),
                                 ClassName.get( descriptor.getElement() ) );

    builder.superclass( superType );

    // build the constructor
    {
      final ParameterSpec.Builder props =
        ParameterSpec.builder( ClassName.get( descriptor.getPropsType() ), "props", Modifier.FINAL ).
          addAnnotation( Nonnull.class );
      final MethodSpec.Builder method =
        MethodSpec.constructorBuilder().
          addAnnotation( JsConstructor.class ).
          addModifiers( Modifier.PRIVATE ).
          addParameter( props.build() );
      method.addStatement( "super( props )" );
      builder.addMethod( method.build() );
    }

    // build createComponent
    {
      final MethodSpec.Builder method =
        MethodSpec.methodBuilder( "createComponent" ).
          addAnnotation( Override.class ).
          addModifiers( Modifier.PROTECTED ).
          returns( ClassName.get( descriptor.getElement() ) );
      method.addStatement( "return new $T()",
                           ClassName.get( descriptor.getPackageName(), descriptor.getTypeToCreate() ) );
      builder.addMethod( method.build() );
    }

    // Lifecycle methods
    {

      for ( final MethodDescriptor lifecycleMethod : descriptor.getLifecycleMethods() )
      {
        final String methodName = lifecycleMethod.getMethod().getSimpleName().toString();
        final MethodSpec.Builder method =
          MethodSpec.methodBuilder( methodName ).
            addModifiers( Modifier.PUBLIC ).
            returns( ClassName.get( lifecycleMethod.getMethodType().getReturnType() ) );

        ProcessorUtil.copyTypeParameters( lifecycleMethod.getMethodType(), method );

        final StringJoiner params = new StringJoiner( "," );
        final List<? extends VariableElement> sourceParameters = lifecycleMethod.getMethod().getParameters();
        final List<? extends TypeMirror> sourceParameterTypes = lifecycleMethod.getMethodType().getParameterTypes();
        final int parameterCount = sourceParameters.size();
        for ( int i = 0; i < parameterCount; i++ )
        {
          final VariableElement parameter = sourceParameters.get( i );
          final TypeMirror parameterType = sourceParameterTypes.get( i );
          final String parameterName = parameter.getSimpleName().toString();
          final ParameterSpec.Builder parameterSpec =
            ParameterSpec.builder( TypeName.get( parameterType ), parameterName, Modifier.FINAL ).
              addAnnotation( Nonnull.class );
          method.addParameter( parameterSpec.build() );
          params.add( parameterName );
        }

        final StringBuilder sb = new StringBuilder();
        if ( TypeKind.VOID != lifecycleMethod.getMethodType().getReturnType().getKind() )
        {
          sb.append( "return " );
        }

        sb.append( "perform" );
        sb.append( Character.toUpperCase( methodName.charAt( 0 ) ) );
        sb.append( methodName.substring( 1 ) );
        sb.append( "(" );
        sb.append( params.toString() );
        sb.append( ")" );

        method.addStatement( sb.toString() );
        builder.addMethod( method.build() );
      }
    }

    return builder.build();
  }
}
