package com.youngwu.retrofitdemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Desc:
 * <p>
 * Created by yyw on 2018/4/23.
 */
public interface IUserPath {

    @GET("{username}")
    Call<User> getUser(@Path("username") String name);
}
