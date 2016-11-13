package cn.luojs.uiwidgetsapp;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Jay on 2015/10/8 0008.
 */
public class VPOneActivity extends AppCompatActivity{

    private ViewPager vpager_one;
    private ArrayList<View> aList;
    private MyPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.layout_vp_one);
        vpager_one = (ViewPager) findViewById(R.id.vpager_one);

        aList = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();
        aList.add(li.inflate(R.layout.view_one,null,false));
        aList.add(li.inflate(R.layout.view_two,null,false));
        aList.add(li.inflate(R.layout.view_three,null,false));
        mAdapter = new MyPagerAdapter(aList);
        vpager_one.setAdapter(mAdapter);
    }
}