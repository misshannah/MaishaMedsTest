package com.hannah.testmeds.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hannah.testmeds.R;
import com.hannah.testmeds.database.AppDatabase;
import com.hannah.testmeds.database.DaoAccess;
import com.hannah.testmeds.database.PostsListTable;
import com.hannah.testmeds.model.PostsModel;
import com.hannah.testmeds.ui.HomePage;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsViewHolder> {
    private List<PostsModel> postsModelList;
    private LayoutInflater mInflater;
    private Context mContext;



    public PostsAdapter(Context context, List<PostsListTable> postsListTables) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.postsModelList = new ArrayList<>();
    }

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_layout,parent,false);
        return new PostsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {
        holder.textId.setText(Integer.toString(postsModelList.get(position).getId()));
        holder.textUserId.setText(Integer.toString(postsModelList.get(position).getUserId()));
        holder.textTitle.setText(postsModelList.get(position).getTitle());
        holder.textBody.setText(postsModelList.get(position).getBody());


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

