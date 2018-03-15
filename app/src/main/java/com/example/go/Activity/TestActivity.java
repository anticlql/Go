package com.example.go.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.go.R;

import java.io.IOException;
import java.util.List;

import Model.User;
import okhttp3.Cookie;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import utils.UserService;

public class TestActivity extends AppCompatActivity {

    private TextView welcome;
    private TextView data;
    private Button getData;
    private User user;
    String responseData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        welcome = (TextView) findViewById(R.id.welcome);
        getData = (Button) findViewById(R.id.getData);
        data = (TextView) findViewById(R.id.data);

        String str = getIntent().getStringExtra("json");
        welcome.setText("欢迎,"+str+"!");

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonData = sendRequest();
//                user = UserService.userFromJson(jsonData);
//                String id = user.getId();
//                String name = user.getUsername();
                data.setText(jsonData);
//                data.setText("成功");

            }
        });

    }

    private String sendRequest() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
//                        .url("http://192.168.155.1:8080/user/isLogin.do")
                        .url("https://www.baidu.com")
                        .build();
                Response response = client.newCall(request).execute();
                responseData = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("流错误");
                }
            }
        }).start();
        return responseData;
    }
}
