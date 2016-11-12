package cn.luojs.uiwidgetsapp;

/**
 * Created by Luo_0412 on 2016/11/3.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TourismContentFragment extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tourism_content_frag, container, false);
        return view;
    }

    public void refresh(String tourismName, String tourismContent, int tourismImageId) {
        View visibilityLayout = view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        TextView tourismTitleText = (TextView) view.findViewById(R.id.tourism_name);
        TextView tourismContentText = (TextView) view.findViewById(R.id.tourism_content);
        tourismContentText.setMovementMethod(ScrollingMovementMethod.getInstance()); // 滚动条
        tourismContentText.setBackgroundResource(tourismImageId); // 刷新背景图
        tourismTitleText.setText(tourismName);       // 刷新旅游点
        tourismContentText.setText(tourismContent);   // 刷新旅游点的内容
    }

}
