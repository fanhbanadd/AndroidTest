package com.example.acer.startproject_117fd.model;

import com.example.acer.startproject_117fd.bean.WeatherResult;
import com.example.acer.startproject_117fd.iface.WeatherListener;
import com.example.acer.startproject_117fd.iface.Weatheriface;
import com.example.acer.startproject_117fd.service.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by acer on 2017/3/14.
 */

public class WeatherModel implements Weatheriface{
    private Retrofit retrofit;
    private String BASEURL="http://www.weather.com.cn/";
    private WeatherService weatherService;

    public  WeatherModel(){
        retrofit=new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public void getWeather(String cityno, final WeatherListener listener) {
        weatherService=retrofit.create(WeatherService.class);
        Call<WeatherResult> call=weatherService.getResult(cityno);

        call.enqueue(new Callback<WeatherResult>() {
            @Override
            public void onResponse(Call<WeatherResult> call, Response<WeatherResult> response) {
                if (response.isSuccessful() && response.body()!=null)
                    listener.onResponse(response.body().getWeatherinfo());
                else
                    listener.onFail("onresponse fail");
            }

            @Override
            public void onFailure(Call<WeatherResult> call, Throwable t) {
                listener.onFail(t.toString());

            }
        });
    }
}
