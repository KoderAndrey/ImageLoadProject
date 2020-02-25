package com.example.imageloadproject.view;

import android.annotation.SuppressLint;

import androidx.lifecycle.ViewModel;

import com.example.imageloadproject.domain.model.ImageModel;
import com.example.imageloadproject.domain.usecase.ImageLocalUseCase;
import com.example.imageloadproject.domain.usecase.ImageRequestUseCase;
import com.hadilq.liveevent.LiveEvent;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.realm.RealmResults;

public class ImageLoadViewModel extends ViewModel {

    private ImageRequestUseCase mRequestUseCase;
    private ImageLocalUseCase mLocalUseCase;
    private LiveEvent<Boolean> mIsLoad = new LiveEvent<>();
    private LiveEvent<Throwable> mError = new LiveEvent<>();
    private LiveEvent<RealmResults<ImageModel>> mImageModelsEvent = new LiveEvent<>();

    @Inject
    public ImageLoadViewModel(ImageRequestUseCase requestUseCase, ImageLocalUseCase localUseCase) {
        mRequestUseCase = requestUseCase;
        mLocalUseCase = localUseCase;
    }

    public void getImage(String search) {
        mRequestUseCase
                .getImageModel(search)
                .flatMapCompletable(this::setImageToDB)
                .doOnSubscribe(disposable -> mIsLoad.postValue(true))
                .doAfterTerminate(() -> mIsLoad.postValue(false))
                .doOnError(throwable -> mError.postValue(throwable))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    private Completable setImageToDB(ImageModel model) {
        return mLocalUseCase.addItem(model);
    }

    @SuppressLint("CheckResult")
    void getListModelImage() {
        mLocalUseCase.getList()
                .doOnError(throwable -> mError.postValue(throwable))
                .subscribe(imageModels -> mImageModelsEvent.postValue(imageModels));
    }

    public LiveEvent<Boolean> getIsLoad() {
        return mIsLoad;
    }

    public LiveEvent<RealmResults<ImageModel>> getImageModelsEvent() {
        return mImageModelsEvent;
    }

    public LiveEvent<Throwable> getError() {
        return mError;
    }
}