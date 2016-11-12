package cn.luojs.uiwidgetsapp;

/**
 * Created by Luo_0412 on 2016/11/3.
 */

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class TourismNameFragment extends Fragment implements OnItemClickListener {

    private ListView tourismNameListView;

    private List<Tourism> tourismList;

    private TourismAdapter adapter;

    private boolean isTwoPane;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        tourismList = getTourism();  // 鬼删了这行代码，害我找了一天的bug...
        adapter = new TourismAdapter(activity, R.layout.tourism_item, tourismList);
    }  // 尽管被废弃，但是照样可以用

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.tourism_name_frag, container, false);
        tourismNameListView = (ListView) view
                .findViewById(R.id.tourism_view);
        tourismNameListView.setAdapter(adapter);
        tourismNameListView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.tourism_content_layout) != null) {
            isTwoPane = true;
        } else {
            isTwoPane = false;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        Tourism tourism = tourismList.get(position);
        if (isTwoPane) {
            TourismContentFragment tourismContentFragment = (TourismContentFragment) getFragmentManager()
                    .findFragmentById(R.id.tourism_content_fragment);

            tourismContentFragment.refresh(tourism.getName(), tourism.getContent(), tourism.getImageId());
        } else {
            TourismContentActivity.actionStart(getActivity(), tourism.getName(),
                    tourism.getContent(), tourism.getImageId());
        }
    }

    private List<Tourism> getTourism() {
        List<Tourism> tourismList = new ArrayList<Tourism>();

        Tourism forbidden_city = new Tourism(this.getString(R.string.name3),
                this.getString(R.string.cont3),
                R.drawable.forbidden_city);
        tourismList.add(forbidden_city);
        Tourism great_wall = new Tourism(this.getString(R.string.name1),
                this.getString(R.string.cont1),
                R.drawable.great_wall);
        tourismList.add(great_wall);
        Tourism guilin_scenery = new Tourism(this.getString(R.string.name2),
                this.getString(R.string.cont2),
                R.drawable.guilin_scenery);
        tourismList.add(guilin_scenery);
        Tourism moun_huang = new Tourism(this.getString(R.string.name6),
                this.getString(R.string.cont6),
                R.drawable.moun_huang);
        tourismList.add(moun_huang);
        Tourism moun_resort = new Tourism(this.getString(R.string.name9),
                this.getString(R.string.cont9),
                R.drawable.moun_resort);
        tourismList.add(moun_resort);
        Tourism qin_soldiers = new Tourism(this.getString(R.string.name10),
                this.getString(R.string.cont10),
                R.drawable.qin_soldiers);
        tourismList.add(qin_soldiers);
        Tourism sun_moon_lake = new Tourism(this.getString(R.string.name8),
                this.getString(R.string.cont8),
                R.drawable.sun_moon_lake);
        tourismList.add(sun_moon_lake);
        Tourism suzhou_garden = new Tourism(this.getString(R.string.name5),
                this.getString(R.string.cont5),
                R.drawable.suzhou_garden);
        tourismList.add(suzhou_garden);
        Tourism three_gorges = new Tourism(this.getString(R.string.name7),
                this.getString(R.string.cont7),
                R.drawable.three_gorges);
        tourismList.add(three_gorges);
        Tourism west_lake = new Tourism(this.getString(R.string.name4),
                this.getString(R.string.cont4),
                R.drawable.west_lake);
        tourismList.add(west_lake);
        return tourismList;
    }

}

