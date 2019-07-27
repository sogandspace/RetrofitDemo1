package com.example.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavHost;

import android.os.Bundle;

import com.example.retrofitdemo.model.Repo;

public class MainActivity extends AppCompatActivity {
    private Repo mRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}

