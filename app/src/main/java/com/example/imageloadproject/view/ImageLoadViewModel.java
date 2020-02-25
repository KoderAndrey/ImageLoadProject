package com.example.imageloadproject.view;

import androidx.lifecycle.ViewModel;

import com.example.imageloadproject.domain.model.ImageModel;
import com.example.imageloadproject.domain.usecase.ImageUseCase;

import javax.inject.Inject;

import io.reactivex.Single;

public class ImageLoadViewModel extends ViewModel {

    private ImageUseCase mUseCase;

    @Inject
    public ImageLoadViewModel(ImageUseCase useCase) {
        mUseCase = useCase;
    }

    public Single<ImageModel> getImage(String search) {
        return mUseCase.getImageModel(search);
    }
}