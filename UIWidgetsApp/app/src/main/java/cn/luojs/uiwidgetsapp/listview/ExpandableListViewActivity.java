package cn.luojs.uiwidgetsapp.listview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;

import cn.luojs.uiwidgetsapp.R;
import cn.luojs.uiwidgetsapp.adapter.MyBaseExpandableListAdapter;
import cn.luojs.uiwidgetsapp.model.ElvGroup;
import cn.luojs.uiwidgetsapp.model.ElvItem;

public class ExpandableListViewActivity extends AppCompatActivity {

    private ArrayList<ElvGroup> gData = null;
    private ArrayList<ArrayList<ElvItem>> iData = null;
    private ArrayList<ElvItem> lData = null;
    private Context mContext;
    private ExpandableListView exlist_lol;
    private MyBaseExpandableListAdapter myAdapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.layout_elv);
        mContext = ExpandableListViewActivity.this;
        exlist_lol = (ExpandableListView) findViewById(R.id.exlist_lol);


        //数据准备
        gData = new ArrayList<ElvGroup>();
        iData = new ArrayList<ArrayList<ElvItem>>();
        gData.add(new ElvGroup("AD"));
        gData.add(new ElvGroup("AP"));
        gData.add(new ElvGroup("TANK"));

        lData = new ArrayList<ElvItem>();

        //AD组
        lData.add(new ElvItem(R.mipmap.iv_lol_icon3,"剑圣"));
        lData.add(new ElvItem(R.mipmap.iv_lol_icon4,"德莱文"));
        lData.add(new ElvItem(R.mipmap.iv_lol_icon13,"男枪"));
        lData.add(new ElvItem(R.mipmap.iv_lol_icon14,"韦鲁斯"));
        iData.add(lData);
        //AP组
        lData = new ArrayList<ElvItem>();
        lData.add(new ElvItem(R.mipmap.iv_lol_icon1, "提莫"));
        lData.add(new ElvItem(R.mipmap.iv_lol_icon7, "安妮"));
        lData.add(new ElvItem(R.mipmap.iv_lol_icon8, "天使"));
        lData.add(new ElvItem(R.mipmap.iv_lol_icon9, "泽拉斯"));
        lData.add(new ElvItem(R.mipmap.iv_lol_icon11, "狐狸"));
        iData.add(lData);
        //TANK组
        lData = new ArrayList<ElvItem>();
        lData.add(new ElvItem(R.mipmap.iv_lol_icon2, "诺手"));
        lData.add(new ElvItem(R.mipmap.iv_lol_icon5, "德邦"));
        lData.add(new ElvItem(R.mipmap.iv_lol_icon6, "奥拉夫"));
        lData.add(new ElvItem(R.mipmap.iv_lol_icon10, "龙女"));
        lData.add(new ElvItem(R.mipmap.iv_lol_icon12, "狗熊"));
        iData.add(lData);

        myAdapter = new MyBaseExpandableListAdapter(gData,iData,mContext);
        exlist_lol.setAdapter(myAdapter);


        //为列表设置点击事件
        exlist_lol.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(mContext, "你点击了：" + iData.get(groupPosition).get(childPosition).getiName(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });


    }
}
