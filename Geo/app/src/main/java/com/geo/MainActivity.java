package com.geo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

    private Button location_test_btn;
    private Button baidu_map_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                intent.setClass(MainActivity.this, LocationTestActivity.class);
                startActivity(intent);
                break;
            case R.id.baidu_map_btn:
                Intent intent2 = new Intent();
                intent2.setClass(MainActivity.this, BaiduMapTestActivity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }
}
