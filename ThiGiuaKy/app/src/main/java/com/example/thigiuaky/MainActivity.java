package com.example.thigiuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageButton imageButton;
    private ListView listView;
    private ArrayList<NhanVien> nhanViens;
    private CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton = findViewById(R.id.btn_add);
        listView = findViewById(R.id.lv_main);
        nhanViens = new ArrayList<>();
        nhanViens.add(new NhanVien("NV001","Le Van Hau","Nam","Phòng Kế Toán"));
        nhanViens.add(new NhanVien("NV001","Le Van Hau","Nam","Phòng Kế Toán"));
        nhanViens.add(new NhanVien("NV001","Le Van Hau","Nam","Phòng Kế Toán"));
        nhanViens.add(new NhanVien("NV001","Le Van Hau","Nam","Phòng Kế Toán"));
        nhanViens.add(new NhanVien("NV001","Le Van Hau","Nam","Phòng Kế Toán"));
        nhanViens.add(new NhanVien("NV001","Le Van Hau","Nam","Phòng Kế Toán"));
        nhanViens.add(new NhanVien("NV001","Le Van Hau","Nam","Phòng Kế Toán"));
        nhanViens.add(new NhanVien("NV001","Le Van Hau","Nam","Phòng Kế Toán"));
        nhanViens.add(new NhanVien("NV001","Le Van Hau","Nam","Phòng Kế Toán"));
        nhanViens.add(new NhanVien("NV001","Le Van Hau","Nam","Phòng Kế Toán"));
        nhanViens.add(new NhanVien("NV001","Le Van Hau","Nam","Phòng Kế Toán"));
        nhanViens.add(new NhanVien("NV001","Le Van Hau","Nam","Phòng Kế Toán"));
        adapter = new CustomAdapter(MainActivity.this,R.layout.list_view_nhanvien,nhanViens);
        listView.setAdapter(adapter);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FormActivity.class);
                startActivity(intent);
            }
        });
    }
}