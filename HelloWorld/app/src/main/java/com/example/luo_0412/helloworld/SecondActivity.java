package com.example.luo_0412.helloworld;

/**
 * Created by Luo_0412 on 2016/10/7.
 */

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class SecondActivity extends Activity {
    Button tel_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // 隐藏标题
        setContentView(R.layout.second_layout);

        TextView tel_num=(TextView)findViewById(R.id.tel_num);
        tel_btn = (Button) findViewById(R.id.tel_btn);

        Intent intent=getIntent();
        final String StringE=intent.getStringExtra("extra");
        tel_num.setText(StringE);
        String StringG = StringE;

        // 判断奇偶数
        int i = Integer.parseInt(StringE);
        if(i % 2 == 1) {
            StringG += "是奇数";
        } else {
            StringG += "是偶数";
        }

        // Toast显示奇偶数判断
        Toast.makeText(SecondActivity.this, StringG,
                Toast.LENGTH_SHORT).show();

        // 打电话Intent
        tel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:" + StringE);
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });
    }

}
