package com.xiaoniup.popwindow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoniup on 2017/11/6.
 */

public class PopuoWindowAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mList = new ArrayList<>();

    public PopuoWindowAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public View getView(int position, View convertview, ViewGroup viewGroup) {
        ViewHodle vh = null;
        if (convertview == null){
            vh = new ViewHodle();
            convertview = LayoutInflater.from(mContext).inflate(R.layout.layout_popwindow_item, null);
            vh.tv = (TextView) convertview.findViewById(R.id.popup_window_item_tv);
            convertview.setTag(vh);
        } else {
            vh = (ViewHodle) convertview.getTag();
        }

        vh.tv.setText(mList.get(position));

        return convertview;
    }

    class ViewHodle {
        TextView tv;
    }
}
