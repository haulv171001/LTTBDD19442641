package com.example.levanhau;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<NhanVien> {
    Activity context = null;
    ArrayList<NhanVien> myArrayList = null;
    int layoutId;
    boolean isListView;
    int selectedPosition = -1;
    public CustomAdapter(@NonNull Activity context, int resource, @NonNull ArrayList<NhanVien> objects) {
        super(context, resource, objects);
        this.context =  context;
        this.layoutId = resource;
        this.myArrayList = objects;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId,null);
        if(myArrayList.size() > 0 && position >= 0){
            final NhanVien nv = myArrayList.get(position);
            final TextView maNV = convertView.findViewById(R.id.label);
            final RadioButton radiomaNV = convertView.findViewById(R.id.radio_button);
            maNV.setText(nv.getMaNV());
        }
        return  convertView;
    }
}
