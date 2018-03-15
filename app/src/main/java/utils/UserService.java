package utils;


import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import com.example.go.Activity.TestActivity;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import Model.User;
import okhttp3.OkHttpClient;

public class UserService {

    public static OkHttpClient client = new OkHttpClient();

    private String userName;
    private String passWord;
    private String content;

    public void login(final Context context, String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;

        new Thread(netWorkTask).start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (content != null) {
                        if (!content.equals("")) {
                            Intent intent = new Intent(context, TestActivity.class);
                            intent.putExtra("json", content);
                            context.startActivity(intent);
                        } else {
                            System.out.println(content);
                        }
                        break;
                    }
                }
            }
        }, 0);
    }

    Runnable netWorkTask = new Runnable() {
        @Override
        public void run() {
            System.out.println("开始登录");
            netWork(userName, passWord);
        }
    };


    public void netWork(String userName, String password) {
        InputStream in = null;
        String path = "http://192.168.155.1:8080/user/login.do";
        String data = "?tel=" + userName + "&password=" + password;
//        String urlSrc = "https://www.baidu.com";
        try {
            URL url = new URL((path + data).trim());
//            URL url = new URL(urlSrc);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                in = conn.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while (-1 != (len = in.read(buffer))) {
                    baos.write(buffer, 0, len);
                    baos.flush();
                }
                content = baos.toString("utf-8");
                System.out.println("========>"+content);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("客户端未连接到服务器");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端未连接到服务器");
        }
    }

    /**
     * 解析一个json字符串返回一个对象
     */
    public static User userFromJson(String content) {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = null;
        try {
            user = objectMapper.readValue(content, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
