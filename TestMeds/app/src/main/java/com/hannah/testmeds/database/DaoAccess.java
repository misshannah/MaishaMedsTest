package com.hannah.testmeds.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)  // or OnConflictStrategy.IGNORE
    void insertOnlySinglePost(PostsListTable... postsListTables);

    //Get All Posts
    @Query("SELECT * FROM PostsListTable")
    LiveData<List<PostsListTable>> fetchAllPosts();


}
