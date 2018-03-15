package utils;

import android.content.SharedPreferences;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by 刘青林 on 2017/11/25.
 */

public class LoginAsyncTask extends AsyncTask<String,Void,String> {

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected String doInBackground(String... params) {
//        mSharedPreferences = getSharedPreferences("cookie", MODE_PRIVATE);// 用来存储服务器响应cookie
        mEditor = mSharedPreferences.edit();
        String urlPath = "http://192.168.0.31:8080/jxyy/login/check";
        String result = null;
        try {
            URL url = new URL(urlPath);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST"); // 设置请求方法为post
            conn.setUseCaches(false); // 禁止用户缓存
            conn.setDoOutput(true); // 必须设置：允许输出流
            DataOutputStream dos = new DataOutputStream(
                    conn.getOutputStream());// 实例化输出流对象,用于写入参数
            StringBuffer paramsBuffer = new StringBuffer();
            paramsBuffer.append("&username=" + params[0]);
            paramsBuffer.append("&password=" + params[1]);
            paramsBuffer.append("&flag=" + "android");
            System.out.println("paramsBuffer=" + paramsBuffer.toString());
            dos.writeUTF(paramsBuffer.toString());// 使用UTF格式输出该参数
            dos.flush();// 输出缓冲
            dos.close();// 输出关闭
            if (conn.getResponseCode() == 200) {
                String cookie = conn.getHeaderField("set-cookie");// 获取服务器响应cookie
                String sessionId = cookie.substring(0, cookie.indexOf(";"));
                mEditor.putString("cookie", sessionId);
                mEditor.commit();// 将cookie存入mSharedPreferences中</strong>
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                StringBuffer sb = new StringBuffer();
                String temp = "";
                while ((temp = br.readLine()) != null) {
                    sb.append(temp);
                }
                result = sb.toString();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
