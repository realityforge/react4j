package com.example.prop;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsConstructor;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import react4j.React;
import react4j.internal.ComponentConstructorFunction;
import react4j.internal.NativeAdapterComponent;
import react4j.internal.NativeComponent;

@Generated("react4j.processor.ReactProcessor")
class React4j_NonJavaBeanPropComponent extends NonJavaBeanPropComponent {
  React4j_NonJavaBeanPropComponent(@Nonnull final NativeComponent nativeComponent) {
    bindComponent( nativeComponent );
  }

  @Nonnull
  private static ComponentConstructorFunction getConstructorFunction() {
    final ComponentConstructorFunction componentConstructor = NativeReactComponent::new;
    if ( React.enableComponentNames() ) {
      Js.asPropertyMap( componentConstructor ).set( "displayName", "NonJavaBeanPropComponent" );
    }
    return componentConstructor;
  }

  @Override
  protected String window() {
    if ( React.shouldCheckInvariants() ) {
      return null != props().getAny( Props.window ) ? props().getAny( Props.window ).asString() : null;
    } else {
      return Js.uncheckedCast( props().getAny( Props.window ) );
    }
  }

  static final class Factory {
    static final ComponentConstructorFunction TYPE = getConstructorFunction();
  }

  static final class Props {
    static final String window = React.shouldMinimizePropKeys() ? "a" : "window";
  }

  private static final class NativeReactComponent extends NativeAdapterComponent<NonJavaBeanPropComponent> {
    @JsConstructor
    NativeReactComponent(@Nullable final JsPropertyMap<Object> props) {
      super( props );
    }

    @Override
    protected NonJavaBeanPropComponent createComponent() {
      return new React4j_NonJavaBeanPropComponent( this );
    }
  }
}
