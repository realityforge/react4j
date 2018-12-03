package com.example.post_mount;

import react4j.Component;
import react4j.ReactNode;
import react4j.annotations.PostMount;
import react4j.annotations.ReactComponent;

@ReactComponent
abstract class StaticModel
  extends Component
{
  @PostMount
  static void postMount()
  {
  }

  @Override
  protected ReactNode render()
  {
    return null;
  }
}