package com.example.luo_0412.helloworld;

/**
 * Created by Luo_0412 on 2016/10/11.
 */



import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class WidgetDemoActivity2 extends Activity
{
    RadioGroup rg;
    TextView show;
    CheckBox redCbx, greenCbx, blueCbx;

    List<CheckBox> checkBoxs = new ArrayList<CheckBox>();

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widget_demo2);
        // 获取界面上rg、show两个组件
        rg = (RadioGroup) findViewById(R.id.rg);
        show = (TextView) findViewById(R.id.show);
        // 为RadioGroup组件的OnCheck事件绑定事件监听器
        rg.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                // 根据用户勾选的单选按钮来动态改变tip字符串的值
                String tip = checkedId == R.id.male ?
                        "您的性别是：男人": "您的性别是：女人";
                // 修改show组件中的文本。
                show.setText(tip);
            }
        });

        //获取复选框对象
        redCbx=(CheckBox)findViewById(R.id.red);
        blueCbx=(CheckBox)findViewById(R.id.blue);
        greenCbx=(CheckBox)findViewById(R.id.green);
        greenCbx.setChecked(true); //设置选中

        // 添加到集合中
        checkBoxs.add(redCbx);
        checkBoxs.add(blueCbx);
        checkBoxs.add(greenCbx);

        //复选框注册监听器
        redCbx.setOnCheckedChangeListener(cbxListener);
        greenCbx.setOnCheckedChangeListener(cbxListener);
        blueCbx.setOnCheckedChangeListener(cbxListener);

    }



    //创建复选框的监听器
    CompoundButton.OnCheckedChangeListener cbxListener = new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {

            String content = "";

            for (CheckBox cbx : checkBoxs) {
                if (cbx.isChecked()) {
                    content += cbx.getText() + " ";
                }
            }
            show.setText("您喜欢的颜色是："+content);

        }
    };
}
