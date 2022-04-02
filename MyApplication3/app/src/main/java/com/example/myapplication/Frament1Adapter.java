package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

public class Frament1Adapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<com.example.fragmentdemo.Product> productList;

    public Frament1Adapter(Context context, int layout, List<com.example.fragmentdemo.Product> productList) {
        this.context = context;
        this.layout = layout;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);
        if(productList.size() > 0 && position >= 0){
            final com.example.fragmentdemo.Product sp = productList.get(position);
            final ImageView img = (ImageView) convertView.findViewById(R.id.img_sanpham);
            final TextView tv_tensp = (TextView) convertView.findViewById(R.id.tv_tensp);
            final TextView tv_dongia = (TextView) convertView.findViewById(R.id.tv_dongia);
            img.setImageResource(sp.getImg());
            tv_tensp.setText(sp.getName());
            DecimalFormat formatter = new DecimalFormat("###,###,###");
            tv_dongia.setText(formatter.format(sp.getPrice())+" VND");
        }
        return  convertView;
    }
}
