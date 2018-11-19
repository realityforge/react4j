package com.example.inject;

import javax.inject.Inject;
import react4j.Component;
import react4j.ReactNode;
import react4j.annotations.ReactComponent;

@ReactComponent
public abstract class PublicReactComponent
  extends Component
{
  @Inject
  String someParam;

  @Override
  protected ReactNode render()
  {
    return null;
  }
}
