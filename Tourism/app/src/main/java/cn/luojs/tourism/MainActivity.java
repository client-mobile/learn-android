package cn.luojs.tourism;

//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.view.Window;
//import android.widget.ListView;
//import java.util.ArrayList;
//import java.util.List;
//
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.Toast;
//import android.widget.AdapterView.OnItemClickListener;
//
//public class MainActivity extends Activity {
//
//    private List<Tourism> TourismList = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        initTourisms();
//        TourismAdapter adapter = new TourismAdapter(MainActivity.this,
//                R.layout.tourism_item, TourismList);
//        ListView listView = (ListView) findViewById(R.id.tourism_view);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                Tourism Tourism = TourismList.get(position);
//                Toast.makeText(MainActivity.this, Tourism.getName(),
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    private void initTourisms() {
//        Tourism forbidden_city = new Tourism("@string/name1", "@string/conf1", R.drawable.forbidden_city);
//        TourismList.add(forbidden_city);
//        Tourism great_wall = new Tourism("@string/name2", "@string/conf2", R.drawable.great_wall);
//        TourismList.add(great_wall);
//        Tourism guilin_scenery = new Tourism("@", "", R.drawable.guilin_scenery);
//        TourismList.add(guilin_scenery);
//        Tourism moun_huang = new Tourism("安徽黄山", "",  R.drawable.moun_huang);
//        TourismList.add(moun_huang);
//        Tourism moun_resort = new Tourism("避暑山庄", "",  R.drawable.moun_resort);
//        TourismList.add(moun_resort);
//        Tourism qin_soldiers = new Tourism("秦兵马俑", " ", R.drawable.qin_soldiers);
//        TourismList.add(qin_soldiers);
//        Tourism sun_moon_lake = new Tourism("台日月潭", "", R.drawable.sun_moon_lake);
//        TourismList.add(sun_moon_lake);
//        Tourism suzhou_garden = new Tourism("苏州园林", " ", R.drawable.suzhou_garden);
//        TourismList.add(suzhou_garden);
//        Tourism three_gorges = new Tourism("长江三峡", " ", R.drawable.three_gorges);
//        TourismList.add(three_gorges);
//        Tourism west_lake = new Tourism("杭州西湖", " ", R.drawable.west_lake);
//        TourismList.add(west_lake);
//    }
//
//}


import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }

}

