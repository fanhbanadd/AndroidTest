package cn.edu.neusoft.dnui.startproject.service;

import cn.edu.neusoft.dnui.startproject.bean.WeatherResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Junsheng on 2016/12/14.
 */

public interface Weather51Service {
    @GET("GetMoreWeather")
    Call<WeatherResult> getResult(@Query("cityCode") String cityCode,@Query("weatherType") int weatherType);
}
