package com.rihat.retrofitapp.reastInterface;

import com.rihat.retrofitapp.models.Comment;
import com.rihat.retrofitapp.models.Person;
import com.rihat.retrofitapp.models.Post;
import com.rihat.retrofitapp.models.ResponseData;

import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JsonPlaceHolder {
    @GET("posts")
    Call<List<Post>> getPosts(
            @Query("userId") Integer[] userId,
            @Query("_sort") String sort,
            @Query("_order") String order
    );

    @GET
    Call<List<Post>> getPosts(@Url String url);

    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);

    @GET
    Call<List<Comment>> getComments(@Url String url);

    @POST("posts")
    Call<Post> createPost(@Body Post post);


    @GET("{id}")
    Call<Map<String,Person>> getpersonalData(@Path("id") int userId);


}
