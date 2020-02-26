package com.example.imageloadproject.view;

import android.annotation.SuppressLint;

import androidx.databinding.ObservableInt;
import androidx.lifecycle.ViewModel;

import com.example.imageloadproject.domain.model.ImageModel;
import com.example.imageloadproject.domain.usecase.ImageLocalUseCase;
import com.example.imageloadproject.domain.usecase.ImageRequestUseCase;
import com.hadilq.liveevent.LiveEvent;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.realm.RealmResults;

import static android.text.TextUtils.isEmpty;
import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class ImageLoadViewModel extends ViewModel {

    private ImageRequestUseCase mRequestUseCase;
    private ImageLocalUseCase mLocalUseCase;
    public ObservableInt mIsLoad = new ObservableInt(GONE);
    private LiveEvent<Throwable> mError = new LiveEvent<>();
    private LiveEvent<RealmResults<ImageModel>> mImageModelsEvent = new LiveEvent<>();

    @Inject
    public ImageLoadViewModel(ImageRequestUseCase requestUseCase, ImageLocalUseCase localUseCase) {
        mRequestUseCase = requestUseCase;
        mLocalUseCase = localUseCase;
    }

    void getImage(String search) {
        mRequestUseCase
                .getImageModel(search)
                .flatMapCompletable(this::setImageToDB)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> mIsLoad.set(VISIBLE))
                .doAfterTerminate(() -> mIsLoad.set(GONE))
                .subscribe(() -> {
                }, throwable -> mError.postValue(throwable));
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

    public void clickSearch(String search) {
        if (!isEmpty(search)) {
            getImage(search);
        }
    }

    public LiveEvent<RealmResults<ImageModel>> getImageModelsEvent() {
        return mImageModelsEvent;
    }

    public LiveEvent<Throwable> getError() {
        return mError;
    }
}