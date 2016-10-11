package com.example.luo_0412.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Luo_0412 on 2016/10/11.
 */

public class ListViewDemoActivity extends Activity {
    private String[] data = { "Apple", "Banana", "Orange", "Watermelon",
            "Pear", "Grape", "Pineapple", "Strawberry", "Cherry",
            "Mango" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 基本设置
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_demo);

        // ListView和数据之间的关联：调用ListView的setAdapter()方法
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                ListViewDemoActivity.this,
                android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);


    }

}
