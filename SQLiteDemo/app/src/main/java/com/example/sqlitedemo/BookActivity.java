package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    EditText et_idBook,et_titleBook,et_idAuthor;
    Button btInsertBook,btSelectBook,btUpdateBook,btDeleteBook;
    GridView listviewBook;
    ArrayList<Book> listBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        DBHelper dbHelper = new DBHelper(this);
        et_idBook = (EditText) findViewById(R.id.etidbook);
        et_idAuthor =(EditText) findViewById(R.id.etidAuthor);
        et_titleBook = (EditText) findViewById(R.id.ettitlebook);
        btInsertBook = (Button) findViewById(R.id.buttonSave1);
        btSelectBook = (Button) findViewById(R.id.buttonSelect1);
        btUpdateBook = findViewById(R.id.buttonUpdate1);
        btDeleteBook = findViewById(R.id.buttonDelete1);
        listviewBook = findViewById(R.id.listBook);
        btInsertBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setId(Integer.parseInt(et_idBook.getText().toString()));
                book.setTitle(et_titleBook.getText().toString());
                book.setId_author(Integer.parseInt(et_idAuthor.getText().toString()));
                if(dbHelper.insertBooks(book) > 0){
                    Toast.makeText(getApplicationContext(), "ban da luu thanh cong", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "luu khong thanh cong", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btSelectBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book tempBook = null;
                ArrayList<String> listString = new ArrayList<>();
                ArrayList<String> listString1 = new ArrayList<>();
                listBook = new ArrayList<>();
                if(et_idBook.getText().toString().equals("")){
                    listBook = dbHelper.getAllBook();
                }else{
                    try {
                        tempBook = dbHelper.getIdBook(Integer.parseInt(et_idBook.getText().toString()));
                        listString1.add(tempBook.getId()+"");
                        listString1.add(tempBook.getTitle());
                        listString1.add(tempBook.getId_author()+"");
                        et_idBook.setText(listString1.get(0));
                        et_titleBook.setText(listString1.get(1));
                        et_idAuthor.setText(listString1.get(2));
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(), "Khong ton tai id " +et_idBook.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                    if(tempBook != null){
                        listBook.add(tempBook);
                    }else{
                        Toast.makeText(getApplicationContext(), "Khong ton tai id " +et_idBook.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
                for(Book book : listBook){
                    listString.add(book.getId()+"");
                    listString.add(book.getTitle());
                    listString.add(book.getId_author()+"");
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(BookActivity.this, android.R.layout.simple_list_item_1,listString);
                listviewBook.setAdapter(adapter);
            }
        });
        btUpdateBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> listString = new ArrayList<>();
                if(dbHelper.updateBook(Integer.parseInt(et_idBook.getText().toString()),et_titleBook.getText().toString(),Integer.parseInt(et_idAuthor.getText().toString()))){
                    Toast.makeText(getApplicationContext(), "UPDATE Complete", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "UPDATE FAIL", Toast.LENGTH_SHORT).show();
                }
                listBook = dbHelper.getAllBook();
                for(Book book : listBook){
                    listString.add(book.getId()+"");
                    listString.add(book.getTitle());
                    listString.add(book.getId_author()+"");
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(BookActivity.this, android.R.layout.simple_list_item_1,listString);
                listviewBook.setAdapter(adapter);
            }
        });
        btDeleteBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deleteBooks(Integer.parseInt(et_idBook.getText().toString()));
                ArrayList<String> listString = new ArrayList<>();
                listBook = dbHelper.getAllBook();
                for(Book book : listBook){
                    listString.add(book.getId()+"");
                    listString.add(book.getTitle());
                    listString.add(book.getId_author()+"");
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(BookActivity.this, android.R.layout.simple_list_item_1,listString);
                listviewBook.setAdapter(adapter);
            }
        });

    }
}