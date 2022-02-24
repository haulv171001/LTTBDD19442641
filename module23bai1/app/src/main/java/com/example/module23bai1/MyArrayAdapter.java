package com.example.module23bai1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<NhanVien> {
    Activity context = null;
    ArrayList<NhanVien> myArray = null;
    int layoutId;
    public MyArrayAdapter(Activity context, int textViewRId,ArrayList<NhanVien> obj){
        super(context,textViewRId,obj);
        this.context = context;
        this.layoutId = textViewRId;
        this.myArray = obj;
    }
    public View getView(int i, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId,null);
        if(myArray.size() > 0 && i >= 0 )
        {
            final TextView txtDislay = convertView.findViewById(R.id.tv_item);
            final  NhanVien nv = myArray.get(i);
            txtDislay.setText(nv.toString());
            final ImageView imgItem = convertView.findViewById(R.id.img_item);
            if(nv.isGender())
            {
                imgItem.setImageResource(R.drawable.male);
            }else{
                imgItem.setImageResource(R.drawable.famale);
            }
        }
        return  convertView;
    }
}
