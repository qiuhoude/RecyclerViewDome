package com.example.mvpdome.model;

import com.example.mvpdome.presenter.OnLoginListener;

/**
 * Created by Administrator on 2015/7/14.
 */
public interface IUserModel {

    public void login(String username,String password,OnLoginListener onLoginLister);
}
