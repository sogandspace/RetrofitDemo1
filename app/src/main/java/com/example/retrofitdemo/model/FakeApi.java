package com.example.retrofitdemo.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FakeApi {

    @GET("/posts")
    Call<List<Post>> getPosts();

    @GET("comments")
    Call<List<Comment>> getComments(@Query("postId") int postId);

}
