package com.example.retrofitdemo.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit sInstance;
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static Retrofit getInstance() {
        if (sInstance == null) {

            sInstance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sInstance;
    }
}
