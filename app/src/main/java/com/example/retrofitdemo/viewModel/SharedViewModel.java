package com.example.retrofitdemo.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.retrofitdemo.model.Comment;

public class SharedViewModel extends AndroidViewModel {

    private MutableLiveData<Comment> mComment;

    public SharedViewModel(@NonNull Application application) {
        super(application);
        mComment = new MutableLiveData<>();
    }

    public LiveData<Comment> getComment() {
        return mComment;
    }

    public void setComment(Comment comment) {
        mComment.setValue(comment);
    }
}
