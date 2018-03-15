package utils;

import android.app.Application;

import java.net.CookieStore;

/**
 * Created by 刘青林 on 2017/11/26.
 */

public class MyApplication extends Application {

    private CookieStore cookies;

    public CookieStore getCookie() {
        return cookies;
    }

    public void setCookie(CookieStore cookies) {
        this.cookies = cookies;
    }
}
