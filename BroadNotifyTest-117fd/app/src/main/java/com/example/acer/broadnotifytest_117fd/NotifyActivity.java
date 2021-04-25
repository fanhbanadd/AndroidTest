package com.example.acer.broadnotifytest_117fd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class NotifyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);
        Intent intent=getIntent();
        String str=intent.getStringExtra("para3");
        Toast.makeText(this,"点击了通知"+str,Toast.LENGTH_SHORT);
    }
}
