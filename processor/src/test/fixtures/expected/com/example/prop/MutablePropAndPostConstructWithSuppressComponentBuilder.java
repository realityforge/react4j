package com.example.prop;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import react4j.ReactElement;
import react4j.ReactNode;

@Generated("react4j.processor.ReactProcessor")
final class MutablePropAndPostConstructWithSuppressComponentBuilder {
  private MutablePropAndPostConstructWithSuppressComponentBuilder() {
  }

  @Nonnull
  static ReactNode myProp(
      @SuppressWarnings("React4j:MutablePropAccessedInPostConstruct") final String myProp) {
    return new Builder().myProp( myProp );
  }

  public interface Step1 {
    @Nonnull
    ReactNode myProp(@SuppressWarnings("React4j:MutablePropAccessedInPostConstruct") String myProp);
  }

  private static class Builder implements Step1 {
    private final ReactElement _element = ReactElement.createComponentElement( React4j_MutablePropAndPostConstructWithSuppressComponent.Factory.TYPE );

    @Override
    @Nonnull
    public final ReactNode myProp(
        @SuppressWarnings("React4j:MutablePropAccessedInPostConstruct") final String myProp) {
      _element.props().set( React4j_MutablePropAndPostConstructWithSuppressComponent.Props.myProp, myProp );
      return build();
    }

    @Nonnull
    public final ReactNode build() {
      _element.complete();
      return _element;
    }
  }
}