package cn.luojs.uiwidgetsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Luo_0412 on 2016/10/11.
 */

public class TableLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 基本设置
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.layout_tablelayout);

    }

}

