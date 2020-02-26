package com.example.imageloadproject.domain.mapper;

import androidx.annotation.Nullable;

import com.example.imageloadproject.data.remote.api.Image;
import com.example.imageloadproject.data.remote.api.Photo;
import com.example.imageloadproject.domain.model.ImageModel;


public class Mapper {
    @Nullable
    public static ImageModel mapToImageModel(Photo photo) {
        int minSize = 10000;
        ImageModel model = new ImageModel();
        Image imageWithNeededSize = null;
        if (photo.getImages().size() > 0) {
            for (Image image : photo.getImages()) {
                if (image.getSize() >= 2 && image.getSize() < minSize) {
                    minSize = image.getSize();
                    imageWithNeededSize = image;
                }
            }
        }
        model.setName(photo.getName());
        if (imageWithNeededSize != null) {
            model.setUrl(imageWithNeededSize.getUrl());
        }
        return model;
    }
}
