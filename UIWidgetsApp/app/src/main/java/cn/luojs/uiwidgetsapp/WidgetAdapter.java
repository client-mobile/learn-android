package cn.luojs.uiwidgetsapp;

/**
 * Created by Luo_0412 on 2016/11/11.
 */

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class WidgetAdapter extends ArrayAdapter<Widget> {

    private int resourceId;

    /**
     * 有参构造函数
     * @param context
     * @param textViewResourceId
     * @param objects
     */
    public WidgetAdapter(Context context, int textViewResourceId, List<Widget> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Widget widget = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.widgetImage = (ImageView) view.findViewById(R.id.widget_image);
            viewHolder.widgetName = (TextView) view.findViewById(R.id.widget_name);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.widgetImage.setImageResource(widget.getImageId());
        viewHolder.widgetName.setText(widget.getName());
        return view;
    }

    /**
     * 内部类 图片 + 文字
     */
    class ViewHolder {
        ImageView widgetImage;
        TextView widgetName;
    }

}