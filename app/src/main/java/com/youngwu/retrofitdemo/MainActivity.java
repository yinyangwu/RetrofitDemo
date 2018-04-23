package com.youngwu.retrofitdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity implements View.OnClickListener {
    private TextView tv_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_test = (Button) findViewById(R.id.btn_test);
        tv_text = (TextView) findViewById(R.id.tv_text);
        btn_test.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    private void click1() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.31.242:8080/springmvc_users/user/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IUserList userList = retrofit.create(IUserList.class);
        Call<List<User>> call = userList.getUsers();
        try {
            Response<List<User>> response = call.execute();
            List<User> list = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void click2() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.31.242:8080/springmvc_users/user/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IUserList userList = retrofit.create(IUserList.class);
        Call<List<User>> call = userList.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> list = response.body();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }

    private void click3() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IUserPath userPath = retrofit.create(IUserPath.class);
        Call<User> call = userPath.getUser("小明");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User u = response.body();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    private void click4() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IUserQuery userQuery = retrofit.create(IUserQuery.class);
        Call<User> call = userQuery.getUsersBySort("username");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
