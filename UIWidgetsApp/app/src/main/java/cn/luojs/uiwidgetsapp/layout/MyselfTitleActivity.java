package cn.luojs.uiwidgetsapp.layout;

/**
 * Created by Luo_0412 on 2016/11/11.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.luojs.uiwidgetsapp.R;

/**
 * Created by Luo_0412 on 2016/10/11.
 */

public class MyselfTitleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.layout_myself_title);
    }
}