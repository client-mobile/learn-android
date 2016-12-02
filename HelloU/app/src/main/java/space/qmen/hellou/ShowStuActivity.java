package space.qmen.hellou;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Luo_0412 on 2016/12/1.
 */

public class ShowStuActivity extends AppCompatActivity {
    private DatabaseHelper dbHelper;
    private Cursor cursor;
    private SQLiteDatabase db;
    private TextView show_user_no;
    private TextView show_user_type;
    private TextView show_user_name;
    private TextView show_user_gender;
    private TextView show_user_tel;
    private TextView show_user_address;
    private Button back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_show_stu);

        show_user_no = (TextView) findViewById(R.id.show_user_no);
        show_user_type = (TextView) findViewById(R.id.show_user_type);
        show_user_name = (TextView) findViewById(R.id.show_user_name);
        show_user_gender = (TextView) findViewById(R.id.show_user_gender);
        show_user_tel = (TextView) findViewById(R.id.show_user_tel);
        show_user_address = (TextView) findViewById(R.id.show_user_address);

        String userNo = getIntent().getStringExtra("user_no");
//        Toast.makeText(this, userNo, Toast.LENGTH_SHORT).show();

        dbHelper = new DatabaseHelper(this, "StuManageSys.db", null, 2);
        dbHelper.getWritableDatabase();
        db = dbHelper.getWritableDatabase();
        cursor = db.rawQuery("select * from User where user_no like ?",
                new String[]{  userNo  });
        String userName = "", userTel = "", userAddress = "";
        int userType = 0, userGender = 1;
        if(cursor.moveToFirst()) {
            userType = cursor.getInt(cursor
                        .getColumnIndex("user_type"));
            userName = cursor.getString(cursor
                    .getColumnIndex("user_name"));
            userGender = cursor.getInt(cursor
                .getColumnIndex("user_gender"));
            userTel = cursor.getString(cursor
                .getColumnIndex("user_tel"));
            userAddress = cursor.getString(cursor
                .getColumnIndex("user_address"));
        }
        cursor.close();

//        Toast.makeText(this, userName, Toast.LENGTH_SHORT).show();

        if(userType == 0) {
            show_user_type.setText("学生");
        } else if(userType == 1) {
            show_user_type.setText("管理员");
        } else {
            show_user_type.setText("超级管理员");
        }

        if(userGender == 1) {
            show_user_gender.setText("男");
        } else {
            show_user_gender.setText("女");
        }

        show_user_name.setText(userName);
        show_user_no.setText(userNo);
        show_user_tel.setText(userTel);
        show_user_address.setText(userAddress);

        back_btn = (Button) findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }


}