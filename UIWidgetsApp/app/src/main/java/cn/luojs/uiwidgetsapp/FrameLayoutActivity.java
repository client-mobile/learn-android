package cn.luojs.uiwidgetsapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by Luo_0412 on 2016/10/11.
 */

public class FrameLayoutActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 基本设置
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_framelayout);

    }
}
