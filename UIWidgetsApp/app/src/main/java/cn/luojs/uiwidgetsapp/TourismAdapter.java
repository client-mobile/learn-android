package cn.luojs.uiwidgetsapp;

/**
 * Created by Luo_0412 on 2016/11/3.
 */


import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TourismAdapter extends ArrayAdapter<Tourism> {

    private int resourceId;
    public TourismAdapter(Context context, int textViewResourceId,
                          List<Tourism> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Tourism tourism = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.tourismImage = (ImageView) view.findViewById(R.id.tourism_image);
            viewHolder.tourismName = (TextView) view.findViewById(R.id.tourism_name);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tourismImage.setImageResource(tourism.getImageId());
        viewHolder.tourismName.setText(tourism.getName());
        return view;
    }

    class ViewHolder {
        ImageView tourismImage;
        TextView tourismName;
    }

}
