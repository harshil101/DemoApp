package com.example.demoapp;

import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = HostActivity.class
)
@GeneratedEntryPoint
@InstallIn(ActivityComponent.class)
public interface HostActivity_GeneratedInjector {
  void injectHostActivity(HostActivity hostActivity);
}
