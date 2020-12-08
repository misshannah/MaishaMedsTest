package com.hannah.testmeds.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.hannah.testmeds.R;
import com.hannah.testmeds.adapter.PostsAdapter;
import com.hannah.testmeds.database.AppDatabase;
import com.hannah.testmeds.database.DaoAccess;
import com.hannah.testmeds.database.PostsListTable;
import com.hannah.testmeds.databinding.HomePageLayoutBinding;
import com.hannah.testmeds.model.PostsModel;

import java.util.ArrayList;
import java.util.List;

import data.PostsApiClient;
import data.PostInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePage extends AppCompatActivity {
    private PostsAdapter postsAdapter;
    private HomePageLayoutBinding binding;
    private List<PostsModel> postsModels;
    private DaoAccess daoAccess;
    private List<PostsListTable> postsListTables;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = DataBindingUtil.setContentView(this, R.layout.home_page_layout);

        if(isOnline()) {

            binding.postsRecyclerView.setHasFixedSize(true);

            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            binding.postsRecyclerView.setLayoutManager(layoutManager);

            postsAdapter = new PostsAdapter(this, postsListTables);
            binding.postsRecyclerView.setAdapter(postsAdapter);
            postsModels = new ArrayList<>();

            postsAdapter.setPostsModelList(postsModels);
            fetchPosts();

            for (int i = 0; i < postsModels.size(); i++) {


                PostsListTable postsListTable = new PostsListTable(postsModels.get(i).getId(), postsModels.get(i).getUserId(),
                        postsModels.get(i).getTitle(), postsModels.get(i).getBody());
                postsListTable.setPostId(postsModels.get(i).getId());
                postsListTable.setPostUserId(postsModels.get(i).getUserId());
                postsListTable.setPostTitle(postsModels.get(i).getTitle());
                postsListTable.setPostBody(postsModels.get(i).getBody());
                daoAccess.insertOnlySinglePost(postsListTable);
            }
        } else {
            Toast.makeText(getApplicationContext(), "Check Internet connection!", Toast.LENGTH_SHORT).show();
            fetchPostsFromDB();

        }
    }


    private void fetchPosts() {
        PostInterface apiService = PostsApiClient.getClient().create(PostInterface.class);
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

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchPostsFromDB();
    }

    public void fetchPostsFromDB() {
        daoAccess = AppDatabase.getInstance(getApplicationContext()).message();
        daoAccess.fetchAllPosts().observe(this, (List<PostsListTable> postsListTables) -> {
            postsAdapter = new PostsAdapter(HomePage.this, postsListTables);
            binding.postsRecyclerView.setAdapter(postsAdapter);

        });

    }
    public Boolean isOnline() {
        try {
            Process p1 = java.lang.Runtime.getRuntime().exec("ping -c 1 www.google.com");
            int returnVal = p1.waitFor();
            boolean reachable = (returnVal == 0);
            return reachable;
        } catch (Exception e) {

            e.printStackTrace();
        }
        return false;
    }
}