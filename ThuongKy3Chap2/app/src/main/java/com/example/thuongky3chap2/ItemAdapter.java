package com.example.thuongky3chap2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

public class ItemAdapter extends BaseAdapter {
    private Context context;
    private int layoutId;
    private List<Product> itemlist;

    public ItemAdapter(Context context, int layoutId, List<Product> itemlist) {
        this.context = context;
        this.layoutId = layoutId;
        this.itemlist = itemlist;
    }

    @Override
    public int getCount() {
        return 0;
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
        View row = inflater.inflate(layoutId,null);
        ImageView imageViewAvatar =(ImageView) row.findViewById(R.id.img_sanpham);
        TextView textViewTenSP = (TextView) row.findViewById(R.id.tv_tensp);
        TextView textViewDonGia = (TextView)  row.findViewById(R.id.tv_dongia);
        Product product = itemlist.get(position);
        imageViewAvatar.setImageResource(product.getAnh());
        textViewTenSP.setText(product.getName());
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        textViewDonGia.setText(formatter.format(product.getGia()+"VNĐ"));
        return  row;

    }
}
