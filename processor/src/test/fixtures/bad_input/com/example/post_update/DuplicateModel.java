package com.example.post_update;

import react4j.ReactNode;
import react4j.annotations.PostUpdate;
import react4j.annotations.ReactComponent;
import react4j.annotations.Render;

@ReactComponent
abstract class DuplicateModel
{
  @PostUpdate
  void postUpdate()
  {
  }

  @PostUpdate
  void postUpdate2()
  {
  }

  @Render
  ReactNode render()
  {
    return null;
  }
}
