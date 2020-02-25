package com.example.imageloadproject.domain.mapper;

import androidx.annotation.Nullable;

import com.example.imageloadproject.data.remote.api.Image;
import com.example.imageloadproject.data.remote.api.Photo;
import com.example.imageloadproject.domain.model.ImageModel;

/**
 * Creating data model for using it in view layer. In object photo we find
 * suitable size for image for setting it to list. It's  image which is more than 2
 * but smallest than another. If we don't find needed image we send null and
 * and show the user that there is no desired picture. But such a situation in theory should not be
 **/

public class Mapper {
    @Nullable
    public static ImageModel mapToImageModel(Photo photo) {
        int minSize = 10000;
        Image imageWithNeededSize = null;
        for (Image image : photo.getImages()) {
            if (image.getSize() >= 2 && image.getSize() < minSize) {
                minSize = image.getSize();
                imageWithNeededSize = image;
            }
        }
        if (imageWithNeededSize == null) {
            return null;
        } else {
            return new ImageModel(photo.getId(), imageWithNeededSize.getUrl(), photo.getName());
        }
    }
}
