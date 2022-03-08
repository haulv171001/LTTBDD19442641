package com.example.testdemo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<NhanVien> {
    int manghinh[] = {
            R.drawable.biden,
            R.drawable.kimjongun,
            R.drawable.obama,
            R.drawable.trump
    };
    Activity context = null;
    ArrayList<NhanVien> myArrayList = null;
    int layoutId;
    public MyArrayAdapter(Activity context,int textviewId,ArrayList<NhanVien> obj){
        super(context,textviewId,obj);
        this.context =  context;
        this.layoutId = textviewId;
        this.myArrayList = obj;
    }
    public View getView(int position,  View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId,null);
        if(myArrayList.size() > 0 && position >= 0){
            final NhanVien nv = myArrayList.get(position);
            final TextView txtmaNV = convertView.findViewById(R.id.manhanvien);
            final TextView txttenNV = convertView.findViewById(R.id.tennhanvien);
            final TextView txtgioitinh = convertView.findViewById(R.id.gioitinh);
            final TextView txtdonvi = convertView.findViewById(R.id.donvi);
            final ImageView imgItem = convertView.findViewById(R.id.avartarNhanVien);
            imgItem.setImageResource(manghinh[nv.getAvatar()]);
            txtmaNV.setText(nv.getMaso());
            txttenNV.setText(nv.getHoten());
            txtgioitinh.setText(nv.getGioitinh());
            txtdonvi.setText(nv.getDonvi());
        }
        return  convertView;
    }
}
