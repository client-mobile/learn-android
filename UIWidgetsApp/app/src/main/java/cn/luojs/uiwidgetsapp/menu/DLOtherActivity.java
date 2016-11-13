package cn.luojs.uiwidgetsapp.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.luojs.uiwidgetsapp.R;

/**
 * Created by Jay on 2015/10/9 0009.
 */
public class DLOtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.layout_dl_other);
    }
}