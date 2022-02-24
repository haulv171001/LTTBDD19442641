package com.example.module23bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<NhanVien> arrNhanVien = null;
    MyArrayAdapter adapter = null;
    ListView listView = null;
    Button btNhapNV;
    ImageButton btnremove;
    EditText txtMa,txtTen;
    RadioGroup gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btNhapNV = findViewById(R.id.btnNhapNV);
        btnremove = findViewById(R.id.btnxoa);
        txtMa = findViewById(R.id.etMaNv);
        txtTen = findViewById(R.id.etTenNv);
        gender = findViewById(R.id.radiogroupgender);
        listView = findViewById(R.id.lvNV);
        arrNhanVien = new ArrayList<NhanVien>();
        adapter = new MyArrayAdapter(this,R.layout.my_item_layout,arrNhanVien);
        listView.setAdapter(adapter);
        btNhapNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyNhap();
            }
        });
        btnremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyXoa();
            }
        });
    }

    private void xuLyXoa() {
        for(int i = listView.getChildCount() - 1;i>=0;i--)
        {
            View v = listView.getChildAt(i);
            CheckBox chk = v.findViewById(R.id.chk_item);
            if(chk.isChecked()){
                arrNhanVien.remove(i);
            }
        }
        adapter.notifyDataSetChanged();
    }

    private void xuLyNhap() {
        String ma = txtMa.getText().toString();
        String ten = txtTen.getText().toString();
        boolean gioitinh = false;
        if(gender.getCheckedRadioButtonId() == R.id.radioNu)
        {
            gioitinh = true;
        }
        NhanVien nv = new NhanVien();
        nv.setId(ma);
        nv.setName(ten);
        nv.setGender(gioitinh);

        arrNhanVien.add(nv);
        adapter.notifyDataSetChanged();
        txtMa.setText("");
        txtTen.setText("");
        txtMa.requestFocus();
    }
}