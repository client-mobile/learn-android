package cn.luojs.uiwidgetsapp.dialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.luojs.uiwidgetsapp.R;

/**
 * Created by Jay on 2015/9/28 0028.
 */
public class NotificationOtherActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.layout_notification_other);
    }
}
