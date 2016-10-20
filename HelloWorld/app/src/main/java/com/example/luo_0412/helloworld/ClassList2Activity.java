package com.example.luo_0412.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * Created by Luo_0412 on 2016/10/20.
 */

public class ClassList2Activity extends Activity implements OnClickListener {
    private String[] class2 = {"朱朝乾", "陈双喜","王小迎","王武","骆金参",
            "胡康程", "马吴渊", "黄锐", "俞梦泽", "黄益华", "余炳皞",
            "朱朝乾", "陈双喜","王小迎","王武","骆金参",
            "胡康程", "马吴渊", "黄锐", "俞梦泽", "黄益华", "余炳皞"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_class_list);

        ArrayAdapter<String>    adapter = new ArrayAdapter<>(
                ClassList2Activity.this,
                android.R.layout.simple_list_item_1, class2);


        ListView listView = (ListView) findViewById(R.id.class_list_view);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_btn:
                break;
            default:
                break;
        }
    }


}