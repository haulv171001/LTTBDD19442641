package com.example.testdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int manghinh[] = {
            R.drawable.biden,
            R.drawable.kimjongun,
            R.drawable.obama,
            R.drawable.trump
    };
    ArrayList<HinhAnh> hinhAnhArrayList;
    hinhanhadapter hinhanhadapter;
    MyArrayAdapter myArrayAdapter;
    ImageView avatar;
    ArrayList<NhanVien> nv_list = new ArrayList<>();
    String[] dv_list;
    String donvi;
    int vitrihinhanh;
    EditText editTextNhapMa;
    EditText editTextTen;
    RadioGroup radioGroupGenDer;
    Spinner spinnerdonvi;
    ListView listViewNhanVien;
    Button btThemNV,btXoa,btTruyVan,btThemAnhNV,Thoat;
    int vitrinhanvien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    editTextNhapMa = findViewById(R.id.etMa);
    editTextTen = findViewById(R.id.etHoTen);
    radioGroupGenDer = findViewById(R.id.radioGroupGender);
    spinnerdonvi = findViewById(R.id.spinnerDonVi);
    listViewNhanVien = findViewById(R.id.lvNhanVien);
    btThemNV = findViewById(R.id.btThemNV);
    btXoa = findViewById(R.id.btXoaNV);
    btTruyVan = findViewById(R.id.btTruyVan);
    btThemAnhNV = findViewById(R.id.btavatar);
    Thoat = findViewById(R.id.btThoat);
    avatar = findViewById(R.id.imgavatar);
    RadioButton nam = findViewById(R.id.Nam);
    RadioButton nu = findViewById(R.id.Nu);
        Context context = this;
        GridView listView = new GridView(context);
        listView.setNumColumns(3);
        hinhAnhArrayList = new ArrayList<>();
//        hinhAnhArrayList.add(new HinhAnh(R.drawable.biden));
//        hinhAnhArrayList.add(new HinhAnh(R.drawable.kimjongun));
//        hinhAnhArrayList.add(new HinhAnh(R.drawable.obama));
//        hinhAnhArrayList.add(new HinhAnh(R.drawable.trump));
        for(int i = 0 ; i < manghinh.length ; i ++){
            hinhAnhArrayList.add(new HinhAnh(manghinh[i]));
        }
        hinhanhadapter = new hinhanhadapter(this,R.layout.dong_hinh_anh,hinhAnhArrayList);
        listView.setAdapter(hinhanhadapter);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setPositiveButton("Trở lại", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setCancelable(true);
        builder.setView(listView);
        final AlertDialog dialog = builder.create();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                vitrihinhanh = position;
                avatar.setImageResource(manghinh[position]);
                dialog.dismiss();
            }
        });
        dv_list = getResources().getStringArray(R.array.donvi_list);
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,dv_list);
        spinnerdonvi.setAdapter(adapter);
        spinnerdonvi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                donvi = dv_list[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    btThemAnhNV.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialog.show();
        }
    });
    btThemNV.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           String maso = editTextNhapMa.getText().toString();
           String hoten = editTextTen.getText().toString();
           String gioitinh = ((RadioButton)findViewById(radioGroupGenDer.getCheckedRadioButtonId())).getText().toString();
           NhanVien nv = new NhanVien(vitrihinhanh,maso,hoten,gioitinh,donvi);
           nv_list.add(nv);

           ArrayList<String> listItems = new ArrayList<>();

           for(NhanVien nv1 : nv_list)
               listItems.add(nv1.toString());
           myArrayAdapter = new MyArrayAdapter(MainActivity.this,R.layout.listview_item,nv_list);
           listViewNhanVien.setAdapter(myArrayAdapter);
        }
    });
    listViewNhanVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            NhanVien nv = nv_list.get(position);
            avatar.setImageResource(manghinh[nv.getAvatar()]);
            editTextNhapMa.setText(nv.getMaso());
            editTextTen.setText(nv.getHoten());
            if(radioGroupGenDer.getCheckedRadioButtonId() == R.id.Nu){
                nu.isChecked();
            }else{
                nam.isChecked();
            }
            spinnerdonvi.setSelection(position);
            vitrinhanvien = position;
        }
    });
    btXoa.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            nv_list.remove(vitrinhanvien);
            avatar.setImageResource(R.drawable.trump);
            editTextNhapMa.setText("");
            editTextTen.setText("");
            if(radioGroupGenDer.getCheckedRadioButtonId() == R.id.Nu){
                nu.setChecked(false);
            }else{
                nam.setChecked(false);
            }
            spinnerdonvi.setSelection(0);
            myArrayAdapter.notifyDataSetChanged();
        }
    });
    Thoat.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    });
    }
}