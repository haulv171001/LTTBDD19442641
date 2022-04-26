package com.example.appone_provider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    static final  String uri = "content://com.example.appone_provider";
    EditText et_id,et_name,et_unit,et_madein;
    Button btInsert,btSelect,btUpdate,btDelete;
    GridView listview;
    ArrayList<ProductActivity> listProducts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        btDelete = findViewById(R.id.buttonDelete);
        et_id = (EditText) findViewById(R.id.etid);
        et_name = (EditText) findViewById(R.id.etname);
        et_unit = (EditText) findViewById(R.id.etunit);
        et_madein = (EditText) findViewById(R.id.etmadein);
        btInsert = (Button) findViewById(R.id.buttonSave);
        btSelect = (Button) findViewById(R.id.buttonSelect);
        btUpdate = findViewById(R.id.buttonUpdate);
        listview = findViewById(R.id.list);

        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("id",et_id.getText().toString());
                values.put("name",et_name.getText().toString());
                values.put("unit",et_unit.getText().toString());
                values.put("madein",et_madein.getText().toString());

                Uri product = Uri.parse(uri);

                Uri insert_uri = getContentResolver().insert(product,values);
                Toast.makeText(getApplicationContext(), "Luu Thanh Cong!!!", Toast.LENGTH_SHORT).show();
            }
        });
        btSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> string_list = new ArrayList<>();
                Uri product = Uri.parse(uri);
                Cursor cursor = getContentResolver().query(product,null,null,null,"name");
                if(cursor!=null){
                    cursor.moveToFirst();
                    do {
                        string_list.add(cursor.getInt(0)+"");
                        string_list.add(cursor.getString(1));
                        string_list.add(cursor.getString(2));
                        string_list.add(cursor.getString(3));
                    }while (cursor.moveToNext());
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(ProductActivity.this, android.R.layout.simple_list_item_1,string_list);
                    listview.setAdapter(adapter);
                }else{
                    Toast.makeText(getApplicationContext(), "Khong co ket qua", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}