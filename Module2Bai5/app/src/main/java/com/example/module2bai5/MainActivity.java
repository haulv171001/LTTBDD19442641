package com.example.module2bai5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int TongKH,TongKHVip,TongDoanhThu = 0;
    double thanhtien = 0;
    ArrayList<Cus> customers = new ArrayList<Cus>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editTextTen = findViewById(R.id.etTenKhachHang);
        EditText editTextSoLuong = findViewById(R.id.etSoLuongSach);
        CheckBox checkBoxVip = findViewById(R.id.cbKhachHangVip);
        TextView textViewThanhTien = findViewById(R.id.tvThanhTien);
        Button buttonTinhTT = findViewById(R.id.btThanhTien);
        Button buttonTiep = findViewById(R.id.btTiep);
        Button buttonThongKe = findViewById(R.id.btThongKe);
        EditText editTextTongKh = findViewById(R.id.etTongKH);
        EditText editTextTongKhVip = findViewById(R.id.etTongKHVip);
        EditText editTextTongDoanhThu = findViewById(R.id.etTongDoanhThu);
        ImageButton buttonClose = findViewById(R.id.btThoat);

        buttonTinhTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextTen.getText().toString();
                int soluong = Integer.parseInt(editTextSoLuong.getText().toString());
                if(checkBoxVip.isChecked()){
                    thanhtien = soluong * 20000 * 0.1;
                    Cus c = new Cus(name,soluong,true,thanhtien);
                    customers.add(c);
                }else{
                    thanhtien = soluong * 20000;
                    Cus c = new Cus(name,soluong,false,thanhtien);
                    customers.add(c);
                }
                textViewThanhTien.setText(thanhtien+"");
            }
        });
        buttonTiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextTen.setText("");
                editTextSoLuong.setText("");
                checkBoxVip.setChecked(false);
                textViewThanhTien.setText("");
                editTextTen.requestFocus();
            }
        });
        buttonThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i= 0;
                for(Cus cus : customers){
                    if(cus.isVip()){
                        i+=1;
                    }
                    TongKH = customers.size();
                    TongDoanhThu += cus.getTongtien();
                }
                editTextTongKhVip.setText(i+"");
                editTextTongKh.setText(TongKH+"");
                editTextTongDoanhThu.setText(TongDoanhThu+"");
            }
        });
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}