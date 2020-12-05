package interfaces;


import com.hannah.testmeds.model.PostsModel;

import java.util.List;

import retrofit2.Callback;
import retrofit2.http.GET;

public interface PostInterface {
        @GET("/posts")
        default void fetchPosts(Callback<List<PostsModel>> getAll) {

        }

}
