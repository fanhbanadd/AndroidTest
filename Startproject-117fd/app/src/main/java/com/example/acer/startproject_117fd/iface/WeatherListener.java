package com.example.acer.startproject_117fd.iface;

import com.example.acer.startproject_117fd.bean.WeatherInfo;

/**
 * Created by acer on 2017/3/14.
 */

public interface WeatherListener {
    void onResponse(WeatherInfo weatherInfo);
    void onFail(String msg);
}
