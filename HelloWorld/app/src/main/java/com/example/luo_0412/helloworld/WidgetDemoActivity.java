package com.example.luo_0412.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;


/**
 * Created by Luo_0412 on 2016/10/10.
 */

public class WidgetDemoActivity extends Activity implements OnClickListener {
    private Button img_ctl_btn;
    private Button pgbar_ctl_btn;
    private Button edit_ctl_btn;

    private TextView demo_text_view;
    private EditText demo_edit_text;
    private ImageView demo_image_view;
    private ProgressBar demo_progress_bar;
    private RatingBar rb_normal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 基本设置
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.widget_demo);

        // 声名组件
        img_ctl_btn = (Button) findViewById(R.id.img_ctl_btn);
        pgbar_ctl_btn = (Button) findViewById(R.id.pgbar_ctl_btn);
        edit_ctl_btn = (Button) findViewById(R.id.edit_ctl_btn);

        img_ctl_btn.setOnClickListener(this);
        pgbar_ctl_btn.setOnClickListener(this);
        edit_ctl_btn.setOnClickListener(this);  // 注册按钮的监听器
        demo_text_view = (TextView) findViewById(R.id.demo_text_view);
        demo_edit_text = (EditText) findViewById(R.id.demo_edit_text);
        demo_image_view = (ImageView) findViewById(R.id.demo_image_view);
        demo_progress_bar = (ProgressBar) findViewById(R.id.demo_progress_bar);
        rb_normal = (RatingBar) findViewById(R.id.rb_normal);

        // 星级评分监听事件
        rb_normal.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(WidgetDemoActivity.this, "rating:" + String.valueOf(rating),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    //判断事件源
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_ctl_btn:
                demo_image_view.setImageResource(R.mipmap.ic_launcher);
                break;
            case R.id.pgbar_ctl_btn:
                if (demo_progress_bar.getVisibility() == View.GONE) {
                    demo_progress_bar.setVisibility(View.VISIBLE);
                } else {
                    demo_progress_bar.setVisibility(View.GONE);
                }
                break;
            case R.id.edit_ctl_btn:
                String inputText = demo_edit_text.getText().toString();
                Toast.makeText(WidgetDemoActivity.this, inputText,
                        Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }


}


