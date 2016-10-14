package com.example.luo_0412.helloworld;

/**
 * Created by Luo_0412 on 2016/10/13.
 */

import android.os.Bundle;
import android.view.Window;
import android.app.Activity;

public class NewsDemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.news_demo);
    }

}

