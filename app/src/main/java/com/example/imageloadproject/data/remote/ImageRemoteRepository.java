package com.example.imageloadproject.data.remote;

import com.example.imageloadproject.data.remote.api.Data;

import javax.inject.Inject;

import io.reactivex.Single;

public class ImageRemoteRepository {
    private ImageService mService;

    @Inject
    public ImageRemoteRepository(ImageService service) {
        mService = service;
    }

    public Single<Data> getDataImage(String search) {
        return mService.getDataImage(search);
    }
}
