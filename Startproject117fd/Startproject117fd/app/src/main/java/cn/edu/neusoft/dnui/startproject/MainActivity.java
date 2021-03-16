package cn.edu.neusoft.dnui.startproject;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import cn.edu.neusoft.dnui.startproject.bean.WeatherInfo;
import cn.edu.neusoft.dnui.startproject.listener.WeatherListener;
import cn.edu.neusoft.dnui.startproject.model.Weather51Model;
import cn.edu.neusoft.dnui.startproject.model.WeatherModel;
//控制器
public class MainActivity extends AppCompatActivity implements View.OnClickListener, WeatherListener {

    private EditText cityNOInput;
    private TextView city;
    private TextView cityNO;
    private TextView temp;
    private TextView wd;
    private TextView ws;
    private TextView sd;
    private ProgressDialog loadingWeather;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取控件
        cityNOInput = (EditText) findViewById(R.id.et_city_no);
        city = (TextView) findViewById(R.id.tv_city);
        cityNO = (TextView) findViewById(R.id.tv_city_no);
        temp = (TextView) findViewById(R.id.tv_temp);
        wd = (TextView) findViewById(R.id.tv_WD);
        ws = (TextView) findViewById(R.id.tv_WS);
        sd = (TextView) findViewById(R.id.tv_SD);
        //实例化进度条
        loadingWeather = new ProgressDialog(this);
        loadingWeather.setTitle("查询中...");
        //获取按钮控件并设置按钮的点击事件监听器
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //city.setText("查询中...");
        //数据加载进度条
        loadingWeather.show();
        switch (v.getId()) {
            case R.id.button1:
                //普通创建对象方式
                WeatherModel weatherModel = new WeatherModel();
                weatherModel.getWeather(cityNOInput.getText().toString(), this);
                //工厂模式
                //WeatherFactory.getInstance("weather").getWeather(cityNOInput.getText().toString(),this);
                break;
            case R.id.button2:

                //普通创建对象方式
                Weather51Model weather51Model = new Weather51Model();
                weather51Model.getWeather(cityNOInput.getText().toString(), this);
                //工厂模式
                //WeatherFactory.getInstance("51wnl").getWeather(cityNOInput.getText().toString(),this);
                break;
            default:
                break;
        }
    }

    //获取数据成功
    @Override
    public void onResponse(WeatherInfo weather) {
        //取消数据加载进度条
        loadingWeather.dismiss();
        //显示获得的天气数据
        if (weather != null) {
            city.setText(weather.getCity());
            cityNO.setText(weather.getCityid());
            temp.setText(weather.getTemp());
            wd.setText(weather.getWD());
            ws.setText(weather.getWS());
            sd.setText(weather.getSD());
        } else {
            city.setText("未知");
        }

    }

    //获取数据失败
    @Override
    public void onFail(String msg) {
        //取消数据加载进度条
        loadingWeather.dismiss();
        city.setText(msg);
        //Toast.makeText(this,"fail:"+msg,Toast.LENGTH_SHORT).show();
    }
}
