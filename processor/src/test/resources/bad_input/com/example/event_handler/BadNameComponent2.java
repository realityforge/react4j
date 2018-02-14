package com.example.event_handler;

import react4j.annotations.EventHandler;
import react4j.annotations.ReactComponent;
import react4j.core.BaseState;
import react4j.core.Component;
import react4j.core.ReactNode;

@ReactComponent
abstract class BadNameComponent2
  extends Component<BaseState>
{
  @Override
  protected ReactNode render()
  {
    return null;
  }

  @EventHandler( name = "long" )
  void handleFoo()
  {
  }
}