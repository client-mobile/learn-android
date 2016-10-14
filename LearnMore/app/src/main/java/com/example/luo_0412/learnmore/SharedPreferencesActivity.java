package com.example.luo_0412.learnmore;

/**
 * Created by Luo_0412 on 2016/10/14.
 */

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SharedPreferencesActivity extends Activity {

    private Button saveData;

    private Button restoreData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        saveData = (Button) findViewById(R.id.save_data);
        restoreData = (Button) findViewById(R.id.restore_data);
        saveData.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
                editor.putString("name", "Tom");
                editor.putInt("age", 28);
                editor.putBoolean("married", false); // 存储三种数据类型
                editor.commit();
            }
        });
        restoreData.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
                String name = pref.getString("name", "");
                int age = pref.getInt("age", 0);
                boolean married = pref.getBoolean("married", false);
                Log.d("SharedPref", "name is " + name);
                Log.d("SharedPref", "age is " + age);
                Log.d("SharedPref", "married is " + married);
                // 点击按钮后显示在Android Monitor上
            }
        });
    }

}
