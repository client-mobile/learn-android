package com.example.baidumaptest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
//import android.widget.Toast;


public class FirstActivity extends Activity implements OnClickListener {

    private Button location_test_btn;
    private Button baidu_map_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        location_test_btn = (Button)findViewById(R.id.location_test_btn);
        location_test_btn.setOnClickListener(this);
        baidu_map_btn = (Button)findViewById(R.id.baidu_map_btn);
        baidu_map_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.location_test_btn:
                Intent intent = new Intent();
                intent.setClass(FirstActivity.this, LocationTestActivity.class);
                startActivity(intent);
                break;
            case R.id.baidu_map_btn:
                Intent intent2 = new Intent();
                intent2.setClass(FirstActivity.this, MainActivity.class);
                startActivity(intent2);
//                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
