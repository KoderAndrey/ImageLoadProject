package com.example.imageloadproject.domain.di.module;

import com.example.imageloadproject.view.MainActivity;

import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Module(includes = {AndroidInjectionModule.class, AndroidSupportInjectionModule.class})
public abstract class AppBindingModule {
    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();
}
