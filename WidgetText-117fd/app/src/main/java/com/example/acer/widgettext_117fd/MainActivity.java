package com.example.acer.widgettext_117fd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv;
    private EditText et;
    private Button btngetext,btnsetimg;
    private ImageButton ibtn;
    private ImageView iv;

    @Override
    public void onClick(View view)
     {
        switch (view.getId())
        {
            case R.id.button:
                String str=et.getText().toString();
                tv.setText(str);
                break;
            case R.id.button2:
                iv.setImageResource(R.drawable.shanshui);
                break;
            case R.id.imageButton:
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("param1",et.getText().toString());
                intent.putExtra("param2",3);
                startActivity(intent);
                break;
        }
     }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        tv=(TextView)findViewById(R.id.textView2);
        et=(EditText)findViewById(R.id.editText);
        btngetext=(Button)findViewById(R.id.button);
        btnsetimg=(Button)findViewById(R.id.button2);
        iv=(ImageView)findViewById(R.id.imageView);
        ibtn=(ImageButton)findViewById(R.id.imageButton);

        btngetext.setOnClickListener(this);
        btnsetimg.setOnClickListener(this);
        ibtn.setOnClickListener(this);
    }
}
