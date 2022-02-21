package com.example.module2bai6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textViewKq = findViewById(R.id.tvkq);
        ListView listViewName = findViewById(R.id.lvName);
        Resources res = getResources();
        String[] arr = res.getStringArray(R.array.name);
        ListAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.selector,R.id.tvcus,arr);
        listViewName.setAdapter(arrayAdapter);
        listViewName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textViewKq.setText("position :"+ arrayAdapter.getItemId(position) + " "+"value ="+arrayAdapter.getItem(position).toString());
                view.setSelected(true);
            }
        });
    }
}