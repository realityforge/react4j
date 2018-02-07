package com.example.prop;

import java.util.Objects;
import javax.annotation.Nonnull;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import react4j.core.React;
import react4j.core.ReactNode;

class NonJavaBeanPropComponentBuilder {
  private NonJavaBeanPropComponentBuilder() {
  }

  @Nonnull
  static Builder2 key(@Nonnull final String key) {
    return new Builder().key( key );
  }

  @Nonnull
  static ReactNode window(@Nonnull final String window) {
    return new Builder().window( window );
  }

  public interface Builder1 {
    Builder2 key(@Nonnull String key);
  }

  public interface Builder2 {
    ReactNode window(@Nonnull String window);
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
    public final ReactNode window(@Nonnull final String window) {
      _props.set( "window", Objects.requireNonNull( window ) );
      return React.createElement( NonJavaBeanPropComponent_.TYPE, Js.uncheckedCast( _props ) );
    }
  }
}
