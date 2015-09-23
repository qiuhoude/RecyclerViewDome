package com.example.mvpdome.app;

import android.app.Application;

import com.example.mvpdome.util.volley.VolleyRequest;

/**
 * Created by Administrator on 2015/7/15.
 */
public class MVPDemoApplication extends Application {
    private static MVPDemoApplication instance;

    public MVPDemoApplication() {
        instance = this;
    }

    public static Application getContext() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        VolleyRequest.buildRequestQueue(this);
    }
}
