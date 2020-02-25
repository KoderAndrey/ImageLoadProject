package com.example.imageloadproject.data.remote.api;

import java.util.List;

public class Photo {
    private long id;
    private List<Image> images;
    private String name;

    public Photo(){

    }

    public Photo(long id, List<Image> images, String name) {
        this.id = id;
        this.images = images;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
