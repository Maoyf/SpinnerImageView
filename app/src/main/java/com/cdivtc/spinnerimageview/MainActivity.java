package com.cdivtc.spinnerimageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //定义控件变量
    private Spinner mySpinner;

    //ImageView相关的控件变量
    private Button myButton1;
    private Button myButton2;
    private Button myButton3;
    private ImageView myImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        myButton1.setOnClickListener(bListener);
        myButton2.setOnClickListener(bListener);
        myButton3.setOnClickListener(bListener);
    }

    private void findViews() {
        //绑定控件
        mySpinner = findViewById(R.id.spinner);
        //通过List列表来存放数据
        List<String> list = new ArrayList<String>();
        list.add("Z移动1701班");
        list.add("Z移动1702班");
        list.add("Z移动1703班");
        list.add("Z移动1704班");
        //创建一个ArrayAdapter类型的数组适配器，它将界面控件spinner和底层数据ArrayList绑定在一起
        //让ArrayList中的数据显示在Spinner浮动菜单中
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        //绑定控件与底层数据
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //实现适配器的绑定
        mySpinner.setAdapter(adapter);

        myButton1 = findViewById(R.id.button1);
        myButton2 = findViewById(R.id.button2);
        myButton3 = findViewById(R.id.button3);
        myImageView = findViewById(R.id.imageView);
    }

    //Button监听
    Button.OnClickListener bListener = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button1:
                    myImageView.setVisibility(v.VISIBLE);
                    myImageView.setImageResource(R.drawable.img_1);
                    return;
                case R.id.button2:
                    myImageView.setVisibility(v.VISIBLE);
                    myImageView.setImageResource(R.drawable.img_2);
                    return;
                case R.id.button3:
                    myImageView.setVisibility(v.INVISIBLE);
                    return;
            }
        }
    };
}
