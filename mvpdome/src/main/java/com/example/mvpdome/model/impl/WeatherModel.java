package com.example.mvpdome.model.impl;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.mvpdome.model.IWeatherModel;
import com.example.mvpdome.model.entity.Weather;
import com.example.mvpdome.presenter.OnWeatherListener;
import com.example.mvpdome.util.volley.VolleyRequest;

/**
 * Created by Administrator on 2015/7/15.
 */
public class WeatherModel implements IWeatherModel {
    @Override
    public void loadWeather(String cityNO, final OnWeatherListener listener) {
        /*数据层操作*/
        VolleyRequest.newInstance().newGsonRequest("http://www.weather.com.cn/data/sk/" + cityNO + ".html",
                Weather.class, new Response.Listener<Weather>() {
                    @Override
                    public void onResponse(Weather weather) {
                        if (weather != null) {

                            listener.onSuccess(weather);
                        } else {
                            listener.onError();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onError();
                    }
                });
    }
}