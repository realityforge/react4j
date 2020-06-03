package com.example.post_mount_or_update;

import react4j.ReactNode;
import react4j.annotations.PostMountOrUpdate;
import react4j.annotations.ReactComponent;
import react4j.annotations.Render;

@ReactComponent
abstract class ParametersModel
{
  @PostMountOrUpdate
  void postRender( int x )
  {
  }

  @Render
  ReactNode render()
  {
    return null;
  }
}
