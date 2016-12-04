package space.qmen.hellou;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * listview里的按钮的监听事件 http://www.2cto.com/kf/201403/286545.html
*/

//public class SearchStuFragment extends Fragment implements AdapterView.OnItemClickListener {
//    private EditText user_no_search_edit;
//    private ListView listView_edit;
//    private ReusableAdapter<EditItem> reusableAdapter = null;
//    private List<EditItem> mData = null;
//    private Button user_search_btn;
//    private DatabaseHelper dbHelper;
//    private Cursor cursor;
//    private SQLiteDatabase db;
//
//    public SearchStuFragment() {
//
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fg_search_stu, container,false);
//        listView_edit = (ListView) view.findViewById(R.id.listview_edit);
//
//        user_no_search_edit = (EditText) view.findViewById(R.id.user_no_search_edit);
//
//        dbHelper = new DatabaseHelper(SearchStuFragment.this.getActivity(), "StuManageSys.db", null, 2);
//        dbHelper.getWritableDatabase();
//        db = dbHelper.getWritableDatabase();
//        mData = new ArrayList<EditItem>();
//        reusableAdapter = new ReusableAdapter<EditItem>((ArrayList)mData,R.layout.layout_edit_item) {
//            @Override
//            public void bindView(ViewHolder holder, EditItem obj) {
//                holder.setText(R.id.txt_user_no,obj.getUserNo());
//                holder.setText(R.id.txt_user_name,obj.getUserName());
//            }
//        };
//
//
//        // 默认查找所有的
//        cursor = db.query("User", null, null, null, null, null,
//                null, null);
//        if (cursor.moveToFirst()) {
//            do {
//                String userNo = cursor.getString(cursor
//                        .getColumnIndex("user_no"));
//                String userName = cursor.getString(cursor
//                        .getColumnIndex("user_name"));
//
//                mData.add(new EditItem(userNo, userName));
//
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//
//        listView_edit.setAdapter(reusableAdapter);
//        listView_edit.setOnItemClickListener(this);
//
//        user_search_btn = (Button) view.findViewById(R.id.user_search_btn);
//        user_search_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dbHelper.getWritableDatabase();
//                db = dbHelper.getWritableDatabase();
//                mData.clear();
////                cursor = db.query("User", null, null, null, null, null,
////                            null, null);
//                cursor = db.rawQuery("select * from User where user_no like ?",
//                        new String[]{ user_no_search_edit.getText().toString() + "%"  });
//                if (cursor.moveToFirst()) {
//                    do {
//                        String userNo = cursor.getString(cursor
//                                    .getColumnIndex("user_no"));
//                        String userName = cursor.getString(cursor
//                                .getColumnIndex("user_name"));
//
//                        mData.add(new EditItem(userNo, userName));
//
//                    } while (cursor.moveToNext());
//                }
//                cursor.close();
//                listView_edit.setAdapter(reusableAdapter); // 不要忽略这一步
//            }
//        });
//
//
//        return view;
//    }
//
//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(SearchStuFragment.this.getActivity()
//                        , "你点击了第" + position + "项"
//                        , Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent();
//        intent.setClass(SearchStuFragment.this.getActivity(), EditStuActivity.class);
//        startActivity(intent);
//    }
//
//}


public class SearchStuFragment extends Fragment implements ListItemClickHelp {
    private EditText user_no_search_edit;
    private ListView listview_edit;
    private ListItemClickAdapter mAdapter;
    private ArrayList<EditItem> mData = new ArrayList<EditItem>();
    private Button user_search_btn;
    private DatabaseHelper dbHelper;
    private Cursor cursor;
    private SQLiteDatabase db;

    public SearchStuFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_search_stu, container,false);
        listview_edit = (ListView) view.findViewById(R.id.listview_edit);

        user_no_search_edit = (EditText) view.findViewById(R.id.user_no_search_edit);

        dbHelper = new DatabaseHelper(SearchStuFragment.this.getActivity(), "StuManageSys.db", null, 2);
        dbHelper.getWritableDatabase();
        db = dbHelper.getWritableDatabase();

        mAdapter = new ListItemClickAdapter(this.getActivity(), mData, this);



        // 默认查找所有的
//        cursor = db.query("User", null, null, null, null, null,
//                null, null);
//        if (cursor.moveToFirst()) {
//            do {
//                String userNo = cursor.getString(cursor
//                        .getColumnIndex("user_no"));
//                String userName = cursor.getString(cursor
//                        .getColumnIndex("user_name"));
//
//                mData.add(new EditItem(userNo, userName));
//
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//
//
//
//        listview_edit.setAdapter(mAdapter);

        listview_edit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view,
                                    int position, long id) {

//                Toast.makeText(SearchStuFragment.this.getActivity()
//                        , mData.get(position).getUserNo()
//                        , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.putExtra("user_no", mData.get(position).getUserNo());
                intent.setClass(SearchStuFragment.this.getActivity(), ShowStuActivity.class);
                startActivity(intent);
            }
        });

        user_search_btn = (Button) view.findViewById(R.id.user_search_btn);
        user_search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
                db = dbHelper.getWritableDatabase();
                mData.clear();
                cursor = db.rawQuery("select * from User where user_no like ?",
                        new String[]{ user_no_search_edit.getText().toString() + "%"  });
                if (cursor.moveToFirst()) {
                    do {
                        String userNo = cursor.getString(cursor
                                .getColumnIndex("user_no"));
                        String userName = cursor.getString(cursor
                                .getColumnIndex("user_name"));

                        mData.add(new EditItem(userNo, userName));

                    } while (cursor.moveToNext());
                }
                cursor.close();

                listview_edit.setAdapter(mAdapter);
            }
        });

        user_search_btn.performClick();


        return view;
    }


    @Override
    public void onClick(View item, View widget, int position, int which) {
        switch (which) {
            case R.id.edit_user_btn:
//                Toast.makeText(SearchStuFragment.this.getActivity()
//                        , mData.get(position).getUserNo() + "\n" + CurrentUserNo.getA()
//                        , Toast.LENGTH_SHORT).show();
                // 自己还是可以修改自己的信息的
                if(mData.get(position).getUserNo().equals(CurrentUserNo.getA()) ) {
                    Intent intent = new Intent();
                    intent.putExtra("user_no", mData.get(position).getUserNo());
                    intent.setClass(SearchStuFragment.this.getActivity(), EditStuActivity.class);
                    startActivity(intent);
                }

                else if(CurrentUserNo.getB() == 0) {
                    Toast.makeText(SearchStuFragment.this.getActivity()
                            , "权限不足,无法操作"
                            , Toast.LENGTH_SHORT).show();
                }

                else {
                    Intent intent = new Intent();
                    intent.putExtra("user_no", mData.get(position).getUserNo());
                    intent.setClass(SearchStuFragment.this.getActivity(), EditStuActivity.class);
                    startActivity(intent);
                }

                break;

            case R.id.delete_user_btn:
                if(CurrentUserNo.getB() != 2) {
                    Toast.makeText(SearchStuFragment.this.getActivity()
                            , "权限不足,无法操作"
                            , Toast.LENGTH_SHORT).show();
                }

//                if else { 超级管理员无法删除, 先不做 }

                else {
                    AlertDialog.Builder dialog = new AlertDialog.Builder
                            (SearchStuFragment.this.getActivity());
                    final String user_no = mData.get(position).getUserNo();
                    final String user_name = mData.get(position).getUserName();
                    dialog.setTitle("删除用户确认");
                    dialog.setMessage("将删除账号为 " + user_no + " ,姓名为 " + user_name + "的用户");
                    dialog.setCancelable(false);
                    dialog.setPositiveButton("确认删除", new DialogInterface.
                            OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            db = dbHelper.getWritableDatabase();
                            db.delete("User", "user_no = ?", new String[]{user_no});
                            Toast.makeText(SearchStuFragment.this.getActivity(), "删除成功", Toast.LENGTH_SHORT).show();
                            user_search_btn.performClick();
                        }
                    });
                    dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(SearchStuFragment.this.getActivity(), "取消删除", Toast.LENGTH_SHORT).show();
                        }
                    });
                    dialog.show();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first
        user_search_btn.performClick();

    }

}

