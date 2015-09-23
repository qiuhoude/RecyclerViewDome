package com.example.mvpdome.model.impl;

import com.example.mvpdome.model.IUserModel;
import com.example.mvpdome.presenter.OnLoginListener;
import com.example.mvpdome.model.entity.User;

/**
 * Created by Administrator on 2015/7/14.
 */
public class UserModel implements IUserModel {

    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {


        new Thread() {

            @Override
            public void run() {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //模拟登录成功
                if ("qiu".equals(username) && "123".equals(password)) {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                } else {
                    loginListener.loginFailed();
                }
            }


        }.start();
    }
}
