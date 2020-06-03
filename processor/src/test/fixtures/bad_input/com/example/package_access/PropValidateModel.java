package com.example.package_access;

import com.example.package_access.other.BasePropValidateModel;
import javax.annotation.Nullable;
import react4j.ReactNode;
import react4j.annotations.ReactComponent;
import react4j.annotations.Render;

@ReactComponent
public abstract class PropValidateModel
  extends BasePropValidateModel
{
  @Nullable
  @Render
  ReactNode render()
  {
    return null;
  }
}
