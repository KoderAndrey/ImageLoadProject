package com.example.imageloadproject.domain.di.module;

import com.example.imageloadproject.data.remote.ImageRemoteRepository;
import com.example.imageloadproject.data.remote.ImageService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {NetworkModule.class})
public class RepositoryModule {

    @Singleton
    @Provides
    ImageRemoteRepository provideImageRemoteRepository(ImageService service) {
        return new ImageRemoteRepository(service);
    }

}
