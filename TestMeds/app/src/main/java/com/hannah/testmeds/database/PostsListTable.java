package com.hannah.testmeds.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PostsListTable {
    @NonNull
    @PrimaryKey
    private int postId;
    private int postUserId;
    private String postTitle;
    private String postBody;


    public PostsListTable(int postId, int postUserId, String postTitle, String postBody) {
        this.postId = postId;
        this.postUserId = postUserId;
        this.postTitle = postTitle;
        this.postBody = postBody;
    }


    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getPostUserId() {
        return postUserId;
    }

    public void setPostUserId(int postUserId) {
        this.postUserId = postUserId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }
}
