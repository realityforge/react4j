package com.example.prop;

import arez.annotations.PostConstruct;
import javax.annotation.Nullable;
import react4j.ReactNode;
import react4j.annotations.Input;
import react4j.annotations.Render;
import react4j.annotations.SuppressReact4jWarnings;
import react4j.annotations.View;

@View
abstract class MutablePropAndPostConstructWithReact4jSuppressComponent
{
  @SuppressReact4jWarnings( "React4j:MutablePropAccessedInPostConstruct" )
  @Input
  abstract String getMyProp();

  @PostConstruct
  void postConstruct()
  {
  }

  @Nullable
  @Render
  ReactNode render()
  {
    return null;
  }
}
