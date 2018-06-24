package com.example.state;

import javax.annotation.Nullable;
import react4j.Component;
import react4j.ReactNode;
import react4j.annotations.ReactComponent;
import react4j.annotations.State;

@ReactComponent
abstract class GetterHasNoReturnValue
  extends Component
{
  @State
  protected abstract void getMyKey();

  @State
  protected abstract void setMyKey( String value );

  @Nullable
  @Override
  protected ReactNode render()
  {
    return null;
  }
}
