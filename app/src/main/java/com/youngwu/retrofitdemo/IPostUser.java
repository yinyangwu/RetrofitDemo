package com.youngwu.retrofitdemo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Desc:
 * <p>
 * Created by yyw on 2018/4/23.
 */
public interface IPostUser {

    @POST("add")
    Call<User> addUser(@Body User user);
}
