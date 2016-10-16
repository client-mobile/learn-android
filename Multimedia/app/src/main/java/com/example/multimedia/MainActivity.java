package com.example.multimedia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {
    private Button notification_test_btn;
    private Button sms_test_btn;
    private Button choose_pic_btn;
    private Button play_audio_btn;
    private Button play_video_btn;
    private Button thread_test_btn;
    private Button service_test_btn;
    private Button web_view_btn;
//    private Button network_test_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification_test_btn = (Button)findViewById(R.id.notification_test_btn);
        notification_test_btn.setOnClickListener(this);
        sms_test_btn = (Button)findViewById(R.id.sms_test_btn);
        sms_test_btn.setOnClickListener(this);
        choose_pic_btn = (Button)findViewById(R.id.choose_pic_btn);
        choose_pic_btn.setOnClickListener(this);
        play_audio_btn = (Button)findViewById(R.id.play_audio_btn);
        play_audio_btn.setOnClickListener(this);
        play_video_btn = (Button)findViewById(R.id.play_video_btn);
        play_video_btn.setOnClickListener(this);
        thread_test_btn = (Button)findViewById(R.id.thread_test_btn);
        thread_test_btn.setOnClickListener(this);
        service_test_btn = (Button)findViewById(R.id.service_test_btn);
        service_test_btn.setOnClickListener(this);
        web_view_btn = (Button)findViewById(R.id.web_view_btn);
        web_view_btn.setOnClickListener(this);
//        network_test_btn = (Button)findViewById(R.id.network_test_btn);
//        network_test_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.notification_test_btn:
                Intent intent=new Intent();
                intent.setClass(MainActivity.this, NotificationTestActivity.class);
                startActivity(intent);
                break;
            case R.id.sms_test_btn:
                Intent intent2=new Intent();
                intent2.setClass(MainActivity.this, SMSTestActivity.class);
                startActivity(intent2);
                break;
            case R.id.choose_pic_btn:
                Intent intent3=new Intent();
                intent3.setClass(MainActivity.this, ChoosePicTestActivity.class);
                startActivity(intent3);
                break;
            case R.id.play_audio_btn:
                Intent intent4=new Intent();
                intent4.setClass(MainActivity.this, PlayAudioTestActivity.class);
                startActivity(intent4);
                break;
            case R.id.play_video_btn:
                Intent intent5=new Intent();
                intent5.setClass(MainActivity.this, PlayVideoTestActivity.class);
                startActivity(intent5);
                break;
            case R.id.thread_test_btn:
                Intent intent6=new Intent();
                intent6.setClass(MainActivity.this, ThreadTestActivity.class);
                startActivity(intent6);
                break;
            case R.id.service_test_btn:
                Intent intent7=new Intent();
                intent7.setClass(MainActivity.this, ServiceTestActivity.class);
                startActivity(intent7);
                break;
            case R.id.web_view_btn:
                Intent intent8=new Intent();
                intent8.setClass(MainActivity.this, WebViewActivity.class);
                startActivity(intent8);
                break;
//            case R.id.network_test_btn:
//                Intent intent9=new Intent();
//                intent9.setClass(MainActivity.this, NetworkTestActivity.class);
//                startActivity(intent9);
//                break;
            default:
                break;
        }
    }

}
