package com.youngwu.retrofitdemo;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Desc:
 * <p>
 * Created by yyw on 2018/4/24.
 */
public interface IUserBiz {

    @GET("download")
    Call<ResponseBody> download();

    @GET("users")
    Call<List<User>> getUsers();

    @GET("{username}")
    Call<User> getUser(@Path("username") String name);

    @POST("add")
    Call<User> addUser(@Body User user);

    @GET("users")
    Call<User> getUsersBySort(@Query("sortby") String sort);

    @POST("login")
    @FormUrlEncoded
    Call<User> login(@Field("name") String name, @Field("password") String password);

    @POST("register")
    @Multipart
    Call<User> register(@PartMap Map<String, RequestBody> params, @Part RequestBody password);

    @POST("register")
    @Multipart
    Call<User> register(@Part MultipartBody.Part photo, @Part("username") RequestBody username, @Part("password") RequestBody password);
}
