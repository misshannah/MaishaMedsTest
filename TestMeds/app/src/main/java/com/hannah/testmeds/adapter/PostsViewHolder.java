package com.hannah.testmeds.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hannah.testmeds.R;

class PostsViewHolder extends RecyclerView.ViewHolder {
    TextView  textId, textUserId,textTitle,textBody;

    public PostsViewHolder(@NonNull View itemView) {
        super(itemView);
        textId = (TextView)itemView.findViewById(R.id.id);
        textUserId = (TextView)itemView.findViewById(R.id.user_id);
        textTitle = (TextView)itemView.findViewById(R.id.title);
        textBody = (TextView)itemView.findViewById(R.id.body);

    }
}