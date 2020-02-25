package com.example.imageloadproject;

import com.example.imageloadproject.domain.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import io.realm.Realm;

public class ImageLoadApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<DaggerApplication> applicationInjector() {
        return DaggerAppComponent
                .builder()
                .application(this)
                .build();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
