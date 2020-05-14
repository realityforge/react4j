package com.example.prop;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import react4j.Context;
import react4j.Contexts;
import react4j.ReactElement;
import react4j.ReactNode;

@Generated("react4j.processor.React4jProcessor")
final class QualifiedContextPropModelBuilder {
  private QualifiedContextPropModelBuilder() {
  }

  @Nonnull
  private static Step1 newBuilder() {
    return new Builder();
  }

  @Nonnull
  static ReactNode build() {
    return newBuilder().build();
  }

  public interface Step1 {
    @Nonnull
    ReactNode build();
  }

  private static class ContextHolder {
    @Nonnull
    private static final Context<String> CONTEXT_myProp = Contexts.get( String.class, "my-proppo" );

    private ContextHolder() {
    }
  }

  private static class Builder implements Step1 {
    private final ReactElement _element = ReactElement.createComponentElement( React4j_QualifiedContextPropModel.Factory.TYPE );

    @Nonnull
    private ReactNode build(@Nonnull final ReactElement element) {
      element.complete();
      return element;
    }

    @Nonnull
    public final ReactNode build() {
      return ContextHolder.CONTEXT_myProp.consumer().render( v0 -> build( _element.prop( React4j_QualifiedContextPropModel.Props.myProp, v0 ).dup() ) );
    }
  }
}