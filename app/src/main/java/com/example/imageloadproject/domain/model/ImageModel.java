package com.example.imageloadproject.domain.model;

import com.example.imageloadproject.data.remote.api.Image;

public class ImageModel {
    private long id;
    private String url;
    private String name;

    public ImageModel(){

    }

    public ImageModel(long id, String url, String name) {
        this.id = id;
        this.url = url;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
