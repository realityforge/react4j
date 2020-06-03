package com.example.package_access.other;

import react4j.annotations.Prop;
import react4j.annotations.PropDefault;

public abstract class BasePropDefaultFieldModel
{
  @PropDefault( name = "myProp" )
  static final String MY_PROP = "Foo";

  @Prop
  protected abstract String getMyProp();
}
