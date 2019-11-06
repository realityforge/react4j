package com.example.prop;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import react4j.ReactElement;
import react4j.ReactNode;

@Generated("react4j.processor.ReactProcessor")
final class PropTypeLongBuilder {
  private PropTypeLongBuilder() {
  }

  @Nonnull
  static ReactNode myProp(final long myProp) {
    return new Builder().myProp( myProp );
  }

  public interface Step1 {
    @Nonnull
    ReactNode myProp(long myProp);
  }

  private static class Builder implements Step1 {
    private final ReactElement _element = ReactElement.createComponentElement( React4j_PropTypeLong.Factory.TYPE );

    @Override
    @Nonnull
    public final ReactNode myProp(final long myProp) {
      _element.props().set( React4j_PropTypeLong.Props.myProp, myProp );
      return build();
    }

    @Nonnull
    public final ReactNode build() {
      _element.complete();
      return _element;
    }
  }
}