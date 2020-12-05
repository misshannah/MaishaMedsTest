package interfaces;


import com.hannah.testmeds.model.PostsModel;


import retrofit2.Callback;
import retrofit2.http.GET;

public interface PostInterface {
        @GET("/posts")
        default void fetchPosts(Callback<PostsModel.ListAll> getPostsList) {
        }

}
