package com.hannah.testmeds.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.hannah.testmeds.R;
import com.hannah.testmeds.adapter.PostsAdapter;
import com.hannah.testmeds.databinding.ActivityDashboardBinding;
import com.hannah.testmeds.model.PostsModel;

import java.util.ArrayList;
import java.util.List;

import data.ApiClient;
import data.PostInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {
    private PostsAdapter postsAdapter;
    private ActivityDashboardBinding binding;
    private List<PostsModel> postsModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);

        binding.postsRecyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.postsRecyclerView.setLayoutManager(layoutManager);

        postsAdapter = new PostsAdapter(this);
        binding.postsRecyclerView.setAdapter(postsAdapter);
        postsModels = new ArrayList<>();

        postsAdapter.setPostsModelList(postsModels);
        fetchPosts();
    }


    private void fetchPosts() {
        PostInterface apiService = ApiClient.getClient().create(PostInterface.class);
        Call<List<PostsModel>> call = apiService.getPostsList();
        call.enqueue(new Callback<List<PostsModel>>() {
            @Override
            public void onResponse(Call<List<PostsModel>> call, Response<List<PostsModel>> response) {
                postsModels = response.body();
                postsAdapter.setPostsModelList(postsModels);
            }

            @Override
            public void onFailure(Call<List<PostsModel>> call, Throwable t) {
            }
        });


    }
}