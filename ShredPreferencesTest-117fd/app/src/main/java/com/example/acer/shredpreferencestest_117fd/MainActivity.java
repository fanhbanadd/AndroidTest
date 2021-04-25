package com.example.acer.shredpreferencestest_117fd;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText etname,etpass;
    private Switch sw;

    private String username="",password="";
    private SharedPreferences sp;
    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId())
            {
                case R.id.btnlogin:
                    //登录按钮操作
                    username=etname.getText().toString();
                    password=etpass.getText().toString();
                    if (username.equals("123") && password.equals("123")){
                        Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                        //if (sw.isChecked()){
                            saveSP();
                        //}

                    }


                    break;
            }
        }
    };
    private  void  saveSP(){
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("username",username);
        editor.putString("passwoed",password);
        editor.putBoolean("remember",sw.isChecked());
        editor.commit();

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        sp=getSharedPreferences("login",MODE_PRIVATE);
        readSP();
    }

    private void readSP() {
        String name=sp.getString("username",null);
        String pass=sp.getString("password",null);
        Boolean b=sp.getBoolean("remeber",false);
        if (b){
            etname.setText(name);
            etpass.setText(pass);
            sw.setChecked(b);
        }
    }

    private void init() {
        button=(Button)findViewById(R.id.btnlogin);
        etname=(EditText)findViewById(R.id.editText);
        etpass=(EditText)findViewById(R.id.editText2);
        sw=(Switch) findViewById(R.id.switch1);
        button.setOnClickListener(listener);
    }
}
