package cn.luojs.uiwidgetsapp.frag;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.luojs.uiwidgetsapp.R;

/**
 * Created by Jay on 2015/10/8 0008.
 */
public class DLContentFragment2 extends Fragment {

    private TextView tv_content;
    private String strContent;
    private int bgColor;

    public DLContentFragment2(String strContent,int bgColor) {
        this.strContent = strContent;
        this.bgColor = bgColor;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dl_fg_content, container, false);
        view.setBackgroundColor(getResources().getColor(bgColor));
        tv_content = (TextView) view.findViewById(R.id.tv_content);
        tv_content.setText(strContent);
        return view;
    }
}
