package com.example.imageloadproject.data.remote.api;

import java.util.List;

public class Data {
    private List<Photo> photos;

    public Data() {
    }

    public Data(List<Photo> photos) {
        this.photos = photos;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
