package com.example.mvpdome.ui.view;

import com.example.mvpdome.model.entity.User;

/**
 * Created by Administrator on 2015/7/14.
 */
public interface IUserLoginView {

    String getUserName();
    String getPassword();

    void clearUserName();
    void clearPassword();

    //进度条
    void showLoading();
    void hideLoading();

    //发送信息给activity
    void toMainActivity(User user);
    void showFailedError();

    void startWeather();

}
