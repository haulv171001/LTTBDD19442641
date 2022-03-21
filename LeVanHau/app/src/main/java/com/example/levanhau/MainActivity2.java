package com.example.levanhau;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ListView listView;
    AppCompatButton buttonThoat;
    TextView showInfo;
    ArrayList<NhanVien> arrayList;
    CustomAdapter adapter;
    ArrayAdapter<String> stringArrayAdapter;
    ArrayList<String> strings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = (ListView) findViewById(R.id.lv_nhanvien);
        buttonThoat = (AppCompatButton) findViewById(R.id.btn_dong);
        showInfo = (TextView) findViewById(R.id.tv_showinfo);

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        arrayList = new ArrayList<>();
        strings = new ArrayList<>();
        String filename = "listNV.txt";
        FileInputStream fout = null;
        try {
            fout = openFileInput(filename);
            InputStreamReader is = new InputStreamReader(fout);
            BufferedReader br = new BufferedReader(is);
            String line = null;
            while ((line = br.readLine()) != null) {
                String s[] = line.split(",");
                NhanVien nv = new NhanVien(s[0], s[1], s[2], s[3]);
                arrayList.add(nv);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            for (NhanVien nv : arrayList) {
                strings.add(nv.getMaNV().toString());
            }
//            adapter = new CustomAdapter(MainActivity2.this, R.layout.lv_nhanvienitem, arrayList);
//            listView.setAdapter(adapter);
            stringArrayAdapter = new ArrayAdapter<>(MainActivity2.this, android.R.layout.simple_list_item_single_choice,strings);
            listView.setAdapter(stringArrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    NhanVien nv = arrayList.get(position);
                    showInfo.setText(nv.toString());
                }
            });


            buttonThoat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }
}