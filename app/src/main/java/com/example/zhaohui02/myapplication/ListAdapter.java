package com.example.zhaohui02.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by admin on 2017/9/13.
 */

public class ListAdapter extends BaseAdapter {
    private ArrayList<ItemBean> data;

    public ListAdapter(ArrayList<ItemBean> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listview_item, null);
        ImageView img = view.findViewById(R.id.iv);
//        TextView tv=view.findViewById(R.id.tvName);
//        tv.setText(data.get(i).name);
        if (!ListViewActivity.isScroll) {
            img.setImageResource(R.mipmap.aa);
        }
        return view;
    }
}
