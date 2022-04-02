package com.example.file;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    Context context;
    TextView tvkq;
    ArrayAdapter<String> adapter;
    ListView listView;
    Button buttonTroVe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvkq = findViewById(R.id.textViewkq);
        buttonTroVe = findViewById(R.id.button3);
        listView = findViewById(R.id.lv_data);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayList<String> rs = new ArrayList<>();
        File[] files = getFilesDir().listFiles();
        for( File f : files){
            String filename = f.getName();
            int dot = filename.indexOf(".");
            filename = filename.substring(0,dot);
            rs.add(filename);
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice,rs);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FileInputStream fout = null;
                try {
                    fout = openFileInput(rs.get(position).toString()+".txt");
                    InputStreamReader is= new InputStreamReader(fout);
                    BufferedReader br = new BufferedReader(is);
                    String line = null;
                    while ((line = br.readLine())!= null){
                        tvkq.setText(line.toString());
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if(fout != null){
                        try {
                            fout.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        buttonTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}