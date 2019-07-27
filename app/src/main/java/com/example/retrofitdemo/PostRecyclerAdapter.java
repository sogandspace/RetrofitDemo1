package com.example.retrofitdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitdemo.model.Post;

import java.util.List;

public class PostRecyclerAdapter extends RecyclerView.Adapter<PostRecyclerAdapter.ViewHolder> {

    private List<Post> mPosts;
    private OnClickedItem mPost;


    public PostRecyclerAdapter(OnClickedItem post) {
        mPost = post;
    }


    public void setPost(List<Post> posts) {
        mPosts = posts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_master, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostRecyclerAdapter.ViewHolder holder, int position) {
        holder.bind(mPosts.get(position));
    }

    @Override
    public int getItemCount() {
        return mPosts != null ? mPosts.size() : 0;
    }

     class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
         ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
        }

        void bind(Post post){
             tvTitle.setText(post.getTitle());
        }
    }
}
