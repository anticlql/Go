package com.example.go.Activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.go.R;

import java.io.File;

import utils.Constant;

public class LoadingPage extends AppCompatActivity {

    private TextView tv;
    MyCountDownTimer myCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_page);

        //沉浸式
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        tv = (TextView) findViewById(R.id.count_time);
        myCountDownTimer = new MyCountDownTimer(1000*3,1000);
        myCountDownTimer.start();
    }

    //MyCountDownTimer类
    class  MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            tv.setText(((millisUntilFinished / 1000 ) % 60)+"秒后进入");
        }

        @Override
        public void onFinish() {
            Intent intent = new Intent(LoadingPage.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }


    }
}
