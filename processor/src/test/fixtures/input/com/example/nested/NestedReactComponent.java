package com.example.nested;

import react4j.ReactNode;
import react4j.annotations.ReactComponent;
import react4j.annotations.Render;

public class NestedReactComponent
{
  @ReactComponent
  static abstract class BasicReactComponent
  {
    @Render
    ReactNode render()
    {
      return null;
    }
  }
}
