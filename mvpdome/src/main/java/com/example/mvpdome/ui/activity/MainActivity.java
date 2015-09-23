package com.example.mvpdome.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mvpdome.R;
import com.example.mvpdome.model.entity.User;
import com.example.mvpdome.presenter.UserLoginPresenter;
import com.example.mvpdome.presenter.impl.UserLoginPresenterImpl;
import com.example.mvpdome.ui.view.IUserLoginView;


public class MainActivity extends AppCompatActivity implements IUserLoginView{

    private EditText mEtUsername,mEtPassword;
    private Button mBtnLogin,mBtnClear;
    private ProgressBar mPbLoading;

    private UserLoginPresenter mUserPresenter = new UserLoginPresenterImpl(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        mEtUsername = (EditText) findViewById(R.id.id_username);
        mEtPassword = (EditText) findViewById(R.id.id_passwd);
        mBtnLogin = (Button) findViewById(R.id.id_bt_login);
        mBtnClear = (Button) findViewById(R.id.id_bt_clear);
        mPbLoading = (ProgressBar) findViewById(R.id.id_pb_loading);
        mPbLoading.setVisibility(View.GONE);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mUserPresenter.login();
            }
        });
        mBtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mUserPresenter.clear();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public String getUserName() {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEtPassword.getText().toString();
    }

    @Override
    public void clearUserName() {
        mEtUsername.setText("");
    }

    @Override
    public void clearPassword() {
        mEtPassword.setText("");

    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, user.getUsername() +
                " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startWeather() {
        Intent intent = new Intent(this,WeatherActivity.class);
        startActivity(intent);
    }
}
