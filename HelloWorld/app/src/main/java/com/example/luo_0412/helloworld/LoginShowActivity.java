package com.example.luo_0412.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;

/**
 * Created by Luo_0412 on 2016/10/20.
 */

public class LoginShowActivity extends Activity implements OnClickListener {

    private TextView show_user_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login_show);

        show_user_name = (TextView)findViewById(R.id.show_user_name);

        Intent intent=getIntent();
        final String str = intent.getStringExtra("extra");
        show_user_name.setText("用户名：" + str);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_btn:
                break;
            default:
                break;
        }
    }


}