package com.example.itentcontext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    TextView tv_masv,tv_tensv,tv_namsinh,tv_gioitinh;
    AppCompatButton btnTroVe;
    ArrayList<SinhVien> arrayList;
    ArrayAdapter<String> adapter;
    ArrayList<String> strings;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnTroVe = (AppCompatButton) findViewById(R.id.button_trove);
        listView = (ListView) findViewById(R.id.lv_sinhvien);
        tv_masv = findViewById(R.id.tv_maSV);
        tv_tensv = findViewById(R.id.tv_TenSV);
        tv_namsinh = findViewById(R.id.tv_namsinh);
        tv_gioitinh = findViewById(R.id.tv_gioitinh);
        arrayList = new ArrayList<>();
        strings = new ArrayList<>();
        arrayList.add(new SinhVien("19442641","Lê Văn Hậu","17/10/2001","Nam"));
        arrayList.add(new SinhVien("19442642"," Hậu","17/10/2001","Nam"));
        arrayList.add(new SinhVien("19442643","Lê","17/10/2001","Nam"));
        arrayList.add(new SinhVien("19442644","Văn Hậu","17/10/2001","Nam"));
        arrayList.add(new SinhVien("19442641","Lê Văn Hậu","17/10/2001","Nam"));
        arrayList.add(new SinhVien("19442642"," Hậu","17/10/2001","Nam"));
        arrayList.add(new SinhVien("19442643","Lê","17/10/2001","Nam"));
        arrayList.add(new SinhVien("19442644","Văn Hậu","17/10/2001","Nam"));
        for(SinhVien sv : arrayList){
            strings.add(sv.getMaSinhvien());
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice,strings);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SinhVien  sv = arrayList.get(position);
                tv_masv.setText(sv.getMaSinhvien());
                tv_tensv.setText(sv.getTenSinhvien());
                tv_gioitinh.setText(sv.getGioitinh());
                tv_namsinh.setText(sv.getNamsinh());
            }
        });
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}