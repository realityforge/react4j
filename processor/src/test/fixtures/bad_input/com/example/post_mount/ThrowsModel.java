package com.example.post_mount;

import java.io.IOException;
import react4j.ReactNode;
import react4j.annotations.PostMount;
import react4j.annotations.ReactComponent;
import react4j.annotations.Render;

@ReactComponent
abstract class ThrowsModel
{
  @PostMount
  void postMount()
    throws IOException
  {
  }

  @Render
  ReactNode render()
  {
    return null;
  }
}
