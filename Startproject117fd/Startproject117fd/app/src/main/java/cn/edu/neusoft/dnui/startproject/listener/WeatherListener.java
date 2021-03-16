package cn.edu.neusoft.dnui.startproject.listener;

import cn.edu.neusoft.dnui.startproject.bean.WeatherInfo;

/**
 * Created by Junsheng on 2016/12/14.
 */
//异步访问网络，成功或失败
public interface WeatherListener {
    public void onResponse(WeatherInfo weather);
    public void onFail(String msg);
}
