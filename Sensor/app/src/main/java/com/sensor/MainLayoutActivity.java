package com.sensor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainLayoutActivity extends AppCompatActivity implements OnClickListener {

    private Button light_sensor_btn;
    private Button accelerometer_sensor_btn;
    private Button compass_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        light_sensor_btn = (Button)findViewById(R.id.light_sensor_btn);
        light_sensor_btn.setOnClickListener(this);
        accelerometer_sensor_btn = (Button)findViewById(R.id.accelerometers_sensor_btn);
        accelerometer_sensor_btn.setOnClickListener(this);
        compass_btn = (Button)findViewById(R.id.compass_btn);
        compass_btn.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.light_sensor_btn:
                Intent intent = new Intent();
                intent.setClass(MainLayoutActivity.this, LightSensorTestActivity.class);
                startActivity(intent);
                break;
            case R.id.accelerometers_sensor_btn:
                Intent intent2 = new Intent();
                intent2.setClass(MainLayoutActivity.this, AccelerometerSensorTestActivity.class);
                startActivity(intent2);
                break;
            case R.id.compass_btn:
                Intent intent3 = new Intent();
                intent3.setClass(MainLayoutActivity.this, CompassTestActivity.class);
                startActivity(intent3);
                break;
            default:
                break;
        }
    }
}
