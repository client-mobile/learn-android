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

public class CheckboxShowActivity extends Activity implements OnClickListener {
    private TextView hobby_list_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_checkbox_show);

        hobby_list_text = (TextView)findViewById(R.id.hobby_list_text);
        Intent intent=getIntent();
        final String str = intent.getStringExtra("extra");
        hobby_list_text.setText("你的兴趣爱好是 " + str);
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