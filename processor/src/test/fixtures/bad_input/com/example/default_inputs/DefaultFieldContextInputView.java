package com.example.default_inputs;

import javax.annotation.Nullable;
import react4j.ReactNode;
import react4j.annotations.Input;
import react4j.annotations.InputDefault;
import react4j.annotations.Render;
import react4j.annotations.View;

@View
abstract class DefaultFieldContextInputView
{
  @InputDefault
  static final String DEFAULT_MY_INPUT = "Foo";

  @Input( source = Input.Source.CONTEXT )
  abstract String getMyInput();

  @Nullable
  @Render
  ReactNode render()
  {
    return null;
  }
}
