package com.example.prop_validate;

import react4j.ReactNode;
import react4j.annotations.Input;
import react4j.annotations.InputValidate;
import react4j.annotations.Render;
import react4j.annotations.View;

@View
abstract class Suppressed1PublicAccessPropValidateModel
{
  // This uses the SOURCE retention suppression
  @SuppressWarnings( "React4j:PublicMethod" )
  @InputValidate
  public void validateMyProp( String prop )
  {
  }

  @Input
  abstract String getMyProp();

  @Render
  ReactNode render()
  {
    return null;
  }
}
