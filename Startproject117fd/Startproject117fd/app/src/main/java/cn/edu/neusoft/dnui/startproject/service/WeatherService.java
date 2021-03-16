package cn.edu.neusoft.dnui.startproject.service;

import cn.edu.neusoft.dnui.startproject.bean.WeatherResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Junsheng on 2016/12/14.
 */
//Retrofit turns your HTTP API into a Java interface.
public interface WeatherService {
    //将接口的URL补充完整
    @GET("data/sk/{cityNumber}.html")
    //向API传参数
    Call<WeatherResult> getResult(@Path("cityNumber") String cityNumber);

}
