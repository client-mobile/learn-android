package cn.luojs.uiwidgetsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Luo_0412 on 2016/11/11.
 */

public class TextViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.layout_textview);


    }
}
