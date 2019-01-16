package com.example.inject;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import javax.annotation.Generated;
import javax.inject.Provider;
import react4j.Component;

@Generated("react4j.processor.ReactProcessor")
public interface DaggerTrueComponentDaggerComponentExtension {
  DaggerSubcomponent getDaggerTrueComponentDaggerSubcomponent();

  default void bindDaggerTrueComponent() {
    React4j_DaggerTrueComponent.InjectSupport.setProvider( () -> (DaggerTrueComponent) getDaggerTrueComponentDaggerSubcomponent().createProvider().get() );
  }

  @Module
  interface DaggerModule {
    @Binds
    Component bindComponent(React4j_DaggerTrueComponent component);
  }

  @Subcomponent(
      modules = DaggerModule.class
  )
  interface DaggerSubcomponent {
    Provider<Component> createProvider();
  }
}