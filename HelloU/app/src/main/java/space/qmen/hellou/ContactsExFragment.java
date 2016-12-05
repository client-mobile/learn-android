package space.qmen.hellou;

import android.app.Fragment;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import com.github.clans.fab.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import java.util.ArrayList;

// 侧滑效果参考 https://gold.xitu.io/entry/57bfedc9efa631005aa6b842
// 联系人增删改查 http://www.cnblogs.com/jingmo0319/p/5600057.html

public class ContactsExFragment extends Fragment {

    ItemRemoveRecyclerView recyclerView;
    ArrayList<String> mList ;  // 用于显示
    ArrayList<String> mList1 ;  // 存名字
    ArrayList<String> mList2 ;  // 存号码

    RecyclerItemClickAdapter adapter;
    Cursor cursor = null;

    //    private String content;
    public ContactsExFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_contacts_ex, container,false);

        recyclerView = (ItemRemoveRecyclerView) view.findViewById(R.id.id_item_remove_recyclerview);

        // 悬浮按钮
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), AddTelActivity.class);
                startActivity(intent);
            }
        });

        // 存储数据的三个list
        initRecyclerView();

        recyclerView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                Toast.makeText(view.getContext(), "** " + mList2.get(position) + " **", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.putExtra("contacts_number", mList2.get(position));
                intent.setClass(getActivity(), ShowTelActivity.class);
                startActivity(intent);
            }

            @Override
            public void onDeleteClick(int position) {
                try {
                    deleteContacts(mList1.get(position));
                }
                catch(Exception e) {
                    e.printStackTrace();
                }

                Toast.makeText(getActivity(), mList1.get(position) + "删除成功", Toast.LENGTH_SHORT).show();

//                adapter.removeItem(position);
                initRecyclerView();
            }

        });

        return view;
    }

    // 删除联系人
    public void deleteContacts(String name) throws Exception {
        Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
        ContentResolver resolver = this.getActivity().getContentResolver();
        Cursor cursor = resolver.query(uri, new String[]{ContactsContract.Contacts.Data._ID},"display_name=?", new String[]{name}, null);
        if(cursor.moveToFirst()){
            int id = cursor.getInt(0);
            //根据id删除data中的相应数据
            resolver.delete(uri, "display_name=?", new String[]{name});
            uri = Uri.parse("content://com.android.contacts/data");
            resolver.delete(uri, "raw_contact_id=?", new String[]{id+""});
        }
    }

    // 更新联系人
    public void updateContacts(int id, String phone) throws Exception {
        Uri uri = Uri.parse("content://com.android.contacts/data"); //对data表的所有数据操作
        ContentResolver resolver = this.getActivity().getContentResolver();
        ContentValues values = new ContentValues();
        values.put("data1", phone);
        resolver.update(uri, values, "mimetype=? and raw_contact_id=?", new String[]{"vnd.android.cursor.item/phone_v2",id+""});
    }


    //根据电话号码查询姓名（在一个电话打过来时，如果此电话在通讯录中，则显示姓名）
    public void testReadNameByPhone(){
        String phone = "12345678";
        //uri=  content://com.android.contacts/data/phones/filter/#
        Uri uri = Uri.parse("content://com.android.contacts/data/phones/filter/"+phone);
        ContentResolver resolver = this.getActivity().getContentResolver();
        Cursor cursor = resolver.query(uri, new String[]{ ContactsContract.Data.DISPLAY_NAME}, null, null, null); //从raw_contact表中返回display_name
        if(cursor.moveToFirst()){
//            Log.i("Contacts", "name="+cursor.getString(0));
        }
    }

//    public void readAllContacts() {
//        try {
//            cursor = getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
//                    null, null, null, null);
//            while (cursor.moveToNext()) {
//
//                String displayName = cursor.getString(cursor
//                        .getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
//                String number = cursor.getString(cursor
//                        .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//                int contactsId = cursor.getInt(cursor
//                        .getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID));
//
//                mList1.add(displayName);
//                mList2.add(number);
//                mList.add(displayName + " " + number);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (cursor != null) {
//                cursor.close();
//            }
//        }
//
//        adapter = new RecyclerItemClickAdapter(getActivity(), mList);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
//        recyclerView.setAdapter(adapter);
//    }


    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first
//        readAllContacts();

        initRecyclerView();
    }

    public void initRecyclerView() {
        mList = new ArrayList<>();
        mList1 = new ArrayList<>();
        mList2 = new ArrayList<>();
        try {
            cursor = getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null, null, null, null);
            while (cursor.moveToNext()) {

                String displayName = cursor.getString(cursor
                        .getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number = cursor.getString(cursor
                        .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                int contactsId = cursor.getInt(cursor
                        .getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID));

                mList1.add(displayName);
                mList2.add(number);
                mList.add(displayName + " " + number);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        adapter = new RecyclerItemClickAdapter(getActivity(), mList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setAdapter(adapter);
    }

}