package com.example.quanlynhanvien;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterNhanVien  extends BaseAdapter {
    Context context;
    ArrayList<NhanVien> list;

    public AdapterNhanVien(Context context, ArrayList<NhanVien> list) {
        this.context = context;
        this.list = list;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.listview_row,null);
        ImageView imgHinhDaiDien = (ImageView) row.findViewById(R.id.imgeHinhDaiDien);
        TextView textViewMaNV = (TextView) row.findViewById(R.id.textViewMaNV);
        TextView textViewTenNV = (TextView) row.findViewById(R.id.textViewTenNV);
        TextView textViewGioiTinh = (TextView) row.findViewById(R.id.textViewGioiTinh);
        TextView textViewDonVi = (TextView) row.findViewById(R.id.textViewDonVi);
        NhanVien nhanVien = list.get(position);
        textViewMaNV.setText(nhanVien.getMaNhanVien());
        textViewTenNV.setText(nhanVien.getTenNhanVien());
        textViewGioiTinh.setText(nhanVien.getGioitinh());
        textViewDonVi.setText(nhanVien.getDonvi());
        Bitmap bmHinhDaiDien = BitmapFactory.decodeByteArray(nhanVien.getAnh(),0,nhanVien.getAnh().length);
        imgHinhDaiDien.setImageBitmap(bmHinhDaiDien);
        return row;
    }
}
