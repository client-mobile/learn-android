package com.example.luo_0412.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by Luo_0412 on 2016/10/10.
 */

public class WidgetDemoActivity extends Activity {
    Button demo_btn;
    TextView demo_text_view;
    EditText demo_edit_text;
    ImageView demo_image_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 基本设置
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.widget_demo);

        // 声名元素
        demo_btn = (Button) findViewById(R.id.demo_btn);
        demo_text_view = (TextView) findViewById(R.id.demo_text_view);
        demo_edit_text = (EditText) findViewById(R.id.demo_edit_text);
        demo_image_view = (ImageView) findViewById(R.id.demo_image_view);

//        @Override
//        public void onClick(View v) {
//            switch (v.getId()) {
//                case R.id.demo_btn:
//                    demo_image_view.setImageResource(R.mipmap.ic_launcher);
//                    break;
//                default:
//                    break;
//            }
//        }

    }


}


