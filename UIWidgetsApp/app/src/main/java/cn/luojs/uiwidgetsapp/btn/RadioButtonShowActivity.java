package cn.luojs.uiwidgetsapp.btn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import cn.luojs.uiwidgetsapp.R;


/**
 * Created by Luo_0412 on 2016/10/20.
 */

public class RadioButtonShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.layout_radiobutton_show);

        String[] class1 = {"林黛玉","薛宝钗","王熙凤","袭人","晴雯",
                "秦钟","贾宝玉","贾涟","贾政","林黛玉",
                "薛宝钗","王熙凤","袭人","晴雯",
                "秦钟","贾宝玉","贾涟","贾政"};
        String[] class2 = {"朱朝乾", "陈双喜","王小迎","王武","骆金参",
                "胡康程", "马吴渊", "黄锐", "俞梦泽", "黄益华", "余炳皞",
                "朱朝乾", "陈双喜","王小迎","王武","骆金参",
                "胡康程", "马吴渊", "黄锐", "俞梦泽", "黄益华", "余炳皞"};

        Intent extra = getIntent();
        String checkedClass = extra.getStringExtra("extra");

        ArrayAdapter<String> adapter;

        // equals 和 == 有什么区别
        if(checkedClass.equals("0") ) {
            adapter = new ArrayAdapter<>(
                    RadioButtonShowActivity.this,
                    android.R.layout.simple_list_item_1, class1);
        }
        else {
            adapter = new ArrayAdapter<>(
                    RadioButtonShowActivity.this,
                    android.R.layout.simple_list_item_1, class2);
        }

        ListView listView = (ListView) findViewById(R.id.class_list_view);
        listView.setAdapter(adapter);
    }
}