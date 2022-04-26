package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btCall,btCallBook,btSearch;
    EditText editTextId;
    GridView gridView;
    ArrayList<Book> listBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper dbHelper = new DBHelper(this);
        editTextId = findViewById(R.id.et_nhapid);
        gridView = findViewById(R.id.listmain);
        btSearch = findViewById(R.id.buttonTim);
        btCall = findViewById(R.id.buttongoiAuthor);
        btCallBook = findViewById(R.id.buttongoiBook);
        btCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AuthorActivity.class);
                startActivity(intent);
            }
        });
        btCallBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BookActivity.class);
                startActivity(intent);
            }
        });
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> listString = new ArrayList<>();
                listBook = new ArrayList<>();
                listBook = dbHelper.getAllBookofAuthor(Integer.parseInt(editTextId.getText().toString()));
                for(Book book : listBook){
                    listString.add(book.getId()+"");
                    listString.add(book.getTitle());
                    listString.add(book.getId_author()+"");
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,listString);
                gridView.setAdapter(adapter);
            }
        });
    }
}