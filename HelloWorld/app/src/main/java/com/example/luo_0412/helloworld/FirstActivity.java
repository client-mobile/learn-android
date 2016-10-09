package com.example.luo_0412.helloworld;
/**
 * Created by Luo_0412 on 2016/10/7.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

public class FirstActivity extends Activity {
    Button send_btn;
    EditText tel_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  // 隐藏标题
        setContentView(R.layout.first_layout);

        send_btn = (Button) findViewById(R.id.send_btn);
        tel_txt = (EditText) findViewById(R.id.tel_txt);

        // 发送数字的按钮
        send_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                String content = tel_txt.getText().toString();  // 获取EditText的值
                intent.putExtra("extra", content);
                intent.setClass(FirstActivity.this, SecondActivity.class); // 跳转页面
                startActivity(intent);
            }
        });

    }


}
