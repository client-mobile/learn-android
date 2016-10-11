package com.example.luo_0412.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by Luo_0412 on 2016/10/11.
 */

public class ListViewDemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 基本设置
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.list_view_demo);


    }

}
