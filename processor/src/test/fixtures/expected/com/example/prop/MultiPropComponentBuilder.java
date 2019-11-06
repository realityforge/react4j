package com.example.prop;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import react4j.ReactElement;
import react4j.ReactNode;

@Generated("react4j.processor.ReactProcessor")
final class MultiPropComponentBuilder {
  private MultiPropComponentBuilder() {
  }

  @Nonnull
  static Step2 myProp(final String myProp) {
    return new Builder().myProp( myProp );
  }

  public interface Step1 {
    @Nonnull
    Step2 myProp(String myProp);
  }

  public interface Step2 {
    @Nonnull
    ReactNode myProp2(String myProp2);
  }

  private static class Builder implements Step1, Step2 {
    private final ReactElement _element = ReactElement.createComponentElement( React4j_MultiPropComponent.Factory.TYPE );

    @Override
    @Nonnull
    public final Step2 myProp(final String myProp) {
      _element.props().set( React4j_MultiPropComponent.Props.myProp, myProp );
      return this;
    }

    @Override
    @Nonnull
    public final ReactNode myProp2(final String myProp2) {
      _element.props().set( React4j_MultiPropComponent.Props.myProp2, myProp2 );
      return build();
    }

    @Nonnull
    public final ReactNode build() {
      _element.complete();
      return _element;
    }
  }
}