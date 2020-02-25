package com.example.imageloadproject.data.local;

import com.example.imageloadproject.domain.model.ImageModel;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import io.realm.RealmResults;

public class ImageLocalRepository {

    @Inject
    public ImageLocalRepository() {

    }


    public Completable addItem(ImageModel model) {
        return Completable.create(emitter -> Realm.getDefaultInstance().executeTransaction(realm -> {
            ImageModel m = realm.createObject(ImageModel.class);
            m.setName(model.getName());
            m.setUrl(model.getUrl());
            emitter.onComplete();
        }));
    }


    public Single<RealmResults<ImageModel>> getList() {
        return Single.create(emitter -> emitter.onSuccess(Realm.getDefaultInstance().where(ImageModel.class).findAll()));
    }
}