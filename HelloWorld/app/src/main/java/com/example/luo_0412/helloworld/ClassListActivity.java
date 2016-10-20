package com.example.luo_0412.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * Created by Luo_0412 on 2016/10/20.
 */

public class ClassListActivity extends Activity implements OnClickListener {

    private String[] class1 = {"林黛玉","薛宝钗","王熙凤","袭人","晴雯",
                               "秦钟","贾宝玉","贾涟","贾政","林黛玉",
                               "薛宝钗","王熙凤","袭人","晴雯",
                               "秦钟","贾宝玉","贾涟","贾政"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_class_list);



            ArrayAdapter<String>    adapter = new ArrayAdapter<>(
                    ClassListActivity.this,
                    android.R.layout.simple_list_item_1, class1);


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