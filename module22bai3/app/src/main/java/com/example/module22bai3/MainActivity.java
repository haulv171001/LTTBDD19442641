package com.example.module22bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.lvname);
        EditText editTextNhapten = findViewById(R.id.tvnhapten);
        TextView textViewKq = findViewById(R.id.tvName);
        Button buttonNhap = findViewById(R.id.btNhap);
        ArrayList<String> arrayName = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,R.layout.layout_selector,R.id.tvselector,arrayName);
        listView.setAdapter(adapter);
        buttonNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayName.add(editTextNhapten.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textViewKq.setText("position :" + position +";value ="+adapter.getItem(position).toString());
                view.setSelected(true);
            }
        });
    }
}