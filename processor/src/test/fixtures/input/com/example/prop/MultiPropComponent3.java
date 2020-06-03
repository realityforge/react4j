package com.example.prop;

import javax.annotation.Nullable;
import react4j.ReactNode;
import react4j.annotations.Prop;
import react4j.annotations.ReactComponent;
import react4j.annotations.Render;

@ReactComponent
abstract class MultiPropComponent3
{
  @Prop
  abstract ReactNode getChild();

  @Prop
  abstract String getMyProp();

  @Prop
  abstract String getMyProp2();

  @Nullable
  @Render
  ReactNode render()
  {
    return null;
  }
}
