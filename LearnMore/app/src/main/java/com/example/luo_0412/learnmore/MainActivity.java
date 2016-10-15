package com.example.luo_0412.learnmore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

    private Button bct1_btn;
    private Button bct2_btn;
    private Button file_persistence_btn;
    private Button shared_preferences_btn;
    private Button sqlite_btn;
    private Button contacts_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bct1_btn = (Button) findViewById(R.id.bct1_btn);
        bct1_btn.setOnClickListener(this);
        bct2_btn = (Button) findViewById(R.id.bct2_btn);
        bct2_btn.setOnClickListener(this);
        file_persistence_btn = (Button)findViewById(R.id.file_persistence_btn);
        file_persistence_btn.setOnClickListener(this);
        shared_preferences_btn = (Button)findViewById(R.id.share_preferences_btn);
        shared_preferences_btn.setOnClickListener(this);
        sqlite_btn = (Button)findViewById(R.id.sqlite_btn);
        sqlite_btn.setOnClickListener(this);
        contacts_btn = (Button)findViewById(R.id.contacts_btn);
        contacts_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bct1_btn:
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, BroadcastTest1Activity.class);
                startActivity(intent);
                break;
            case R.id.bct2_btn:
                Intent intent2 = new Intent();
                intent2.setClass(MainActivity.this, LoginActivity.class);
                startActivity(intent2);
                break;
            case R.id.file_persistence_btn:
                Intent intent3 = new Intent();
                intent3.setClass(MainActivity.this, FilePersistenceActivity.class);
                startActivity(intent3);
                break;
            case R.id.share_preferences_btn:
                Intent intent4 = new Intent();
                intent4.setClass(MainActivity.this, SharedPreferencesActivity.class);
                startActivity(intent4);
                break;
            case R.id.sqlite_btn:
                Intent intent5 = new Intent();
                intent5.setClass(MainActivity.this, SQLiteActivity.class);
                startActivity(intent5);
                break;
            case R.id.contacts_btn:
                Intent intent6 = new Intent();
                intent6.setClass(MainActivity.this, ContactsTestActivity.class);
                startActivity(intent6);
                break;
            default:
                break;
        }
    }
}
