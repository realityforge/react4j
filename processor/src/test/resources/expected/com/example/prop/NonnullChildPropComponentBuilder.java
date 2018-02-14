package com.example.prop;

import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import react4j.core.React;
import react4j.core.ReactNode;

@Generated("react4j.processor.ReactProcessor")
class NonnullChildPropComponentBuilder {
  private NonnullChildPropComponentBuilder() {
  }

  @Nonnull
  static Builder2 key(@Nonnull final String key) {
    return new Builder().key( key );
  }

  @Nonnull
  static ReactNode child(@Nonnull final ReactNode child) {
    return new Builder().child( child );
  }

  public interface Builder1 {
    @Nonnull
    Builder2 key(@Nonnull String key);
  }

  public interface Builder2 {
    @Nonnull
    ReactNode child(@Nonnull ReactNode child);
  }

  private static class Builder implements Builder1, Builder2 {
    private final JsPropertyMap<Object> _props = JsPropertyMap.of();

    private ReactNode _child;

    @Override
    @Nonnull
    public final Builder2 key(@Nonnull final String key) {
      _props.set( "key", Objects.requireNonNull( key ) );
      return this;
    }

    @Override
    @Nonnull
    public final ReactNode child(@Nonnull final ReactNode child) {
      _child = Objects.requireNonNull( child );
      return build();
    }

    @Nonnull
    public final ReactNode build() {
      return React.createElement( NonnullChildPropComponent_.TYPE, Js.uncheckedCast( _props ), _child );
    }
  }
}