package com.example.callback;

import elemental2.core.JsObject;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import react4j.annotations.Callback;
import react4j.core.BaseState;
import react4j.core.ComponentConstructorFunction;
import react4j.core.NativeAdapterComponent;
import react4j.core.ReactConfig;

@Generated("react4j.processor.ReactProcessor")
class React4j_CustomName extends CustomName {
  static final ComponentConstructorFunction TYPE = getConstructorFunction();

  @Nonnull
  private final Callback.Procedure _handleFoo = create_handleFoo();

  @Nonnull
  private static ComponentConstructorFunction getConstructorFunction() {
    final ComponentConstructorFunction componentConstructor = NativeReactComponent::new;
    if ( ReactConfig.enableComponentNames() ) {
      Js.asPropertyMap( componentConstructor ).set( "displayName", "CustomName" );
    }
    return componentConstructor;
  }

  @Nonnull
  static Callback.Procedure _handleFoo(@Nonnull final CustomName component) {
    return ((React4j_CustomName) component)._handleFoo;
  }

  @Nonnull
  private Callback.Procedure create_handleFoo() {
    final Callback.Procedure handler = () -> this.handleFoo();
    if( ReactConfig.enableComponentNames() ) {
      JsObject.defineProperty( Js.cast( handler ), "name", Js.cast( JsPropertyMap.of( "value", "CustomName.fox" ) ) );
    }
    return handler;
  }

  private static final class NativeReactComponent extends NativeAdapterComponent<BaseState, CustomName> {
    NativeReactComponent(@Nullable final JsPropertyMap<Object> props) {
      super( props );
    }

    @Override
    protected CustomName createComponent() {
      return new React4j_CustomName();
    }
  }
}