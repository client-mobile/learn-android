package cn.luojs.uiwidgetsapp;

import android.os.Bundle;
import android.support.annotation.BoolRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Luo_0412 on 2016/11/11.
 */

public class ImageViewActivity extends AppCompatActivity {
    ImageView img_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.layout_imageview);

        img_view = (ImageView) findViewById(R.id.img_view);
        img_view.setOnClickListener(new View.OnClickListener() {

            Boolean isOddClickTimes = true; // 放在这里,注意初始值
            @Override
            public void onClick(View v) {
                if(isOddClickTimes == true) {
                    img_view.setImageResource(R.mipmap.ic_launcher);
                }
                else {
                    img_view.setImageResource(R.mipmap.apple_pic);
                }
                isOddClickTimes = !isOddClickTimes;
            }
        });
    }
}

