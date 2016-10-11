package com.example.luo_0412.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
//import android.widget.ListView;

/**
 * Created by Luo_0412 on 2016/10/11.
 */

public class ListViewDemoActivity extends Activity {

//    private String[] data = { "Apple", "Banana", "Orange", "Watermelon",
//            "Pear", "Grape", "Pineapple", "Strawberry", "Cherry",
//            "Mango" };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        // 基本设置
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.list_view_demo);
//
//        // ListView和数据之间的关联：调用ListView的setAdapter()方法
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                ListViewDemoActivity.this,
//                android.R.layout.simple_list_item_1, data);
//        ListView listView = (ListView) findViewById(R.id.list_view);
//        listView.setAdapter(adapter);
//    }



    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_demo);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(ListViewDemoActivity.this,
                R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(ListViewDemoActivity.this, fruit.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruits() {
        Fruit apple = new Fruit("Apple", R.mipmap.apple_pic);
        fruitList.add(apple);
        Fruit banana = new Fruit("Banana", R.mipmap.banana_pic);
        fruitList.add(banana);
        Fruit orange = new Fruit("Orange", R.mipmap.orange_pic);
        fruitList.add(orange);
        Fruit watermelon = new Fruit("Watermelon", R.mipmap.watermelon_pic);
        fruitList.add(watermelon);
        Fruit pear = new Fruit("Pear", R.mipmap.pear_pic);
        fruitList.add(pear);
        Fruit grape = new Fruit("Grape", R.mipmap.grape_pic);
        fruitList.add(grape);
        Fruit pineapple = new Fruit("Pineapple", R.mipmap.pineapple_pic);
        fruitList.add(pineapple);
        Fruit strawberry = new Fruit("Strawberry", R.mipmap.strawberry_pic);
        fruitList.add(strawberry);
        Fruit cherry = new Fruit("Cherry", R.mipmap.cherry_pic);
        fruitList.add(cherry);
        Fruit mango = new Fruit("Mango", R.mipmap.mango_pic);
        fruitList.add(mango);
    }

}
