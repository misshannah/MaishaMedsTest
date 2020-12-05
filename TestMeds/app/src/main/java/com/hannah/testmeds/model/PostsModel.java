package com.hannah.testmeds.model;

import android.graphics.Movie;

import java.util.List;

public class PostsModel {
    private int userId;
    private Long id;
    private String title;
    private String body;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public static class ListAll {
        private List<PostsModel> postsList;

        public List<PostsModel> getAll() {
            return postsList;
        }
    }
}
