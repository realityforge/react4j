package com.example.prop;

import arez.ObservableValue;
import arez.annotations.Action;
import arez.annotations.ArezComponent;
import arez.annotations.Observable;
import arez.annotations.ObservableValueRef;
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

@ArezComponent(
    name = "ObservableViaObservedProp",
    deferSchedule = true
)
@Generated("react4j.processor.ReactProcessor")
abstract class React4j_ObservableViaObservedProp extends ObservableViaObservedProp {
  @Nonnull
  private static ComponentConstructorFunction getConstructorFunction() {
    final ComponentConstructorFunction componentConstructor = ( ReactConfig.shouldStoreDebugDataAsState() || ReactConfig.shouldValidatePropValues() ) ? NativeReactComponent::new : LiteNativeReactComponent::new;
    if ( ReactConfig.enableComponentNames() ) {
      Js.asPropertyMap( componentConstructor ).set( "displayName", "ObservableViaObservedProp" );
    }
    return componentConstructor;
  }

  @Override
  @Observable(
      name = "value",
      expectSetter = false,
      readOutsideTransaction = true
  )
  protected Object getValue() {
    if ( ReactConfig.shouldCheckInvariants() ) {
      return null != props().getAny( Props.value ) ? props().getAny( Props.value ).cast() : null;
    } else {
      return Js.uncheckedCast( props().getAny( Props.value ) );
    }
  }

  @Nonnull
  @ObservableValueRef
  protected abstract ObservableValue getValueObservableValue();

  @Override
  @Action(
      verifyRequired = false
  )
  protected boolean reportPropChanges(@Nonnull final JsPropertyMap<Object> props,
      @Nonnull final JsPropertyMap<Object> nextProps, final boolean inComponentPreUpdate) {
    boolean modified = false;
    final boolean reportChanges = shouldReportPropChanges( inComponentPreUpdate );
    if ( !Js.isTripleEqual( props.get( Props.value ), nextProps.get( Props.value ) ) ) {
      if ( reportChanges ) {
        getValueObservableValue().reportChanged();
      }
      modified = true;
    }
    return modified || hasRenderDepsChanged();
  }

  @Action(
      verifyRequired = false
  )
  protected void $$react4j$$_componentPreUpdate(@Nullable final JsPropertyMap<Object> prevProps) {
    if ( null != prevProps ) {
      final JsPropertyMap<Object> props = props();
      reportPropChanges( prevProps, props, true );
    }
  }

  void $$react4j$$_componentDidMount() {
    storeDebugDataAsState();
  }

  @Override
  protected void componentDidUpdate(@Nullable final JsPropertyMap<Object> prevProps) {
    storeDebugDataAsState();
  }

  @Override
  protected final void triggerScheduler() {
    getContext().triggerScheduler();
  }

  static final class Factory {
    static final ComponentConstructorFunction TYPE = getConstructorFunction();
  }

  static final class Props {
    static final String value = ReactConfig.shouldMinimizePropKeys() ? "a" : "value";
  }

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "?"
  )
  interface LiteLifecycle {
    Object getSnapshotBeforeUpdate(@Nonnull JsPropertyMap<Object> prevProps,
        @Nonnull JsPropertyMap<Object> prevState);

    void componentWillUnmount();

    boolean shouldComponentUpdate(@Nonnull JsPropertyMap<Object> nextProps);
  }

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "?"
  )
  interface Lifecycle {
    void componentDidMount();

    Object getSnapshotBeforeUpdate(@Nonnull JsPropertyMap<Object> prevProps,
        @Nonnull JsPropertyMap<Object> prevState);

    void componentDidUpdate(@Nonnull JsPropertyMap<Object> prevProps);

    void componentWillUnmount();

    boolean shouldComponentUpdate(@Nonnull JsPropertyMap<Object> nextProps);
  }

  private static final class LiteNativeReactComponent extends NativeAdapterComponent<ObservableViaObservedProp> implements LiteLifecycle {
    @JsConstructor
    LiteNativeReactComponent(@Nullable final JsPropertyMap<Object> props) {
      super( props );
    }

    @Override
    protected ObservableViaObservedProp createComponent() {
      return new Arez_React4j_ObservableViaObservedProp();
    }

    @Override
    public Object getSnapshotBeforeUpdate(@Nonnull final JsPropertyMap<Object> prevProps,
        @Nonnull final JsPropertyMap<Object> prevState) {
      ((Arez_React4j_ObservableViaObservedProp) component() ).$$react4j$$_componentPreUpdate( prevProps );
      return null;
    }

    @Override
    public void componentWillUnmount() {
      performComponentWillUnmount();
    }

    @Override
    public boolean shouldComponentUpdate(@Nonnull final JsPropertyMap<Object> nextProps) {
      return performShouldComponentUpdate( nextProps );
    }
  }

  private static final class NativeReactComponent extends NativeAdapterComponent<ObservableViaObservedProp> implements Lifecycle {
    @JsConstructor
    NativeReactComponent(@Nullable final JsPropertyMap<Object> props) {
      super( props );
    }

    @Override
    protected ObservableViaObservedProp createComponent() {
      return new Arez_React4j_ObservableViaObservedProp();
    }

    @Override
    public void componentDidMount() {
      ((Arez_React4j_ObservableViaObservedProp) component() ).$$react4j$$_componentDidMount();
    }

    @Override
    public Object getSnapshotBeforeUpdate(@Nonnull final JsPropertyMap<Object> prevProps,
        @Nonnull final JsPropertyMap<Object> prevState) {
      ((Arez_React4j_ObservableViaObservedProp) component() ).$$react4j$$_componentPreUpdate( prevProps );
      return null;
    }

    @Override
    public void componentDidUpdate(@Nonnull final JsPropertyMap<Object> prevProps) {
      performComponentDidUpdate( prevProps );
    }

    @Override
    public void componentWillUnmount() {
      performComponentWillUnmount();
    }

    @Override
    public boolean shouldComponentUpdate(@Nonnull final JsPropertyMap<Object> nextProps) {
      return performShouldComponentUpdate( nextProps );
    }
  }
}
