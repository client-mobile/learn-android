package space.qmen.hellou;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Luo_0412 on 2016/12/1.
 */

public class EditStuActivity extends AppCompatActivity {
    private EditText user_no_edit;
    private EditText user_name_edit;
    private EditText user_pwd_edit;
    private EditText user_tel_edit;
    private EditText user_address_edit;
    private String userNo = "";
    private Button update_user_btn;
    private Button back_btn;
    private Spinner spinner_user_type;
    private RadioGroup genderRadioGroup;
    private RadioButton btnMan;
    private RadioButton btnWoman;
    private int checkedGender = 1;

    private DatabaseHelper dbHelper;
    private Cursor cursor;
    private SQLiteDatabase db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_edit_stu);

        userNo = getIntent().getStringExtra("user_no");

        dbHelper = new DatabaseHelper(this, "StuManageSys.db", null, 2);
        dbHelper.getWritableDatabase();
        db = dbHelper.getWritableDatabase();

        user_no_edit = (EditText) findViewById(R.id.user_no_edit);
        user_name_edit = (EditText) findViewById(R.id.user_name_edit);
        user_pwd_edit = (EditText) findViewById(R.id.user_pwd_edit);
        user_tel_edit = (EditText) findViewById(R.id.user_tel_edit);
        user_address_edit = (EditText) findViewById(R.id.user_address_edit);
        spinner_user_type = (Spinner) findViewById(R.id.spinner_user_type);
        genderRadioGroup = (RadioGroup) findViewById(R.id.genderRadioGroup);
        btnMan = (RadioButton) findViewById(R.id.btnMan);
        btnMan = (RadioButton) findViewById(R.id.btnWoman);

        genderRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.btnMan:
                        checkedGender = 1;
                        break;
                    case R.id.btnWoman:
                        checkedGender = 0;
                        break;
                }
//                Toast.makeText(AddStuFragment.this.getActivity(),
//                        checkedGender + "", Toast.LENGTH_SHORT).show();

            }
        });

        cursor = db.rawQuery("select * from User where user_no = ?",
                new String[]{  userNo  });
        String userName = "", userTel = "", userAddress = "", userPwd = "";
        int userType = 0, userGender = 1;
        if(cursor.moveToFirst()) {
            userType = cursor.getInt(cursor
                    .getColumnIndex("user_type"));
            userName = cursor.getString(cursor
                    .getColumnIndex("user_name"));
            userGender = cursor.getInt(cursor
                    .getColumnIndex("user_gender"));
            userPwd = cursor.getString(cursor
                    .getColumnIndex("user_pwd"));
            userTel = cursor.getString(cursor
                    .getColumnIndex("user_tel"));
            userAddress = cursor.getString(cursor
                    .getColumnIndex("user_address"));
        }
        cursor.close();

        user_no_edit.setText(userNo);
        user_no_edit.setEnabled(false);
        user_no_edit.setFocusable(false);

        user_name_edit.setText(userName);
        user_tel_edit.setText(userTel);
        user_address_edit.setText(userAddress);
        user_pwd_edit.setText(userPwd);

        spinner_user_type.setSelection(userType, true);
        checkedGender = userGender;
        if(checkedGender == 1) {
            genderRadioGroup.check(R.id.btnMan);
        } else {
            genderRadioGroup.check(R.id.btnWoman);
        }




//        Toast.makeText(this, userName, Toast.LENGTH_SHORT).show();

//        if(userType == 0) {
//            user_type.setText("学生");
//        } else if(userType == 1) {
//            show_user_type.setText("管理员");
//        } else {
//            show_user_type.setText("超级管理员");
//        }

//        if(userGender == 1) {
//            user_gender.setText("男");
//        } else {
//            show_user_gender.setText("女");
//        }


        update_user_btn = (Button) findViewById(R.id.update_user_btn);
        update_user_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("user_name", user_name_edit.getText().toString());
                values.put("user_address", user_address_edit.getText().toString());
                values.put("user_tel", user_tel_edit.getText().toString());
                values.put("user_pwd", user_pwd_edit.getText().toString());
                values.put("user_gender", checkedGender);
                values.put("user_type", spinner_user_type.getSelectedItemId());
                db.update("User", values, "user_no = ?",
                        new String[] { userNo });
                Toast.makeText(getApplicationContext(), "信息更改成功", Toast.LENGTH_SHORT).show();
            }
        });

        back_btn = (Button) findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }



}
