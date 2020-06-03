package com.example.default_props;

import react4j.ReactNode;
import react4j.annotations.Prop;
import react4j.annotations.PropDefault;
import react4j.annotations.ReactComponent;
import react4j.annotations.Render;

@ReactComponent
abstract class DuplicatePropDefault3
{
  @PropDefault
  static final String DEFAULT_MY_PROP = "Foo";
  @PropDefault( name = "myProp" )
  static final String MY_PROP = "Foo";

  @Prop
  protected abstract String getMyProp();

  @Render
  ReactNode render()
  {
    return null;
  }
}
