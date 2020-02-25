package com.example.imageloadproject.domain.usecase;

import com.example.imageloadproject.data.local.ImageLocalRepository;
import com.example.imageloadproject.domain.model.ImageModel;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.realm.RealmResults;

public class ImageLocalUseCase {

    private ImageLocalRepository mLocalRepository;

    @Inject
    public ImageLocalUseCase(ImageLocalRepository localRepository) {
        mLocalRepository = localRepository;
    }

    public Completable addItem(ImageModel model) {
        return mLocalRepository.addItem(model);
    }

    public Single<RealmResults<ImageModel>> getList() {
        return mLocalRepository
                .getList();
    }
}
