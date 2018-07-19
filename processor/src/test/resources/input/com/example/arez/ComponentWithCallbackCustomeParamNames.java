package com.example.arez;

import javax.annotation.Nullable;
import jsinterop.annotations.JsFunction;
import react4j.ReactNode;
import react4j.annotations.Callback;
import react4j.annotations.ReactComponent;
import react4j.arez.ReactArezComponent;

@ReactComponent
abstract class ComponentWithCallbackCustomeParamNames
  extends ReactArezComponent
{
  @JsFunction
  public interface CustomHandler
  {
    int onMouseEvent( int nameOnInterface );
  }

  @Nullable
  @Override
  protected ReactNode render()
  {
    return null;
  }

  @Callback( CustomHandler.class )
  int handleFoo2( int nameOnType )
  {
    return 0;
  }
}