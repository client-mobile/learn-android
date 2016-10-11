package com.example.luo_0412.helloworld;
/**
 * Created by Luo_0412 on 2016/10/7.
 */

import android.app.Activity;
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

public class FirstActivity extends Activity {
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
    private EditText tel_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  // 隐藏标题
                       // 一定要在setContentView()之前执行，不然会报错
                                    // 现在的bug是怎么再次显示出来
        setContentView(R.layout.first_layout);

        send_btn = (Button) findViewById(R.id.send_btn);
        widget_demo_btn = (Button) findViewById(R.id.widget_demo_btn);
        widget_demo_btn2 = (Button) findViewById(R.id.widget_demo_btn2);
        linear_layout_btn = (Button) findViewById(R.id.linear_layout_btn);
        relative_layout_btn = (Button) findViewById(R.id.relative_layout_btn);
        frame_layout_btn = (Button) findViewById(R.id.frame_layout_btn);
        table_layout_btn = (Button) findViewById(R.id.table_layout_btn);
        list_view_btn = (Button) findViewById(R.id.list_view_btn);
        myself_title_btn = (Button) findViewById(R.id.myself_title_btn);
        msg_ctl_btn = (Button) findViewById(R.id.msg_ctl_btn);
        fragment_ctl_btn = (Button) findViewById(R.id.fragment_ctl_btn);



        tel_txt = (EditText) findViewById(R.id.tel_txt);

        // 发送数字的按钮
        // 匿名类的方式
        send_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                tel_txt.setText("已发送号码给Mary！");
                Intent intent=new Intent();
                String content = tel_txt.getText().toString();  // 获取EditText的值
                intent.putExtra("extra", content);
                intent.setClass(FirstActivity.this, SecondActivity.class); // 跳转页面
                startActivity(intent);
            }
        });

        // 查看widget的按钮
        widget_demo_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(FirstActivity.this, WidgetDemoActivity.class);
                startActivity(intent);
            }
        });

        widget_demo_btn2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(FirstActivity.this, WidgetDemoActivity2.class);
                startActivity(intent);
            }
        });

        linear_layout_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(FirstActivity.this, LinearLayoutDemoActivity.class);
                startActivity(intent);
            }
        });

        relative_layout_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(FirstActivity.this, RelativeLayoutDemoActivity.class);
                startActivity(intent);
            }
        });

        frame_layout_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(FirstActivity.this, FrameLayoutDemoActivity.class);
                startActivity(intent);
            }
        });

        table_layout_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(FirstActivity.this, TableLayoutDemoActivity.class);
                startActivity(intent);
            }
        });

        list_view_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(FirstActivity.this, ListViewDemoActivity.class);
                startActivity(intent);
            }
        });

        myself_title_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(FirstActivity.this, MyselfTitleDemoActivity.class);
                startActivity(intent);
            }
        });

        msg_ctl_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(FirstActivity.this, MsgActivity.class);
                startActivity(intent);
            }
        });

        fragment_ctl_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(FirstActivity.this, FragmentDemoActivity.class);
                startActivity(intent);
            }
        });

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


}
