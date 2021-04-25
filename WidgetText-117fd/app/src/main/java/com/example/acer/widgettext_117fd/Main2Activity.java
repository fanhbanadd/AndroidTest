package com.example.acer.widgettext_117fd;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        String str=intent.getStringExtra("param1");
        int n=intent.getIntExtra("param2",10);
        System.out.println(str+"---"+String.valueOf(n));
        Toast.makeText(this, str+"---"+String.valueOf(n), Toast.LENGTH_SHORT).show();

        TextView tv=(TextView)findViewById(R.id.textView2);
        tv.setText(str+"---"+String.valueOf(n));
    }
    @Override
    public void onClick(View view)
    {
        switch (view.getId()){

        }
    }
}
