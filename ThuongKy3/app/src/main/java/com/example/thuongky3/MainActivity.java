package com.example.thuongky3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gv;
    SanPhamAdapter adapter;
    ArrayList<SanPham> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv = (GridView)  findViewById(R.id.gv_item);
        arrayList = new ArrayList<>();
        arrayList.add(new SanPham("TH true milk",24000,R.drawable.milk));
        arrayList.add(new SanPham("Sting",10000,R.drawable.sting));
        arrayList.add(new SanPham("Pepsi",10000,R.drawable.pepsi));
        arrayList.add(new SanPham("Coca",10000,R.drawable.coca));
        arrayList.add(new SanPham("Nước suối",5000,R.drawable.aqua));
        arrayList.add(new SanPham("Bia tiger lon",23000,R.drawable.biatiger));
        arrayList.add(new SanPham("Cafe lon",17000,R.drawable.cafe));
        adapter = new SanPhamAdapter(this,R.layout.dong_sanpham,arrayList);
        gv.setAdapter(adapter);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                SanPham sp = arrayList.get(position);
                intent.putExtra("sp",(Serializable) sp);
                startActivity(intent);
            }
        });
    }
}