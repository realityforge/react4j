package com.example.post_mount;

import react4j.ReactNode;
import react4j.annotations.PostMount;
import react4j.annotations.ReactComponent;
import react4j.annotations.Render;

@ReactComponent
abstract class ProtectedAccessPostMountModel
{
  @PostMount
  protected void postMount()
  {
  }

  @Render
  ReactNode render()
  {
    return null;
  }
}
