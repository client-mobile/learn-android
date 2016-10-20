package com.example.luo_0412.helloworld;

/**
 * Created by Luo_0412 on 2016/10/20.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Luo_0412 on 2016/10/20.
 */

public class LoginActivity extends Activity implements OnClickListener {
    private EditText user_name_input;
    private Button add_user_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        add_user_btn = (Button) findViewById(R.id.add_user_btn);
        add_user_btn.setOnClickListener(this);
        user_name_input = (EditText) findViewById(R.id.user_name_input);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_user_btn:
                Intent intent1 = new Intent();
                String content = user_name_input.getText().toString();  
                                                        // 获取用户名
                intent1.putExtra("extra", content);
                intent1.setClass(LoginActivity.this, LoginShowActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
    }


}