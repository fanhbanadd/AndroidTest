package cn.edu.neusoft.dnui.startproject.model;


import cn.edu.neusoft.dnui.startproject.bean.WeatherResult;
import cn.edu.neusoft.dnui.startproject.iface.WeatherIface;
import cn.edu.neusoft.dnui.startproject.listener.WeatherListener;
import cn.edu.neusoft.dnui.startproject.service.WeatherService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Junsheng on 2016/12/14.
 */
//模型
    public class WeatherModel  implements WeatherIface {
    private WeatherService service;
    private Retrofit retrofit;
    private static final String BASE_URL = "http://www.weather.com.cn/";//主机地址

    public WeatherModel(){
        //Retrofit使用-1
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)               //主机地址
                .addConverterFactory(GsonConverterFactory.create()) //解析方式
                .build();
    }

    @Override
    public void getWeather(String cityNumber, final WeatherListener listener) {
        //Retrofit使用-2
        service= retrofit.create(WeatherService.class);
        Call<WeatherResult> call = service.getResult(cityNumber);
        //Retrofit使用-3
        call.enqueue(new Callback<WeatherResult>() {
            @Override
            public void onResponse(Call<WeatherResult> call, Response<WeatherResult> response) {
                if(response.isSuccessful()&&response.body()!=null){
                    //调用监听事件接口的onResponse方法
                    listener.onResponse(response.body().getWeatherinfo());
                }
                else{
                    listener.onFail("解析错误！");
                }
            }

            @Override
            public void onFailure(Call<WeatherResult> call, Throwable t) {
                //调用监听事件接口的onFail方法
                listener.onFail(t.toString());
            }
        });
    }
}
