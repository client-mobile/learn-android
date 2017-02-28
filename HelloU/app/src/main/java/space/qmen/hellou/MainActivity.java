package space.qmen.hellou;

/**
 * Created by Luo_0412 on 2016/11/30.
 */

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import space.qmen.hellou.util.CurrentUserNo;
import space.qmen.hellou.util.DatabaseHelper;

/**
 * Created by Coder-pig on 2015/8/28 0028.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //UI Object
    private TextView txt_topbar;
    private TextView tab_add;
    private TextView tab_search;
    private TextView tab_markdown;
    private TextView tab_more;
    private FrameLayout ly_content;


    //Fragment Object
    private AddStuFragment fg1;
    private SearchStuFragment fg2;
    private MarkDownFragment fg3;
    private MoreFragment fg4;
    private ContactsFragment fg5; // 通讯录
    private ContactsExFragment fg6; // 增强版通讯录
    private FragmentManager fManager;

    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this, "StuManageSys.db", null, 2);
        db = dbHelper.getWritableDatabase();
        cursor = db.rawQuery("select * from User where user_no = ?",
                new String[]{ CurrentUserNo.getA() });

        if (cursor.moveToFirst()) {
            CurrentUserNo.setB(cursor.getInt(cursor
                    .getColumnIndex("user_type")));
        }

        fManager = getFragmentManager();
        bindViews();

        tab_add.performClick();   //模拟一次点击，既进去后选择第一项
    }

    //UI组件初始化与事件绑定
    private void bindViews() {
        txt_topbar = (TextView) findViewById(R.id.txt_topbar);
        tab_add = (TextView) findViewById(R.id.tab_add);
        tab_search = (TextView) findViewById(R.id.tab_search);
        tab_markdown = (TextView) findViewById(R.id.tab_markdown);
        tab_more = (TextView) findViewById(R.id.tab_more);
        ly_content = (FrameLayout) findViewById(R.id.ly_content);

        tab_add.setOnClickListener(this);
        tab_search.setOnClickListener(this);
        tab_markdown.setOnClickListener(this);
        tab_more.setOnClickListener(this);


    }

    //重置所有文本的选中状态
    private void setSelected(){
        tab_add.setSelected(false);
        tab_search.setSelected(false);
        tab_markdown.setSelected(false);
        tab_more.setSelected(false);
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg1 != null)fragmentTransaction.hide(fg1);
        if(fg2 != null)fragmentTransaction.hide(fg2);
        if(fg3 != null)fragmentTransaction.hide(fg3);
//        if(fg4 != null)fragmentTransaction.hide(fg4);
//        if(fg5 != null)fragmentTransaction.hide(fg5);
        if(fg6 != null)fragmentTransaction.hide(fg6);
    }


    @Override
    public void onClick(View v) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (v.getId()){
            case R.id.tab_add:
                setSelected();
                tab_add.setSelected(true);
                txt_topbar.setText(CurrentUserNo.getA() + " 正在新增一个学生");
                if(fg1 == null) {
                    fg1 = new AddStuFragment();
                    fTransaction.add(R.id.ly_content, fg1);
                } else {
                    fTransaction.show(fg1);
                }
                break;
            case R.id.tab_search:
                setSelected();
                tab_search.setSelected(true);
                txt_topbar.setText(CurrentUserNo.getA() + " 正在删改查一个学生");
                if(fg2 == null){
                    fg2 = new SearchStuFragment();
                    fTransaction.add(R.id.ly_content,fg2);
                }else{
                    fTransaction.show(fg2);
                }
                break;
            case R.id.tab_markdown:
                setSelected();
                tab_markdown.setSelected(true);
                txt_topbar.setText("markdown编辑器");
                if(fg3 == null) {
                    fg3 = new MarkDownFragment("markdown编辑器");
                    fTransaction.add(R.id.ly_content,fg3);
                } else {
                    fTransaction.show(fg3);
                }
                break;
            case R.id.tab_more:
                setSelected();
                tab_more.setSelected(true);
                txt_topbar.setText("通讯录");
                if(fg6 == null) {
                    fg6 = new ContactsExFragment();
                    fTransaction.add(R.id.ly_content,fg6);
                } else {
                    fTransaction.show(fg6);
                }
                break;
        }
        fTransaction.commit();
    }
}

