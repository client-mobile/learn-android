package com.example.luo_0412.learnmore;

/**
 * Created by Luo_0412 on 2016/10/14.
 * 存在延时,不是按钮点下去立刻强制退出的
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BroadcastOfflineActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast_offline);
        Button forceOffline = (Button) findViewById(R.id.force_offline);
        forceOffline.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        "com.example.luo_0412.learnmore.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }

}
