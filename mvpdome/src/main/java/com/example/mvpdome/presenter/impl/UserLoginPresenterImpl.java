package com.example.mvpdome.presenter.impl;

import android.os.Handler;

import com.example.mvpdome.model.IUserModel;
import com.example.mvpdome.model.entity.User;
import com.example.mvpdome.model.impl.UserModel;
import com.example.mvpdome.presenter.OnLoginListener;
import com.example.mvpdome.presenter.UserLoginPresenter;
import com.example.mvpdome.ui.view.IUserLoginView;

/**
 * Created by Administrator on 2015/7/14.
 */
public class UserLoginPresenterImpl implements UserLoginPresenter {

    private IUserModel userModel;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenterImpl(IUserLoginView mainActivity) {
        userLoginView = mainActivity;
        userModel = new UserModel();
    }

    @Override
    public void login() {
        userLoginView.showLoading();
        userModel.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                        userLoginView.startWeather();
                    }
                });
            }

            @Override
            public void loginFailed() {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });

            }
        });

    }

    @Override
    public void clear() {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }
}
