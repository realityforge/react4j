package com.example.prop;

import java.util.Objects;
import javax.annotation.Nonnull;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import react4j.core.React;
import react4j.core.ReactNode;

class GenericPropComponentBuilder {
  private GenericPropComponentBuilder() {
  }

  @Nonnull
  static Builder2 key(@Nonnull final String key) {
    return new Builder().key( key );
  }

  @Nonnull
  static <T> ReactNode value(@Nonnull final T value) {
    return new Builder().value( value );
  }

  public interface Builder1 {
    Builder2 key(@Nonnull String key);
  }

  public interface Builder2 {
    <T> ReactNode value(@Nonnull T value);
  }

  private static class Builder implements Builder1, Builder2 {
    private final JsPropertyMap<Object> _props = JsPropertyMap.of();

    @Override
    @Nonnull
    public final Builder2 key(@Nonnull final String key) {
      _props.set( "key", Objects.requireNonNull( key ) );
      return this;
    }

    @Override
    @Nonnull
    public final <T> ReactNode value(@Nonnull final T value) {
      _props.set( "value", Objects.requireNonNull( value ) );
      return React.createElement( GenericPropComponent_.TYPE, Js.uncheckedCast( _props ) );
    }
  }
}
