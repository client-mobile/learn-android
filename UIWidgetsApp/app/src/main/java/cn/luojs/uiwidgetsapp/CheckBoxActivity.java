package cn.luojs.uiwidgetsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luo_0412 on 2016/11/11.
 */


public class CheckBoxActivity extends AppCompatActivity implements View.OnClickListener {

    private Button hobby_submit_btn;

    String content = "";

    CheckBox movieCbx, musicCbx, readCbx;
    List<CheckBox> checkBoxs = new ArrayList<CheckBox>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.layout_checkbox);

        hobby_submit_btn = (Button) findViewById(R.id.hobby_submit_btn);
        hobby_submit_btn.setOnClickListener(this);

        //获取复选框对象
        movieCbx=(CheckBox)findViewById(R.id.movie);
        readCbx=(CheckBox)findViewById(R.id.read);
        musicCbx=(CheckBox)findViewById(R.id.music);
        musicCbx.setChecked(true); //设置选中

        // 添加到集合中
        checkBoxs.add(musicCbx);
        checkBoxs.add(readCbx);
        checkBoxs.add(movieCbx);

        movieCbx.setOnCheckedChangeListener(cbxListener);
        readCbx.setOnCheckedChangeListener(cbxListener);
        musicCbx.setOnCheckedChangeListener(cbxListener);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hobby_submit_btn:
                Intent intent1 = new Intent();
                intent1.putExtra("extra", content);
                intent1.setClass(CheckBoxActivity.this, CheckBoxShowActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
    }

    //创建复选框的监听器
    CompoundButton.OnCheckedChangeListener cbxListener = new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {
            content = ""; // 记得初始化
            for (CheckBox cbx : checkBoxs) {
                if (cbx.isChecked()) {
                    content += cbx.getText() + " ";
                }
            }
        }
    };


}

