package com.youngwu.retrofitdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity implements View.OnClickListener {
    private TextView tv_text;
    private final Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.31.242:8080/springmvc_users/user/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

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
        IUserBiz userBiz = retrofit.create(IUserBiz.class);
        Call<List<User>> call = userBiz.getUsers();
        try {
            Response<List<User>> response = call.execute();
            List<User> list = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void click2() {
        IUserBiz userBiz = retrofit.create(IUserBiz.class);
        Call<List<User>> call = userBiz.getUsers();
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
        IUserBiz userBiz = retrofit.create(IUserBiz.class);
        Call<User> call = userBiz.getUser("小明");
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
        IUserBiz userBiz = retrofit.create(IUserBiz.class);
        Call<User> call = userBiz.getUsersBySort("username");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    private void click5() {
        IUserBiz userBiz = retrofit.create(IUserBiz.class);
        Call<User> call = userBiz.addUser(new User("小明", "123456"));
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    private void click6() {
        IUserBiz userBiz = retrofit.create(IUserBiz.class);
        Call<User> call = userBiz.login("小明", "123456");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    private void click7() {
        IUserBiz userBiz = retrofit.create(IUserBiz.class);
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath().concat("/123.jpg"));
        RequestBody photoRequestBody = RequestBody.create(MediaType.parse("image/jpg"), file);
        MultipartBody.Part photo = MultipartBody.Part.createFormData("photo", "123.jpg", photoRequestBody);
        Call<User> call = userBiz.register(photo, RequestBody.create(null, "小明"), RequestBody.create(null, "123456"));
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    private void click8() {
        IUserBiz userBiz = retrofit.create(IUserBiz.class);
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath().concat("/123.jpg"));
        RequestBody photoRequestBody = RequestBody.create(MediaType.parse("image/jpg"), file);
        Map<String, RequestBody> photos = new HashMap<>();
        photos.put("photos\"; filename=\"123.png", photoRequestBody);
        photos.put("username", RequestBody.create(null, "小明"));
        Call<User> call = userBiz.register(photos, RequestBody.create(null, "123456"));
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    private void click9() {
        IUserBiz userBiz = retrofit.create(IUserBiz.class);
        Call<ResponseBody> call = userBiz.download();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ResponseBody body = response.body();
                if (body != null) {
                    InputStream is = body.byteStream();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
