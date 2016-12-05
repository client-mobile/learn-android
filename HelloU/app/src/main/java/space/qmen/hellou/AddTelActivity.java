package space.qmen.hellou;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Luo_0412 on 2016/12/4.
 */

public class AddTelActivity extends AppCompatActivity {

    private EditText tel_name, tel_number, tel_email, tel_address;
    private Button save_btn, back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_add_tel);

        tel_name = (EditText) findViewById(R.id.tel_name);
        tel_number = (EditText) findViewById(R.id.tel_number);
        tel_email = (EditText) findViewById(R.id.tel_email);
        tel_address = (EditText) findViewById(R.id.tel_address);

        save_btn = (Button) findViewById(R.id.save_btn);
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(tel_number.getText().toString().equals("")
                        || tel_name.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "新增失败,手机号或姓名不能为空", Toast.LENGTH_SHORT).show();
                }
                else {
                    addContacts(tel_name.getText().toString(), tel_number.getText().toString()); // 需要一些时间，先说成功
                    Toast.makeText(AddTelActivity.this, "新增成功", Toast.LENGTH_SHORT).show();
                    tel_name.setText("");
                    tel_number.setText("");
                    tel_email.setText("");
                    tel_address.setText("");
                }

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

    // 新增联系人
    public void addContacts(String name, String phone) {

        //插入raw_contacts表，并获取_id属性
        Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
        ContentResolver resolver = this.getContentResolver();
        ContentValues values = new ContentValues();
        long contact_id = ContentUris.parseId(resolver.insert(uri, values));

        //插入data表
        uri = Uri.parse("content://com.android.contacts/data");

        //add Name
        values.put("raw_contact_id", contact_id);
        values.put(ContactsContract.Contacts.Data.MIMETYPE,"vnd.android.cursor.item/name");
        values.put("data2", name);
        values.put("data1", name);
        resolver.insert(uri, values);
        values.clear();

        //add Phone
        values.put("raw_contact_id", contact_id);
        values.put(ContactsContract.Contacts.Data.MIMETYPE,"vnd.android.cursor.item/phone_v2");
        values.put("data2", phone);   // 手机
        values.put("data1", phone);
        resolver.insert(uri, values);
        values.clear();

        //add email
//        values.put("raw_contact_id", contact_id);
//        values.put(ContactsContract.Contacts.Data.MIMETYPE,"vnd.android.cursor.item/email_v2");
//        values.put("data2", "2"); // 单位
//        values.put("data1", "xzdong@xzdong.com"); // 邮箱
//        resolver.insert(uri, values);
    }
}
