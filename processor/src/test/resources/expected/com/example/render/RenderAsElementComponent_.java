package com.example.render;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.base.JsPropertyMap;
import react4j.core.BaseProps;
import react4j.core.BaseState;
import react4j.core.ComponentConstructorFunction;
import react4j.core.NativeAdapterComponent;
import react4j.core.React;
import react4j.core.ReactConfig;
import react4j.core.ReactElement;
import react4j.core.ReactNode;

@Generated("react4j.processor.ReactProcessor")
class RenderAsElementComponent_ extends RenderAsElementComponent {
  private static final ComponentConstructorFunction<BaseProps, BaseState, NativeReactComponent> TYPE = getConstructorFunction();

  @Nonnull
  static ReactElement<BaseProps, NativeReactComponent> _create() {
    return React.createElement( TYPE );
  }

  @Nonnull
  static ReactElement<BaseProps, NativeReactComponent> _create(@Nullable final BaseProps props) {
    return React.createElement( TYPE, props );
  }

  @Nonnull
  static ReactElement<BaseProps, NativeReactComponent> _create(@Nullable final BaseProps props, @Nullable final ReactNode child) {
    return React.createElement( TYPE, props, child );
  }

  @Nonnull
  private static ComponentConstructorFunction<BaseProps, BaseState, NativeReactComponent> getConstructorFunction() {
    final ComponentConstructorFunction<BaseProps, BaseState, NativeReactComponent> componentConstructor = NativeReactComponent::new;
    if ( ReactConfig.enableComponentNames() ) {
      JsPropertyMap.of( componentConstructor ).set( "displayName", "RenderAsElementComponent" );
    }
    return componentConstructor;
  }

  @Override
  @Nullable
  protected ReactNode render() {
    return ReactNode.of( renderAsElement() );
  }

  static final class NativeReactComponent extends NativeAdapterComponent<BaseProps, BaseState, RenderAsElementComponent> {
    NativeReactComponent(@Nonnull final BaseProps props) {
      super( props );
    }

    @Override
    protected RenderAsElementComponent createComponent() {
      return new RenderAsElementComponent_();
    }
  }
}
