package com.example.mvpdome.ui.common;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Administrator on 2015/2/6.
 */
public class BaseActivity extends AppCompatActivity {

    protected <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }
}