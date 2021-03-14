package com.example.acer.startproject_117fd;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.acer.startproject_117fd.bean.WeatherInfo;
import com.example.acer.startproject_117fd.iface.WeatherListener;
import com.example.acer.startproject_117fd.model.WeatherModel;

public class MainActivity extends AppCompatActivity implements WeatherListener, View.OnClickListener {
    private EditText etcity;
    private Button btnfind1, btnfind2;
    private TextView tvcityname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void init() {
        etcity = (EditText) findViewById(R.id.editText);
        btnfind1 = (Button) findViewById(R.id.button);
        btnfind2 = (Button) findViewById(R.id.button2);
        tvcityname = (TextView) findViewById(R.id.textView3);
        btnfind1.setOnClickListener(this);
        btnfind2.setOnClickListener(this);

    }

    @Override
    public void onResponse(WeatherInfo weatherInfo) {
        if (weatherInfo != null) {
            tvcityname.setText(weatherInfo.getCity());
        } else
            tvcityname.setText("未知");
    }

    @Override
    public void onFail(String msg) {
        tvcityname.setText(msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                System.out.println("按钮1被点击");
                WeatherModel weatherModel=new WeatherModel();
                weatherModel.getWeather(etcity.getText().toString(),this);
                break;
            case R.id.button2:
                System.out.println("按钮2被点击");
                break;
        }
    }


}
