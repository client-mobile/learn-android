package cn.luojs.uiwidgetsapp.menu;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import cn.luojs.uiwidgetsapp.R;
import cn.luojs.uiwidgetsapp.adapter.ReusableAdapter;
import cn.luojs.uiwidgetsapp.frag.DLContentFragment;
import cn.luojs.uiwidgetsapp.model.DLItem;

public class DrawerLayoutActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private DrawerLayout drawer_layout;
    private ListView list_left_drawer;
    private ArrayList<DLItem> menuLists;
    private ReusableAdapter<DLItem> myAdapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.layout_drawerlayout);

        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        list_left_drawer = (ListView) findViewById(R.id.list_left_drawer);

        menuLists = new ArrayList<DLItem>();
        menuLists.add(new DLItem(R.mipmap.iv_menu_realtime,"实时信息"));
        menuLists.add(new DLItem(R.mipmap.iv_menu_alert,"提醒通知"));
        menuLists.add(new DLItem(R.mipmap.iv_menu_trace,"活动路线"));
        menuLists.add(new DLItem(R.mipmap.iv_menu_settings,"相关设置"));
        myAdapter = new ReusableAdapter<DLItem>(menuLists,R.layout.dl_item_list) {
            @Override
            public void bindView(ViewHolder holder, DLItem obj) {
                holder.setImageResource(R.id.img_icon,obj.getIconId());
                holder.setText(R.id.txt_content, obj.getIconName());
            }
        };
        list_left_drawer.setAdapter(myAdapter);
        list_left_drawer.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DLContentFragment contentFragment = new DLContentFragment();
        Bundle args = new Bundle();
        args.putString("text", menuLists.get(position).getIconName());
        contentFragment.setArguments(args);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.ly_content,contentFragment).commit();
        drawer_layout.closeDrawer(list_left_drawer);
    }
}

