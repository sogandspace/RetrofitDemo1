package com.example.retrofitdemo;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import com.example.retrofitdemo.model.Comment;
import com.example.retrofitdemo.model.Post;
import com.example.retrofitdemo.model.Repo;
import com.example.retrofitdemo.viewModel.SharedViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private TextView tvBody, tvName, tvEmail;
    private SharedViewModel mSharedViewModel;
    private RecyclerView mRecyclerView;
    private Repo mRepo;

    PostRecyclerAdapter mAdapter;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        mRecyclerView = view.findViewById(R.id.rvDetail);

        tvBody = view.findViewById(R.id.tvBody);
        tvName = view.findViewById(R.id.tvName);
        tvEmail = view.findViewById(R.id.tvEmail);


        mSharedViewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);

        mRepo = Repo.getInstance();

        mSharedViewModel.getComment().observe(this, new Observer<Comment>() {
            @Override
            public void onChanged(Comment comment) {
                tvBody.setText(comment.getBody());
                tvName.setText(comment.getName());
                tvEmail.setText(comment.getEmail());
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

//    private void setUpRecycler() {
//        mAdapter = new PostRecyclerAdapter();
//        mRecyclerView.setAdapter(mAdapter);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//        mRecyclerView.setLayoutManager(layoutManager);
//        DividerItemDecoration decoration = new DividerItemDecoration(getContext() ,layoutManager.getOrientation());
//        mRecyclerView.addItemDecoration(decoration);
//    }

}
