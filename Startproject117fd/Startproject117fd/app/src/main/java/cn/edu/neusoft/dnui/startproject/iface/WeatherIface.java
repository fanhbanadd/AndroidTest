package cn.edu.neusoft.dnui.startproject.iface;

import cn.edu.neusoft.dnui.startproject.listener.WeatherListener;

/**
 * Created by Junsheng on 2016/12/14.
 */
//定义统一接口，方便多种方式得到天气信息
public interface WeatherIface {
    void getWeather(String cityNumber, WeatherListener listener);
}
