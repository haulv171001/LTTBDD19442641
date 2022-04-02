package com.example.thuongky3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class SanPhamAdapter extends ArrayAdapter<SanPham> {
    Activity context;
    int layoutId;
    ArrayList<SanPham> arrayList = null;
    public SanPhamAdapter(@NonNull Activity context, int resource, @NonNull ArrayList<SanPham> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutId = resource;
        this.arrayList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId,null);
        if(arrayList.size() > 0 && position >= 0){
            final SanPham sp = arrayList.get(position);
            final ImageView img = (ImageView) convertView.findViewById(R.id.img_sanpham);
            final TextView tv_tensp = (TextView) convertView.findViewById(R.id.tv_tensp);
            final TextView tv_dongia = (TextView) convertView.findViewById(R.id.tv_dongia);
            img.setImageResource(sp.getHinh());
            tv_tensp.setText(sp.getTenSanPham());
            DecimalFormat formatter = new DecimalFormat("###,###,###");
            tv_dongia.setText(formatter.format(sp.getDonGia())+" VND");
        }
        return  convertView;
    }
}
