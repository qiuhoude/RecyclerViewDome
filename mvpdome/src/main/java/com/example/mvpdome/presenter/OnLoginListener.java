package com.example.mvpdome.presenter;

import com.example.mvpdome.model.entity.User;

/**
 * Created by Administrator on 2015/7/14.
 */
public interface OnLoginListener {
    /**登陆成功*/
    void loginSuccess(User user);
    /**登陆失败*/
    void loginFailed();
}
