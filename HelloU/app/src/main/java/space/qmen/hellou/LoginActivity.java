package space.qmen.hellou;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button login_btn, register_btn, forget_userpwd_btn;
    private EditText username, userpwd;
    private Button username_clear_btn, userpwd_eye, userpwd_clear_btn;
    private TextWatcher username_watcher, userpwd_watcher;
    private Boolean isEyeOpen = false;

    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        initBtn();
        initWatcher();

        dbHelper = new DatabaseHelper(this, "StuManageSys.db", null, 2);

        username = (EditText) findViewById(R.id.username);
        userpwd = (EditText) findViewById(R.id.userpwd);
        username.addTextChangedListener(username_watcher);
        userpwd.addTextChangedListener(userpwd_watcher);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.username_clear_btn:
                username.setText("");
                break;
            case R.id.userpwd_clear_btn:
                userpwd.setText("");
                break;
            case R.id.userpwd_eye:
                isEyeOpen = !isEyeOpen;
                if(isEyeOpen == true) {
                    userpwd_eye.setBackgroundResource(R.mipmap.eye_open);
                    userpwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    userpwd.setSelection(userpwd.length()); // 游标移到最后
                } else {
                    userpwd_eye.setBackgroundResource(R.mipmap.eye_closed);
                    userpwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    userpwd.setSelection(userpwd.length()); // 游标移到最后
                }
                break;
            case R.id.login_btn:
                if(username.getText().toString().equals("")) {
                    Toast.makeText(this, "账号为空", Toast.LENGTH_SHORT).show();
                    username.requestFocus();
                }
                else if(userpwd.getText().toString().equals("")) {
                    Toast.makeText(this, "密码为空", Toast.LENGTH_SHORT).show();
                    userpwd.requestFocus();
                }
                else {
                    db = dbHelper.getWritableDatabase();
                    cursor = db.rawQuery("select * from User where user_no = ?",
                            new String[]{ username.getText().toString() });

                    if(cursor.getCount() == 0) {
                        Toast.makeText(this, "用户不存在或密码错误", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        String user_pwd = "";

                        if (cursor.moveToFirst()) {
                            user_pwd = cursor.getString(cursor
                                    .getColumnIndex("user_pwd"));
                        }

                        if(!user_pwd.equals(userpwd.getText().toString())) {
                            Toast.makeText(this, "用户不存在或密码错误", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Intent intent = new Intent();
                            intent.setClass(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }
                    cursor.close();


                }


                break;
            default:
                break;
        }
    }

    private void initWatcher() {
        username_watcher = new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            public void beforeTextChanged(CharSequence s, int start, int count,int after) {}
            public void afterTextChanged(Editable s) {
                userpwd.setText("");
                if(s.toString().length() > 0) {
                    username_clear_btn.setVisibility(View.VISIBLE);
                } else {
                    username_clear_btn.setVisibility(View.INVISIBLE);
                }
            }
        };

        userpwd_watcher = new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            public void beforeTextChanged(CharSequence s, int start, int count,int after) {}
            public void afterTextChanged(Editable s) {
                if(s.toString().length()>0){
                    userpwd_clear_btn.setVisibility(View.VISIBLE);
                } else{
                    userpwd_clear_btn.setVisibility(View.INVISIBLE);
                }
            }
        };
    }

    public void initBtn() {
        login_btn = (Button) findViewById(R.id.login_btn);
        login_btn.setOnClickListener(this);
        register_btn = (Button) findViewById(R.id.register_btn);
        register_btn.setOnClickListener(this);
        forget_userpwd_btn = (Button) findViewById(R.id.forget_userpwd_btn);
        forget_userpwd_btn.setOnClickListener(this);
        username_clear_btn = (Button) findViewById(R.id.username_clear_btn);
        username_clear_btn.setOnClickListener(this);
        userpwd_clear_btn = (Button) findViewById(R.id.username_clear_btn);
        userpwd_clear_btn.setOnClickListener(this);
        userpwd_eye = (Button) findViewById(R.id.userpwd_eye);
        userpwd_eye.setOnClickListener(this);
        userpwd_clear_btn = (Button) findViewById(R.id.userpwd_clear_btn);
        userpwd_clear_btn.setOnClickListener(this);
    }



}
