package com.youngwu.retrofitdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Desc:
 * <p>
 * Created by yyw on 2018/4/23.
 */
public interface IUserList {

    @GET("users")
    Call<List<User>> getUsers();
}
