package space.qmen.hellou;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button login_btn, register_btn, forget_userpwd_btn;
    private ImageView isMemorized_btn, isSelfLogin_btn;
    private EditText username, userpwd;
    private Button username_clear_btn, userpwd_eye, userpwd_clear_btn;
    private TextWatcher username_watcher, userpwd_watcher;
    private Boolean isEyeOpen = false;

    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private Cursor cursor;

    private SharedPreferences pref;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        initBtn();
        initWatcher();

        login_btn = (Button) findViewById(R.id.login_btn);
        login_btn.setOnClickListener(this);

        register_btn = (Button) findViewById(R.id.register_btn);
        register_btn.setOnClickListener(this);

        forget_userpwd_btn = (Button) findViewById(R.id.forget_userpwd_btn);
        forget_userpwd_btn.setOnClickListener(this);

        username_clear_btn = (Button) findViewById(R.id.username_clear_btn);
        username_clear_btn.setOnClickListener(this);

        userpwd_clear_btn = (Button) findViewById(R.id.userpwd_clear_btn);
        userpwd_clear_btn.setOnClickListener(this);

        userpwd_eye = (Button) findViewById(R.id.userpwd_eye);
        userpwd_eye.setOnClickListener(this);

        userpwd_clear_btn = (Button) findViewById(R.id.userpwd_clear_btn);
        userpwd_clear_btn.setOnClickListener(this);

        isSelfLogin_btn = (ImageView) findViewById(R.id.isSelfLogin);
        isSelfLogin_btn.setOnClickListener(this);
        isMemorized_btn = (ImageView) findViewById(R.id.isMemorized);
        isMemorized_btn.setOnClickListener(this);

        username = (EditText) findViewById(R.id.username);
        userpwd = (EditText) findViewById(R.id.userpwd);
        username.addTextChangedListener(username_watcher);
        userpwd.addTextChangedListener(userpwd_watcher);

//        userpwd.setText("hello");

        pref = getSharedPreferences("loginValue", MODE_WORLD_WRITEABLE);
        if( pref != null) {
            // 如果记住密码
            if(pref.getBoolean("isMemorized", false) == true) {
                username.setText(pref.getString("userName", null));
                userpwd.setText(pref.getString("userPwd", null));
                isMemorized_btn.setBackgroundResource(R.mipmap.remember_pwd);
            }

            if(pref.getBoolean("isSelfLogin", false) == true) {
                username.setText(pref.getString("userName", null));
                userpwd.setText(pref.getString("userPwd", null));
                isSelfLogin_btn.setBackgroundResource(R.mipmap.login_user_fixed);

                creatDialog();
                new Thread() {
                    public void run() {
                        try {
                            Thread.sleep(500);

                            if(mDialog.isShowing()){
                                mDialog.dismiss();
                            }

                            // 存在bug,
                            // 当按返回键的时候时候怎么跳出...
                            if(pref.getString("userPwd", null) != null) {
                                Intent intent = new Intent();
                                CurrentUserNo.setA(username.getText().toString());
                                intent.setClass(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                            }

                        } catch (Exception e) {

                        }
                    }
                }.start();
            }
        }

        dbHelper = new DatabaseHelper(this, "StuManageSys.db", null, 2);

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

                            if(pref.getBoolean("isMemorized", false) == true) {

                                pref.edit()
                                        .putString("userName", username.getText().toString())
                                        .putString("userPwd", userpwd.getText().toString())
                                        .commit();
                            }

                            CurrentUserNo.setA(username.getText().toString());
                            Intent intent = new Intent();
                            intent.setClass(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }
                    cursor.close();
                }
                break;
            case R.id.isMemorized:

                if(pref.getBoolean("isMemorized", false) == true) {
                    pref.edit()
                            .putBoolean("isSelfLogin", false)
                            .putBoolean("isMemorized", false)
                            .putString("userName", null)
                            .putString("userPwd", null)
                            .commit();
                    isMemorized_btn.setBackgroundResource(R.mipmap.forget_pwd);
                    isSelfLogin_btn.setBackgroundResource(R.mipmap.login_user);
                }

                else {
                    pref.edit()
                            .putBoolean("isMemorized", true)
//                            .putString("userName", username.getText().toString())
//                            .putString("userPwd", userpwd.getText().toString())
                            .commit();
                    isMemorized_btn.setBackgroundResource(R.mipmap.remember_pwd);
                }
                break;
            case R.id.isSelfLogin:
                if(pref.getBoolean("isSelfLogin", false) == true) {
                    pref.edit()
                            .putBoolean("isSelfLogin", false)
                            .commit();
                    isSelfLogin_btn.setBackgroundResource(R.mipmap.login_user);
                }

                else {
                    pref.edit()
                            .putBoolean("isSelfLogin", true)
//                            .putString("userName", username.getText().toString())
//                            .putString("userPwd", userpwd.getText().toString())
                            .commit();
                    isSelfLogin_btn.setBackgroundResource(R.mipmap.login_user_fixed);
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

    }

    private void creatDialog() {
        mDialog = new ProgressDialog(this);
        mDialog.setTitle("验证中");
        mDialog.setMessage("正在登陆请稍后");
        mDialog.setIndeterminate(true);
        mDialog.setCancelable(true);
        mDialog.show();
    }

}
