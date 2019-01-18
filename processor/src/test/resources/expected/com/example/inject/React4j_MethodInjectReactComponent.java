package com.example.inject;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import jsinterop.annotations.JsConstructor;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.realityforge.braincheck.Guards;
import react4j.React;
import react4j.internal.ComponentConstructorFunction;
import react4j.internal.NativeAdapterComponent;

@Generated("react4j.processor.ReactProcessor")
class React4j_MethodInjectReactComponent extends MethodInjectReactComponent {
  @Inject
  React4j_MethodInjectReactComponent() {
  }

  @Nonnull
  private static ComponentConstructorFunction getConstructorFunction() {
    final ComponentConstructorFunction componentConstructor = NativeReactComponent::new;
    if ( React.enableComponentNames() ) {
      Js.asPropertyMap( componentConstructor ).set( "displayName", "MethodInjectReactComponent" );
    }
    return componentConstructor;
  }

  static final class Factory {
    static final ComponentConstructorFunction TYPE = getConstructorFunction();
  }

  static final class InjectSupport {
    private static Provider<MethodInjectReactComponent> c_provider;

    static void setProvider(final Provider<MethodInjectReactComponent> provider) {
      c_provider = provider;
    }

    private static Provider<MethodInjectReactComponent> getProvider() {
      if ( React.shouldCheckInvariants() ) {
        Guards.invariant( () -> null != c_provider, () -> "Attempted to create an instance of the React4j component named 'MethodInjectReactComponent' before the dependency injection provider has been initialized. Please see the documentation at https://react4j.github.io/dependency_injection for directions how to configure dependency injection." );
      }
      return c_provider;
    }
  }

  private static final class NativeReactComponent extends NativeAdapterComponent<MethodInjectReactComponent> {
    @JsConstructor
    NativeReactComponent(@Nullable final JsPropertyMap<Object> props) {
      super( props );
    }

    @Override
    protected MethodInjectReactComponent createComponent() {
      return InjectSupport.getProvider().get();
    }
  }
}
