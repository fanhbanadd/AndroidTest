package com.example.acer.broadnotifytest_117fd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et;
    private Button btnsend,btnnotify;
    private String UNIQUE_STRING="com.example.acer.broadnotifytest_117fd";

    private View.OnClickListener listener=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button:
                    Intent intent=new Intent(UNIQUE_STRING);
                    intent.putExtra("para2",et.getText().toString());
                    sendBroadcast(intent);

                    break;
                case R.id.button2:
                    MyReceiver.manager.cancel(MyReceiver.notifyID);
                    break;

            }

        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        et=(EditText)findViewById(R.id.editText);
        btnsend=(Button)findViewById(R.id.button);
        btnnotify=(Button)findViewById(R.id.button2);

        btnsend.setOnClickListener(listener);
        btnnotify.setOnClickListener(listener);

    }
}
