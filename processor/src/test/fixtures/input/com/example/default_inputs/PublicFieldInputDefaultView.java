package com.example.default_inputs;

import react4j.ReactNode;
import react4j.annotations.Input;
import react4j.annotations.InputDefault;
import react4j.annotations.Render;
import react4j.annotations.View;

@View
abstract class PublicFieldInputDefaultView
{
  @InputDefault
  public static final String DEFAULT_MY_PROP = "Foo";

  @Input
  abstract String getMyProp();

  @Render
  ReactNode render()
  {
    return null;
  }
}
