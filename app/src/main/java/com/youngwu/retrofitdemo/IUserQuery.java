package com.youngwu.retrofitdemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Desc:
 * <p>
 * Created by yyw on 2018/4/23.
 */
public interface IUserQuery {

    @GET("users")
    Call<User> getUsersBySort(@Query("sortby") String sort);
}
