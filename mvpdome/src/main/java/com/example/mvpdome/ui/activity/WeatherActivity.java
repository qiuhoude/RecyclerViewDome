package com.example.mvpdome.ui.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvpdome.R;
import com.example.mvpdome.model.entity.Weather;
import com.example.mvpdome.model.entity.WeatherInfo;
import com.example.mvpdome.presenter.WeatherPresenter;
import com.example.mvpdome.presenter.impl.WeatherPresenterImpl;
import com.example.mvpdome.ui.view.IWeatherView;


/**
 * 天气界面
 */
public class WeatherActivity extends ActionBarActivity implements IWeatherView, View.OnClickListener {
    private Dialog loadingDialog;
    private EditText cityNOInput;
    private TextView city;
    private TextView cityNO;
    private TextView temp;
    private TextView wd;
    private TextView ws;
    private TextView sd;
    private TextView wse;
    private TextView time;
    private TextView njd;
    private Button mBtnGo;

    private WeatherPresenter weatherPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
         //   getActionBar().setDisplayHomeAsUpEnabled(true);
        init();

    }

    private void init() {
        cityNOInput = (EditText) findViewById(R.id.et_city_no);
        city = (TextView) findViewById(R.id.tv_city);
        cityNO = (TextView) findViewById(R.id.tv_city_no);
        temp = (TextView) findViewById(R.id.tv_temp);
        wd = (TextView) findViewById(R.id.tv_WD);
        ws = (TextView) findViewById(R.id.tv_WS);
        sd = (TextView) findViewById(R.id.tv_SD);
        wse = (TextView) findViewById(R.id.tv_WSE);
        time = (TextView) findViewById(R.id.tv_time);
        njd = (TextView) findViewById(R.id.tv_njd);

        mBtnGo = (Button) findViewById(R.id.btn_go);

        mBtnGo.setOnClickListener(this);
        weatherPresenter = new WeatherPresenterImpl(this); //传入WeatherView
        loadingDialog = new ProgressDialog(this);
        loadingDialog.setTitle("加载天气中...");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_go:
                weatherPresenter.getWeather(cityNOInput.getText().toString().trim());
                break;
        }
    }


    @Override
    public void showLoading() {
        loadingDialog.show();
    }

    @Override
    public void hideLoading() {
        loadingDialog.dismiss();
    }

    @Override
    public void showError() {
        //Do something
        Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setWeatherInfo(Weather weather) {
        WeatherInfo info = weather.getWeatherinfo();
        city.setText(info.getCity());
        cityNO.setText(info.getCityid());
        temp.setText(info.getTemp());
        wd.setText(info.getWD());
        ws.setText(info.getWS());
        sd.setText(info.getSD());
        wse.setText(info.getWS());
        time.setText(info.getTemp());
        njd.setText(info.getNjd());
    }

}
