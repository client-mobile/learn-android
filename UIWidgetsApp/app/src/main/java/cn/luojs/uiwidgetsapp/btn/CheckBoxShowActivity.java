package cn.luojs.uiwidgetsapp.btn;

/**
 * Created by Luo_0412 on 2016/11/11.
 */

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import cn.luojs.uiwidgetsapp.R;

/**
 * Created by Luo_0412 on 2016/10/20.
 */

public class CheckBoxShowActivity extends AppCompatActivity {
    private TextView hobby_list_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.layout_checkbox_show);

        hobby_list_text = (TextView)findViewById(R.id.hobby_list_text);
        Intent intent=getIntent();
        final String str = intent.getStringExtra("extra");
        hobby_list_text.setText("你的兴趣爱好是 " + str);
    }


}