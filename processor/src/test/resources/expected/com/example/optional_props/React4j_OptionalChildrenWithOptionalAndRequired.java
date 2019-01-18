package com.example.optional_props;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsConstructor;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import react4j.ReactConfig;
import react4j.ReactNode;
import react4j.internal.ComponentConstructorFunction;
import react4j.internal.NativeAdapterComponent;

@Generated("react4j.processor.ReactProcessor")
class React4j_OptionalChildrenWithOptionalAndRequired extends OptionalChildrenWithOptionalAndRequired {
  @Nonnull
  private static ComponentConstructorFunction getConstructorFunction() {
    final ComponentConstructorFunction componentConstructor = NativeReactComponent::new;
    if ( ReactConfig.enableComponentNames() ) {
      Js.asPropertyMap( componentConstructor ).set( "displayName", "OptionalChildrenWithOptionalAndRequired" );
    }
    return componentConstructor;
  }

  @Override
  protected String getMyRequiredProp() {
    if ( ReactConfig.shouldCheckInvariants() ) {
      return null != props().getAny( Props.myRequiredProp ) ? props().getAny( Props.myRequiredProp ).asString() : null;
    } else {
      return Js.uncheckedCast( props().getAny( Props.myRequiredProp ) );
    }
  }

  @Override
  protected String getMyProp() {
    if ( ReactConfig.shouldCheckInvariants() ) {
      return null != props().getAny( Props.myProp ) ? props().getAny( Props.myProp ).asString() : null;
    } else {
      return Js.uncheckedCast( props().getAny( Props.myProp ) );
    }
  }

  @Override
  protected ReactNode[] getChildren() {
    if ( ReactConfig.shouldCheckInvariants() ) {
      return null != props().getAny( Props.children ) ? props().getAny( Props.children ).cast() : null;
    } else {
      return Js.uncheckedCast( props().getAny( Props.children ) );
    }
  }

  static final class Factory {
    static final ComponentConstructorFunction TYPE = getConstructorFunction();
  }

  static final class Props {
    static final String myRequiredProp = ReactConfig.shouldMinimizePropKeys() ? "a" : "myRequiredProp";

    static final String myProp = ReactConfig.shouldMinimizePropKeys() ? "b" : "myProp";

    static final String children = "children";
  }

  private static final class NativeReactComponent extends NativeAdapterComponent<OptionalChildrenWithOptionalAndRequired> {
    @JsConstructor
    NativeReactComponent(@Nullable final JsPropertyMap<Object> props) {
      super( props );
    }

    @Override
    protected OptionalChildrenWithOptionalAndRequired createComponent() {
      return new React4j_OptionalChildrenWithOptionalAndRequired();
    }
  }
}
