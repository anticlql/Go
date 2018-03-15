package com.example.go.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.go.R;

import utils.UserService;

public class LoginActivity extends AppCompatActivity  implements View.OnClickListener{

    private Button loginButton;//登录按钮
    private Button forgetButton;//忘记密码
    private Button registButton;//注册
    private EditText account;//输入的账号
    private EditText passWord;//输入的密码

    String mAccount;//从网络获得的账号
    String mPassWord;//从网络获得的密码

    Thread thread = null;//声明线程，用于执行UserService中的网络访问

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        //沉浸式标题栏
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();

        //功能按钮
        loginButton = (Button) findViewById(R.id.loginButton);
        forgetButton = (Button) findViewById(R.id.forget_pass);
        registButton = (Button) findViewById(R.id.regist);
        loginButton.setOnClickListener(this);
        forgetButton.setOnClickListener(this);
        registButton.setOnClickListener(this);

    }

    //点击按钮实现的逻辑
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //登录
            case R.id.loginButton:
                account = (EditText) findViewById(R.id.user_account);
                passWord = (EditText) findViewById(R.id.user_pass);
                mAccount = account.getText().toString();
                mPassWord = passWord.getText().toString();

                if (mAccount.equals("admin") && mPassWord.equals("123456")) {
                    Intent intent = new Intent(this,NavActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this,"请检查密码重新登录",Toast.LENGTH_SHORT).show();
                }
                //网络登录
//                UserService userService = new UserService();
//                userService.login(this,mAccount,mPassWord);

                break;
            //忘记密码
            case R.id.forget_pass:
//                Intent intent = new Intent(this,NavActivity.class);
//                startActivity(intent);
//                finish();

                Toast.makeText(LoginActivity.this,"忘记密码",Toast.LENGTH_SHORT).show();
                break;
            //注册
            case R.id.regist:
                Toast.makeText(LoginActivity.this,"注册",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

}
