package space.qmen.hellou;

/**
 * Created by Luo_0412 on 2016/12/1.
 */


import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ListItemClickAdapter extends BaseAdapter {
    private Context contxet;
    private ArrayList<EditItem> list;
    private ListItemClickHelp callback;
    private LayoutInflater mInflater;

    public ListItemClickAdapter(Context contxet, ArrayList<EditItem> list,
                                ListItemClickHelp callback) {
        this.contxet = contxet;
        this.list = list;
        this.callback = callback;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        mInflater = (LayoutInflater) contxet
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(
                    R.layout.layout_edit_item, null);
            holder = new ViewHolder();
            holder.txt_user_no = (TextView) convertView
                    .findViewById(R.id.txt_user_no);
            holder.txt_user_name = (TextView) convertView
                    .findViewById(R.id.txt_user_name);
            holder.edit_user_btn = (ImageView) convertView
                    .findViewById(R.id.edit_user_btn);
            holder.delete_user_btn = (ImageView) convertView
                    .findViewById(R.id.delete_user_btn);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txt_user_name.setText(list.get(position).getUserName());
        holder.txt_user_no.setText(list.get(position).getUserNo());

        final View view = convertView;
        final int p = position;
        final int one = holder.edit_user_btn.getId();
        holder.edit_user_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onClick(view, parent, p, one);
            }
        });

        final int two = holder.delete_user_btn.getId();
        holder.delete_user_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onClick(view, parent, p, two);
            }
        });

        return convertView;
    }

    public static class ViewHolder {
        TextView txt_user_no;
        TextView txt_user_name;
        ImageView edit_user_btn;
        ImageView delete_user_btn;
    }

}