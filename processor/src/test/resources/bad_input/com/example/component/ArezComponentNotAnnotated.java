package com.example.component;

import javax.annotation.Nullable;
import react.annotations.ReactComponent;
import react.arez.ReactArezComponent;
import react.core.BaseProps;
import react.core.BaseState;
import react.core.ReactElement;

@ReactComponent
class ArezComponentNotAnnotated
  extends ReactArezComponent<BaseProps, BaseState>
{
  @Nullable
  @Override
  protected ReactElement<?, ?> doRender()
  {
    return null;
  }
}
