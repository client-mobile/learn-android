package cn.luojs.uiwidgetsapp.btn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;

import cn.luojs.uiwidgetsapp.R;

/**
 * Created by Luo_0412 on 2016/10/20.
 */

public class RadioButtonActivity extends AppCompatActivity implements OnClickListener {
    private Button class_submit_btn;
    RadioGroup rg;
    String checkedClass = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.layout_radiobutton);

        class_submit_btn = (Button)findViewById(R.id.class_submit_btn);
        class_submit_btn.setOnClickListener(this);

        rg = (RadioGroup) findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                checkedClass = checkedId == R.id.male ? "male" : "female";

                switch(checkedId) {
                    case R.id.male:
                        checkedClass = "0";
                        break;
                    case R.id.female:
                        checkedClass = "1";
                        break;
                }

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.class_submit_btn:
                Intent it = new Intent();
                it.putExtra("extra", checkedClass);
                it.setClass(RadioButtonActivity.this, RadioButtonShowActivity.class);
                startActivity(it);
                break;
            default:
                break;
        }
    }


}