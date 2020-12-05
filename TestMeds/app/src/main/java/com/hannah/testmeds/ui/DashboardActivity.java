package com.hannah.testmeds.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Movie;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hannah.testmeds.R;
import com.hannah.testmeds.adapter.PostsAdapter;
import com.hannah.testmeds.databinding.ActivityDashboardBinding;
import com.hannah.testmeds.model.PostsModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import interfaces.PostInterface;
import okhttp3.Request;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DashboardActivity extends AppCompatActivity {
    private PostsAdapter postsAdapter;
    private ActivityDashboardBinding binding;
    private List<PostsModel> postsModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);

        binding.postsRecyclerView.setHasFixedSize(true);
        if(binding.postsRecyclerView.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            binding.postsRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        } else if (binding.postsRecyclerView.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.postsRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        }



        postsAdapter = new PostsAdapter(this);
        binding.postsRecyclerView.setAdapter(postsAdapter);
        postsModels = new ArrayList<>();

        postsAdapter.setPostsModelList(postsModels);

        fetchPosts();
    }
    private void fetchPosts() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.base_url))
                .build();
        PostInterface postInterface = retrofit.create(PostInterface.class);
        postInterface.fetchPosts(new Callback<PostsModel.ListAll>() {
            @Override
            public void onResponse(Call<PostsModel.ListAll> call, Response<PostsModel.ListAll> response) {
                postsAdapter.setPostsModelList(response.body().getAll());

            }

            @Override
            public void onFailure(Call<PostsModel.ListAll> call, Throwable t) {

            }


        });

    }
}