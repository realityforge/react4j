package com.example.arez;

import arez.annotations.Autorun;
import javax.annotation.Nullable;
import react4j.annotations.ReactComponent;
import react4j.arez.ReactArezComponent;
import react4j.core.ReactNode;

@ReactComponent
abstract class AutorunArezReactComponent
  extends ReactArezComponent
{
  @Autorun
  void myAutorun()
  {
  }

  @Nullable
  @Override
  protected ReactNode render()
  {
    return null;
  }
}
