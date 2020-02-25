package com.example.imageloadproject.data.remote.api;

public class Image {
    private int size;
    private String url;

    public Image() {
    }

    public Image(int size, String url) {
        this.size = size;
        this.url = url;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
