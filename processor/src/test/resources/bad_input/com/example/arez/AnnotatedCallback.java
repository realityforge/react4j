package com.example.arez;

import arez.annotations.Action;
import javax.annotation.Nullable;
import react4j.annotations.Callback;
import react4j.annotations.ReactComponent;
import react4j.arez.ReactArezComponent;
import react4j.core.ReactNode;

@ReactComponent
abstract class AnnotatedCallback
  extends ReactArezComponent
{
  @Nullable
  @Override
  protected ReactNode render()
  {
    return null;
  }

  @Callback
  @Action
  void handleFoo()
  {
  }
}