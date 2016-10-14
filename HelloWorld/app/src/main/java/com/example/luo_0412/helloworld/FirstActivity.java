package com.example.luo_0412.helloworld;
/**
 * Created by Luo_0412 on 2016/10/7.
 */

import android.app.Activity;
//import android.app.FragmentManager;
//import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class FirstActivity extends Activity implements OnClickListener {
    private Button send_btn;
    private Button widget_demo_btn;
    private Button widget_demo_btn2;
    private Button linear_layout_btn;
    private Button relative_layout_btn;
    private Button frame_layout_btn;
    private Button table_layout_btn;
    private Button list_view_btn;
    private Button myself_title_btn;
    private Button msg_ctl_btn;
    private Button fragment_ctl_btn;
    private Button news_ctl_btn;
    private EditText tel_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  // 隐藏标题
                       // 一定要在setContentView()之前执行，不然会报错
                                    // 现在的bug是怎么再次显示出来
        setContentView(R.layout.first_layout);

        send_btn = (Button) findViewById(R.id.send_btn);
        send_btn.setOnClickListener(this);
        widget_demo_btn = (Button) findViewById(R.id.widget_demo_btn);
        widget_demo_btn.setOnClickListener(this);
        widget_demo_btn2 = (Button) findViewById(R.id.widget_demo_btn2);
        widget_demo_btn2.setOnClickListener(this);
        linear_layout_btn = (Button) findViewById(R.id.linear_layout_btn);
        linear_layout_btn.setOnClickListener(this);
        relative_layout_btn = (Button) findViewById(R.id.relative_layout_btn);
        relative_layout_btn.setOnClickListener(this);
        frame_layout_btn = (Button) findViewById(R.id.frame_layout_btn);
        frame_layout_btn.setOnClickListener(this);
        table_layout_btn = (Button) findViewById(R.id.table_layout_btn);
        table_layout_btn.setOnClickListener(this);
        list_view_btn = (Button) findViewById(R.id.list_view_btn);
        list_view_btn.setOnClickListener(this);
        myself_title_btn = (Button) findViewById(R.id.myself_title_btn);
        myself_title_btn.setOnClickListener(this);
        msg_ctl_btn = (Button) findViewById(R.id.msg_ctl_btn);
        msg_ctl_btn.setOnClickListener(this);
        fragment_ctl_btn = (Button) findViewById(R.id.fragment_ctl_btn);
        fragment_ctl_btn.setOnClickListener(this);
        news_ctl_btn = (Button) findViewById(R.id.news_ctl_btn);
        news_ctl_btn.setOnClickListener(this);

        tel_txt = (EditText) findViewById(R.id.tel_txt);


//        fragment_ctl_btn.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent();
//                intent.setClass(FirstActivity.this, FragmentDemoActivity.class);
//                startActivity(intent);
//            }
//        });
//
//
//        news_ctl_btn.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(FirstActivity.this, NewsDemoActivity.class);
//                startActivity(intent);
//            }
//        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_btn:
//                tel_txt.setText("已发送号码给Mary！");
                Intent intent=new Intent();
                String content = tel_txt.getText().toString();  // 获取EditText的值
                intent.putExtra("extra", content);
                intent.setClass(FirstActivity.this, SecondActivity.class); // 跳转页面
                startActivity(intent);
                break;
            case R.id.widget_demo_btn:
                Intent intent2 = new Intent();
                intent2.setClass(FirstActivity.this, WidgetDemoActivity.class);
                startActivity(intent2);
                break;
            case R.id.widget_demo_btn2:
                Intent intent3=new Intent();
                intent3.setClass(FirstActivity.this, WidgetDemoActivity2.class);
                startActivity(intent3);
                break;
            case R.id.linear_layout_btn:
                Intent intent4=new Intent();
                intent4.setClass(FirstActivity.this, LinearLayoutDemoActivity.class);
                startActivity(intent4);
                break;
            case R.id.relative_layout_btn:
                Intent intent5=new Intent();
                intent5.setClass(FirstActivity.this, RelativeLayoutDemoActivity.class);
                startActivity(intent5);
                break;
            case R.id.frame_layout_btn:
                Intent intent6=new Intent();
                intent6.setClass(FirstActivity.this, FrameLayoutDemoActivity.class);
                startActivity(intent6);
                break;
            case R.id.table_layout_btn:
                Intent intent7=new Intent();
                intent7.setClass(FirstActivity.this, TableLayoutDemoActivity.class);
                startActivity(intent7);
                break;
            case R.id.list_view_btn:
                Intent intent8=new Intent();
                intent8.setClass(FirstActivity.this, ListViewDemoActivity.class);
                startActivity(intent8);
                break;
            case R.id.myself_title_btn:
                Intent intent9=new Intent();
                intent9.setClass(FirstActivity.this, MyselfTitleDemoActivity.class);
                startActivity(intent9);
                break;
            case R.id.msg_ctl_btn:
                Intent intent10=new Intent();
                intent10.setClass(FirstActivity.this, MsgActivity.class);
                startActivity(intent10);
                break;
            case R.id.fragment_ctl_btn:
//                Intent intent11=new Intent();
//                intent11.setClass(FirstActivity.this, FragmentDemoActivity.class);
//                startActivity(intent11);
                                Intent intent_frag=new Intent();
                intent_frag.setClass(FirstActivity.this, FragmentDemoActivity.class);
                startActivity(intent_frag);
                break;
            case R.id.news_ctl_btn:
                Intent intent12 = new Intent();
                intent12.setClass(FirstActivity.this, NewsDemoActivity.class);
                startActivity(intent12);
                break;
            default:
                break;
        }
    }




}
