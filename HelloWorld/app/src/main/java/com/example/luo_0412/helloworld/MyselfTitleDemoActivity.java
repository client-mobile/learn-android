package com.example.luo_0412.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by Luo_0412 on 2016/10/11.
 */

public class MyselfTitleDemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.myself_title_demo);
    }
}
