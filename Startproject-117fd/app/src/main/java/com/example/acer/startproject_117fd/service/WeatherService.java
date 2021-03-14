package com.example.acer.startproject_117fd.service;

import com.example.acer.startproject_117fd.bean.WeatherResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by acer on 2017/3/15.
 */

public interface WeatherService {
    @GET("data/sk/{cityNumber}.html")
    Call<WeatherResult> getResult(@Path("cityNumber")String cityNumber);
}
