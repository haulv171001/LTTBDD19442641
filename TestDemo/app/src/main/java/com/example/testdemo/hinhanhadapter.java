package com.example.testdemo;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class hinhanhadapter extends BaseAdapter {
    private Activity context;
    private int layout;
    private ArrayList<HinhAnh> hinhAnhList = null ;

    public hinhanhadapter(Activity context, int layout, ArrayList<HinhAnh> hinhAnhList) {
        this.context = context;
        this.layout = layout;
        this.hinhAnhList = hinhAnhList;
    }

    @Override
    public int getCount() {
        return hinhAnhList.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layout,null);
        if(hinhAnhList.size() > 0 && position >= 0 ){
            final  HinhAnh a = hinhAnhList.get(position);
            final ImageView img = convertView.findViewById(R.id.hinhanh);
            img.setImageResource(a.getHinh());
        }
        return  convertView;
    }
}
