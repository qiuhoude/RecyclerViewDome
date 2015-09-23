package com.example.mvpdome.presenter.impl;

import com.example.mvpdome.model.entity.Weather;
import com.example.mvpdome.model.impl.WeatherModel;
import com.example.mvpdome.presenter.OnWeatherListener;
import com.example.mvpdome.presenter.WeatherPresenter;
import com.example.mvpdome.ui.view.IWeatherView;


/**
 * Created by Administrator
 * 天气 Prestener实现
 */
public class WeatherPresenterImpl implements WeatherPresenter, OnWeatherListener {
    /*Presenter作为中间层，持有View和Model的引用*/
    private IWeatherView weatherView;
    private WeatherModel weatherModel;

    public WeatherPresenterImpl(IWeatherView weatherView) {
        this.weatherView = weatherView;
        weatherModel = new WeatherModel();
    }

    @Override
    public void getWeather(String cityNO) {
        weatherView.showLoading();
        weatherModel.loadWeather(cityNO, this);
    }

    @Override
    public void onSuccess(Weather weather) {
//        AsyncTask asyncTask = null;
//
//        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        weatherView.hideLoading();
        weatherView.setWeatherInfo(weather);
    }

    @Override
    public void onError() {
        weatherView.hideLoading();
        weatherView.showError();
    }
}
