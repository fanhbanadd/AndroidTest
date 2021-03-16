package cn.edu.neusoft.dnui.startproject.model;


import cn.edu.neusoft.dnui.startproject.bean.WeatherResult;
import cn.edu.neusoft.dnui.startproject.iface.WeatherIface;
import cn.edu.neusoft.dnui.startproject.listener.WeatherListener;
import cn.edu.neusoft.dnui.startproject.service.Weather51Service;
import cn.edu.neusoft.dnui.startproject.service.WeatherService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Junsheng on 2016/12/14.
 */

public class Weather51Model  implements WeatherIface {
    private Weather51Service service;
    private  Retrofit retrofit;
    //private static Weather51Model model;
    private static final String BASE_URL = "http://weather.51wnl.com/weatherinfo/";
    //public Weather51Model(String url) {
    //    super(url);
   // }
    public Weather51Model(){
        //super(BASE_URL);
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();


    }
    /*public static Weather51Model getInstance(){
        if(model==null){
            model = new Weather51Model();

        }
        return model;
    }*/

    @Override
    public void getWeather(String cityNumber, final WeatherListener listener) {
        service = retrofit.create(Weather51Service.class);
        Call<WeatherResult> call = service.getResult(cityNumber,1);
        call.enqueue(new Callback<WeatherResult>() {
            @Override
            public void onResponse(Call<WeatherResult> call, Response<WeatherResult> response) {
                if(response.isSuccessful()&&response.body()!=null){
                    listener.onResponse(response.body().getWeatherinfo());
                }
                else{
                    listener.onFail("解析错误！");
                }
            }

            @Override
            public void onFailure(Call<WeatherResult> call, Throwable t) {
                listener.onFail(t.toString());
            }
        });
    }
}
