package data;

import com.hannah.testmeds.model.PostsModel;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
        @GET("/posts")
        Call<List<PostsModel>> getPostsList();


}
