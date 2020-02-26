package com.example.imageloadproject.domain.model;

import io.realm.RealmObject;

public class ImageModel extends  RealmObject {

    private String url;
    private String name;

    public ImageModel(){

    }

    public ImageModel(ImageModel model){
       url = model.url;
       name = model.name;
    }

    public ImageModel( String url, String name) {
        this.url = url;
        this.name = name;
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
