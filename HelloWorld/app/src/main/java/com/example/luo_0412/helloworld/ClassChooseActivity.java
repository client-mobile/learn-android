package com.example.luo_0412.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Luo_0412 on 2016/10/20.
 */

public class ClassChooseActivity extends Activity implements OnClickListener {
    private Button class_submit_btn;
    RadioGroup rg;
    String checkedClass = "male";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_class_choose);

        class_submit_btn = (Button)findViewById(R.id.class_submit_btn);
        class_submit_btn.setOnClickListener(this);
        rg = (RadioGroup) findViewById(R.id.rg);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                checkedClass = checkedId == R.id.male ? "male" : "female";
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.class_submit_btn:
                Intent intent1 = new Intent();
                if(checkedClass == "male") {
                    intent1.setClass(ClassChooseActivity.this, ClassListActivity.class);
                } else {
                    intent1.setClass(ClassChooseActivity.this, ClassList2Activity.class);
                }
                startActivity(intent1);
                break;
            default:
                break;
        }
    }


}