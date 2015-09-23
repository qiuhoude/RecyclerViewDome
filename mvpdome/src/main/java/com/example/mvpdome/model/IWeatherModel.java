package com.example.mvpdome.model;

import com.example.mvpdome.presenter.OnWeatherListener;

/**
 * Created by Administrator on 2015/7/15.
 */
public interface IWeatherModel {
    void loadWeather(String cityNO, OnWeatherListener listener);
}
