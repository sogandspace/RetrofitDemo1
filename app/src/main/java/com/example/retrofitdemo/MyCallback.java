package com.example.retrofitdemo;

public interface MyCallback<T> {
    void onSuccessful(T data);

    void onError(String message);
}
