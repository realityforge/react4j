package com.example.default_props;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import react4j.ComponentConstructorFunction;
import react4j.NativeAdapterComponent;
import react4j.ReactConfig;

@Generated("react4j.processor.ReactProcessor")
class React4j_PublicMethodPropDefault extends PublicMethodPropDefault {
  @Nonnull
  private static ComponentConstructorFunction getConstructorFunction() {
    final ComponentConstructorFunction componentConstructor = ( ReactConfig.shouldStoreDebugDataAsState() || ReactConfig.shouldValidatePropValues() ) ? NativeReactComponent::new : LiteNativeReactComponent::new;
    if ( ReactConfig.enableComponentNames() ) {
      Js.asPropertyMap( componentConstructor ).set( "displayName", "PublicMethodPropDefault" );
    }
    return componentConstructor;
  }

  @Override
  protected String getMyProp() {
    if ( ReactConfig.shouldCheckInvariants() ) {
      return null != props().getAny( Props.myProp ) ? props().getAny( Props.myProp ).asString() : null;
    } else {
      return Js.uncheckedCast( props().getAny( Props.myProp ) );
    }
  }

  void $$react4j$$_componentDidMount() {
    storeDebugDataAsState();
  }

  @Override
  protected void componentDidUpdate(@Nullable final JsPropertyMap<Object> prevProps) {
    storeDebugDataAsState();
  }

  static final class Factory {
    static final ComponentConstructorFunction TYPE = getConstructorFunction();
  }

  static final class Props {
    static final String myProp = ReactConfig.shouldMinimizePropKeys() ? "a" : "myProp";
  }

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "?"
  )
  interface Lifecycle {
    void componentDidMount();

    void componentDidUpdate(@Nonnull JsPropertyMap<Object> prevProps);
  }

  private static final class LiteNativeReactComponent extends NativeAdapterComponent<PublicMethodPropDefault> {
    @JsConstructor
    LiteNativeReactComponent(@Nullable final JsPropertyMap<Object> props) {
      super( props );
    }

    @Override
    protected PublicMethodPropDefault createComponent() {
      return new React4j_PublicMethodPropDefault();
    }
  }

  private static final class NativeReactComponent extends NativeAdapterComponent<PublicMethodPropDefault> implements Lifecycle {
    @JsConstructor
    NativeReactComponent(@Nullable final JsPropertyMap<Object> props) {
      super( props );
    }

    @Override
    protected PublicMethodPropDefault createComponent() {
      return new React4j_PublicMethodPropDefault();
    }

    @Override
    public void componentDidMount() {
      ((React4j_PublicMethodPropDefault) component() ).$$react4j$$_componentDidMount();
    }

    @Override
    public void componentDidUpdate(@Nonnull final JsPropertyMap<Object> prevProps) {
      performComponentDidUpdate( prevProps );
    }
  }
}
