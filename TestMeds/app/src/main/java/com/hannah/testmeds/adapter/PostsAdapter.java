package com.hannah.testmeds.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.hannah.testmeds.model.PostsModel;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsViewHolder> {
    private List<PostsModel> postsModelList;
    private LayoutInflater mInflater;
    private Context mContext;

    public PostsAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.postsModelList = new ArrayList<>();
    }

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return (postsModelList == null) ? 0 : postsModelList.size();
    }

    public void setPostsModelList(List<PostsModel> postsModelList) {
        if (postsModelList != null) {
            this.postsModelList.clear();
            this.postsModelList.addAll(postsModelList);
            notifyDataSetChanged();
        }
    }
}

