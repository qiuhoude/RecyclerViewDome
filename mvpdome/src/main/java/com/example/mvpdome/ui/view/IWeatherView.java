package com.example.mvpdome.ui.view;

import com.example.mvpdome.model.entity.Weather;

/**
 * Created by Administrator on 2015/7/15.
 */
public interface IWeatherView {
    void showLoading();

    void hideLoading();

    void showError();

    void setWeatherInfo(Weather weather);


}
