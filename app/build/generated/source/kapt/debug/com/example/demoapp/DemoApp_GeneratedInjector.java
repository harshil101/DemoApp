package com.example.demoapp;

import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = DemoApp.class
)
@GeneratedEntryPoint
@InstallIn(ApplicationComponent.class)
public interface DemoApp_GeneratedInjector {
  void injectDemoApp(DemoApp demoApp);
}
