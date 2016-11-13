package cn.luojs.uiwidgetsapp.listview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.luojs.uiwidgetsapp.R;
import cn.luojs.uiwidgetsapp.adapter.ReusableAdapter;
import cn.luojs.uiwidgetsapp.model.App;
import cn.luojs.uiwidgetsapp.model.Book;

public class ReusableAdapterActivity extends AppCompatActivity {

    private Context mContext;
    private ListView list_book;
    private ListView list_app;

    private ReusableAdapter<App> ReusableAdapter1 = null;
    private ReusableAdapter<Book> ReusableAdapter2 = null;
    private List<App> mData1 = null;
    private List<Book> mData2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.layout_reusable_adapter);
        mContext = ReusableAdapterActivity.this;
        init();

    }

    private void init() {

        list_book = (ListView) findViewById(R.id.list_book);
        list_app = (ListView) findViewById(R.id.list_app);

        //数据初始化
        mData1 = new ArrayList<App>();
        mData1.add(new App(R.mipmap.iv_icon_baidu,"百度"));
        mData1.add(new App(R.mipmap.iv_icon_douban,"豆瓣"));
        mData1.add(new App(R.mipmap.iv_icon_zhifubao,"支付宝"));

        mData2 = new ArrayList<Book>();
        mData2.add(new Book("《第一行代码Android》","郭霖"));
        mData2.add(new Book("《Android群英传》","徐宜生"));
        mData2.add(new Book("《Android开发艺术探索》","任玉刚"));

        //Adapter初始化
        ReusableAdapter1 = new ReusableAdapter<App>((ArrayList)mData1,R.layout.item_one) {
            @Override
            public void bindView(ViewHolder holder, App obj) {
                holder.setImageResource(R.id.img_icon,obj.getaIcon());
                holder.setText(R.id.txt_aname,obj.getaName());
            }
        };
        ReusableAdapter2 = new ReusableAdapter<Book>((ArrayList)mData2,R.layout.item_two) {
            @Override
            public void bindView(ViewHolder holder, Book obj) {
                holder.setText(R.id.txt_bname,obj.getbName());
                holder.setText(R.id.txt_bauthor,obj.getbAuthor());
            }
        };

        //ListView设置下Adapter：
        list_book.setAdapter(ReusableAdapter2);
        list_app.setAdapter(ReusableAdapter1);

    }


}
