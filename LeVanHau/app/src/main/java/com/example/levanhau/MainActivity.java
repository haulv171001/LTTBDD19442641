package com.example.levanhau;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    AppCompatButton btnopen,btnsave;
    ArrayList<NhanVien> nv_list;
    EditText etmanv,etten,etngaysinh,etdiachi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsave = (AppCompatButton) findViewById(R.id.btn_save);
        btnopen = (AppCompatButton) findViewById(R.id.btn_newContext);

        etmanv = findViewById(R.id.editTextmaNV);
        etten = findViewById(R.id.editTextTen);
        etngaysinh = findViewById(R.id.editTextNgaySinh);
        etdiachi = findViewById(R.id.editTextDiaCHi);


        nv_list = new ArrayList<>();
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nv_list.add(new NhanVien(etmanv.getText().toString(),etten.getText().toString(),etngaysinh.getText().toString(),etdiachi.getText().toString()));

                String filename = "listNV.txt";
                FileOutputStream fout = null;
                try {
                    fout = openFileOutput(filename, Context.MODE_PRIVATE);
                    OutputStreamWriter os = new OutputStreamWriter(fout);
                    for (NhanVien nv : nv_list){
                        os.write(nv.toString());
                        os.write("\n");
                        os.flush();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fout != null){
                        try {
                            fout.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        btnopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}