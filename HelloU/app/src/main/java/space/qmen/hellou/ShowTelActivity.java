package space.qmen.hellou;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Luo_0412 on 2016/12/3.
 * 参考： http://blog.csdn.net/u010800530/article/details/39455347
 * http://blog.csdn.net/angcyo/article/details/52177832
 */

public class ShowTelActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText show_tel_name;
    private EditText show_tel_number;
    private EditText show_tel_email;
    private EditText show_tel_address;
    private Button back_btn;
    private Button save_btn;
    private Button edit_btn;
    private Button call_btn;
    private Button message_btn;


    private long get_id = 0;
    private String get_name = "";
    private String get_number = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_show_tel);

        show_tel_name = (EditText) findViewById(R.id.show_tel_name);
        show_tel_number = (EditText) findViewById(R.id.show_tel_number);
        show_tel_email = (EditText) findViewById(R.id.show_tel_email);
        show_tel_address = (EditText) findViewById(R.id.show_tel_address);
        back_btn = (Button) findViewById(R.id.back_btn);
        back_btn.setOnClickListener(this);
        save_btn = (Button) findViewById(R.id.save_btn);
        save_btn.setOnClickListener(this);
        call_btn = (Button) findViewById(R.id.call_btn);
        call_btn.setOnClickListener(this);
        edit_btn = (Button) findViewById(R.id.edit_btn);
        edit_btn.setOnClickListener(this);
        message_btn = (Button) findViewById(R.id.message_btn);
        message_btn.setOnClickListener(this);

        get_number = getIntent().getStringExtra("contacts_number");
        show_tel_number.setText(get_number);

        // 根据号码找姓名
        Uri uri = Uri.parse("content://com.android.contacts/data/phones/filter/" + get_number);
        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(uri,
                new String[]{ android.provider.ContactsContract.Data.DISPLAY_NAME,
                        android.provider.ContactsContract.CommonDataKinds.Email.DATA },
                null, null, null);
        if(cursor.moveToFirst()){
            get_name = cursor.getString(0);
            show_tel_name.setText(get_name);
        }
        cursor.close();

        // 根据姓名找id
        cursor = resolver.query(uri, new String[]{ContactsContract.CommonDataKinds.Phone.CONTACT_ID},"display_name=?", new String[]{get_name}, null);
        if(cursor.moveToFirst()){
            get_id = cursor.getInt(0);
            Toast.makeText(this, get_id + "", Toast.LENGTH_SHORT).show();
        }

    }

    public void updateContacts(long id, String phone) throws Exception {


    }

    public void update(String rawRawContactId, String NewNumber) {
        ContentValues values = new ContentValues();
        values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, NewNumber);
        values.put(ContactsContract.CommonDataKinds.Phone.TYPE,
                ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE);

        String Where = ContactsContract.Data.RAW_CONTACT_ID + " = ? AND " +
                ContactsContract.Data.MIMETYPE + " = ?";
        String[] WhereParams = new String[]{rawRawContactId,
                ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE, };

        getContentResolver().update(ContactsContract.Data.CONTENT_URI, values, Where, WhereParams);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.edit_btn:
                show_tel_name.setEnabled(true);
                show_tel_number.setEnabled(true);
                show_tel_email.setEnabled(true);
                show_tel_address.setEnabled(true);
                save_btn.setVisibility(View.VISIBLE);
                edit_btn.setVisibility(View.GONE);
                break;
            case R.id.save_btn:
                show_tel_name.setEnabled(false);
                show_tel_number.setEnabled(false);
                show_tel_email.setEnabled(false);
                show_tel_address.setEnabled(false);

                try {

                    // 如果名字相同就不删除
                    if( !show_tel_name.getText().equals(get_name) ) {
                        deleteContacts(get_name);
                    }


                    Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
                    ContentResolver resolver = this.getContentResolver();
                    ContentValues values = new ContentValues();
                    long contact_id = ContentUris.parseId(resolver.insert(uri, values));

                    //插入data表
                    uri = Uri.parse("content://com.android.contacts/data");

                    //add Name
                    values.put("raw_contact_id", contact_id);
                    values.put(ContactsContract.Contacts.Data.MIMETYPE,"vnd.android.cursor.item/name");
                    values.put("data2", show_tel_name.getText().toString());
                    values.put("data1", show_tel_name.getText().toString());
                    resolver.insert(uri, values);
                    values.clear();

                    //add Phone
                    values.put("raw_contact_id", contact_id);
                    values.put(ContactsContract.Contacts.Data.MIMETYPE,"vnd.android.cursor.item/phone_v2");
                    values.put("data2", show_tel_number.getText().toString());   // 手机
                    values.put("data1", show_tel_number.getText().toString());
                    resolver.insert(uri, values);
                    values.clear();

                } catch (Exception e) {

                }

                save_btn.setVisibility(View.GONE);
                edit_btn.setVisibility(View.VISIBLE);
                Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.call_btn:
                String mobile = show_tel_number.getText().toString();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                //需要拨打的号码
                intent.setData(Uri.parse("tel:" + mobile));
                startActivity(intent);
                break;
            case R.id.message_btn:
                String mobile2 = show_tel_number.getText().toString();
                Intent intent2 = new Intent();
                intent2.setAction(Intent.ACTION_SENDTO);
                intent2.setData(Uri.parse("smsto:" + mobile2));
                intent2.putExtra("sms_body", "发短信测试，请忽略，打扰了哈！！");
                startActivity(intent2);
                break;
            case R.id.back_btn:
                onBackPressed();
                break;
            default:
                break;
        }
    }

    public void deleteContacts(String name) throws Exception {
        Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
        ContentResolver resolver = this.getContentResolver();
        Cursor cursor = resolver.query(uri, new String[]{ContactsContract.Contacts.Data._ID},"display_name=?", new String[]{name}, null);
        if(cursor.moveToFirst()){
            int id = cursor.getInt(0);
            //根据id删除data中的相应数据
            resolver.delete(uri, "display_name=?", new String[]{name});
            uri = Uri.parse("content://com.android.contacts/data");
            resolver.delete(uri, "raw_contact_id=?", new String[]{id+""});
        }
    }


}


