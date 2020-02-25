package com.example.imageloadproject.domain.usecase;

import com.example.imageloadproject.data.remote.ImageRemoteRepository;
import com.example.imageloadproject.data.remote.api.Data;
import com.example.imageloadproject.data.remote.api.Photo;
import com.example.imageloadproject.domain.mapper.Mapper;
import com.example.imageloadproject.domain.model.ImageModel;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.functions.Function;

public class ImageUseCase {

    private ImageRemoteRepository mRemoteRepository;
    private Random mRandom;

    @Inject
    public ImageUseCase(ImageRemoteRepository remoteRepository) {
        mRemoteRepository = remoteRepository;
        mRandom = new Random();
    }

    public Single<ImageModel> getImageModel(String search) {
        return mRemoteRepository
                .getDataImage(search)
                .map(data -> {
                    List<Photo> photos = data.getPhotos();
                    return Mapper.mapToImageModel(photos.get(mRandom.nextInt(photos.size())));
                });
    }
}