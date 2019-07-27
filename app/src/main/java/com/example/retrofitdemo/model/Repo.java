package com.example.retrofitdemo.model;

import com.example.retrofitdemo.MyCallback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repo {

    private static Repo sInstance;
    private FakeApi mFakeApi;

    public static Repo getInstance() {
        if (sInstance == null)
            sInstance = new Repo();

        return sInstance;
    }


    private Repo() {
        mFakeApi = RetrofitInstance.getInstance().create(FakeApi.class);
    }

    public void getPost(final MyCallback<List<Post>> callback) {
        Call<List<Post>> call = mFakeApi.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call,
                                   Response<List<Post>> response) {
                if (response.body() == null) {
                    callback.onError("OnResponse: body is null");
                } else {
                    callback.onSuccessful(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    public void getComments(int postId, final MyCallback<List<Comment>> callback) {

        Call<List<Comment>> call = mFakeApi.getComments(postId);
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call,
                                   Response<List<Comment>> response) {
                if (response.body() == null) {
                    callback.onError("body is null");
                } else {
                    callback.onSuccessful(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }
}
