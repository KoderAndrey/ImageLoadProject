package com.example.imageloadproject.domain.di;

import com.example.imageloadproject.ImageLoadApplication;
import com.example.imageloadproject.domain.di.module.AppBindingModule;
import com.example.imageloadproject.domain.di.module.NetworkModule;
import com.example.imageloadproject.domain.di.module.RepositoryModule;
import com.example.imageloadproject.domain.di.module.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

@Singleton
@Component(modules = {
        AppBindingModule.class,
        NetworkModule.class,
        RepositoryModule.class,
        ViewModelModule.class
})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(ImageLoadApplication app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(ImageLoadApplication application);

        AppComponent build();
    }
}
