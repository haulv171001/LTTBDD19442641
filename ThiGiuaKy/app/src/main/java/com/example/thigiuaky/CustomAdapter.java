package com.example.thigiuaky;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<NhanVien> {
    private Activity context = null;
    private int resource;
    private ArrayList<NhanVien> nhanViens = null;

    public CustomAdapter(Activity context,int textviewId,ArrayList<NhanVien> obj){
        super(context,textviewId,obj);
        this.context =  context;
        this.resource = textviewId;
        this.nhanViens = obj;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(resource,null);
        if(nhanViens.size() > 0 && position >= 0){
            final NhanVien nv = nhanViens.get(position);
            final TextView txtmaNV = convertView.findViewById(R.id.tv_maNV);
            final TextView txttenNV = convertView.findViewById(R.id.tv_tenNV);
            final TextView txtgioitinh = convertView.findViewById(R.id.tv_gioitinh);
            final TextView txtdonvi = convertView.findViewById(R.id.tv_donvi);
            txtmaNV.setText(nv.getMaNhanVien());
            txttenNV.setText(nv.getTenNhanVien());
            txtgioitinh.setText(nv.getGioitinh());
            txtdonvi.setText(nv.getDonvi());
        }
        return  convertView;
    }

}
