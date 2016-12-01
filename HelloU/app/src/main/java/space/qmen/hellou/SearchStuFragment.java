package space.qmen.hellou;

import android.app.Fragment;
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

public class SearchStuFragment extends Fragment implements AdapterView.OnItemClickListener {
    private EditText user_no_search_edit;
    private ListView listView_edit;
    private ReusableAdapter<EditItem> reusableAdapter = null;
    private List<EditItem> mData = null;
    private Button user_search_btn;
    private DatabaseHelper dbHelper;
    private Cursor cursor;
    private SQLiteDatabase db;

    public SearchStuFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_search_stu, container,false);
        listView_edit = (ListView) view.findViewById(R.id.listview_edit);

        user_no_search_edit = (EditText) view.findViewById(R.id.user_no_search_edit);

        dbHelper = new DatabaseHelper(SearchStuFragment.this.getActivity(), "StuManageSys.db", null, 2);
        dbHelper.getWritableDatabase();
        db = dbHelper.getWritableDatabase();
        mData = new ArrayList<EditItem>();
        reusableAdapter = new ReusableAdapter<EditItem>((ArrayList)mData,R.layout.layout_edit_item) {
            @Override
            public void bindView(ViewHolder holder, EditItem obj) {
                holder.setText(R.id.txt_user_no,obj.getUserNo());
                holder.setText(R.id.txt_user_name,obj.getUserName());
            }
        };


        // 默认查找所有的
        cursor = db.query("User", null, null, null, null, null,
                null, null);
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

        listView_edit.setAdapter(reusableAdapter);
        listView_edit.setOnItemClickListener(this);

        user_search_btn = (Button) view.findViewById(R.id.user_search_btn);
        user_search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
                db = dbHelper.getWritableDatabase();
                mData.clear();
//                cursor = db.query("User", null, null, null, null, null,
//                            null, null);
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
                listView_edit.setAdapter(reusableAdapter); // 不要忽略这一步
            }
        });


        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(SearchStuFragment.this.getActivity()
                        , "你点击了第" + position + "项"
                        , Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setClass(SearchStuFragment.this.getActivity(), EditStuActivity.class);
        startActivity(intent);
    }

}



