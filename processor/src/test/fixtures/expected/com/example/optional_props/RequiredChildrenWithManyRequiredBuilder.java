package com.example.optional_props;

import elemental2.core.JsArray;
import java.util.stream.Stream;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import react4j.ReactElement;
import react4j.ReactNode;

@Generated("react4j.processor.ReactProcessor")
final class RequiredChildrenWithManyRequiredBuilder {
  private RequiredChildrenWithManyRequiredBuilder() {
  }

  @Nonnull
  static Step2 myRequiredProp1(final String myRequiredProp1) {
    return new Builder().myRequiredProp1( myRequiredProp1 );
  }

  public interface Step1 {
    @Nonnull
    Step2 myRequiredProp1(String myRequiredProp1);
  }

  public interface Step2 {
    @Nonnull
    Step3 myRequiredProp2(String myRequiredProp2);
  }

  public interface Step3 {
    @Nonnull
    Step4 myRequiredProp3(String myRequiredProp3);
  }

  public interface Step4 {
    @Nonnull
    ReactNode children(ReactNode... children);

    @Nonnull
    ReactNode children(@Nonnull Stream<? extends ReactNode> children);

    @Nonnull
    ReactNode build();
  }

  private static class Builder implements Step1, Step2, Step3, Step4 {
    private final ReactElement _element = ReactElement.createComponentElement( React4j_RequiredChildrenWithManyRequired.Factory.TYPE );

    @Override
    @Nonnull
    public final Step2 myRequiredProp1(final String myRequiredProp1) {
      _element.props().set( React4j_RequiredChildrenWithManyRequired.Props.myRequiredProp1, myRequiredProp1 );
      return this;
    }

    @Override
    @Nonnull
    public final Step3 myRequiredProp2(final String myRequiredProp2) {
      _element.props().set( React4j_RequiredChildrenWithManyRequired.Props.myRequiredProp2, myRequiredProp2 );
      return this;
    }

    @Override
    @Nonnull
    public final Step4 myRequiredProp3(final String myRequiredProp3) {
      _element.props().set( React4j_RequiredChildrenWithManyRequired.Props.myRequiredProp3, myRequiredProp3 );
      return this;
    }

    @Override
    @Nonnull
    public final ReactNode children(final ReactNode... children) {
      _element.props().set( React4j_RequiredChildrenWithManyRequired.Props.children, JsArray.of( children ) );
      return build();
    }

    @Override
    @Nonnull
    public final ReactNode children(@Nonnull final Stream<? extends ReactNode> children) {
      children( children.toArray( ReactNode[]::new ) );
      return build();
    }

    @Nonnull
    public final ReactNode build() {
      _element.complete();
      return _element;
    }
  }
}