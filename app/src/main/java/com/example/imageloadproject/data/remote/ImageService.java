package com.example.imageloadproject.data.remote;

import com.example.imageloadproject.data.remote.api.Data;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ImageService {
    @GET("photos/search")
    Single<Data> getDataImage(@Query("term") String search);
}
