package com.example.prop;

import javax.annotation.Nullable;
import react4j.Component;
import react4j.ReactNode;
import react4j.annotations.Prop;
import react4j.annotations.ReactComponent;

@ReactComponent
abstract class ImmutablePropTypePrimitiveDouble
  extends Component
{
  @Prop( immutable = true )
  protected abstract double getMyProp();

  @Nullable
  @Override
  protected ReactNode render()
  {
    return null;
  }
}
