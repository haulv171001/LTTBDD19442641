package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class AuthorActivity extends AppCompatActivity {
    EditText et_id,et_name,et_address,et_email,et_timkiem;
    Button btInsert,btSelect,btSearch,btUpdate,btDelete;
    GridView listview;
    ArrayList<Author> listAuthors;
    int vitri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);
        btDelete = findViewById(R.id.buttonDelete);
        et_id = (EditText) findViewById(R.id.etid);
        et_name = (EditText) findViewById(R.id.etname);
        et_address = (EditText) findViewById(R.id.etaddress);
        et_email = (EditText) findViewById(R.id.etemail);
        btInsert = (Button) findViewById(R.id.buttonSave);
        btSelect = (Button) findViewById(R.id.buttonSelect);
        btUpdate = findViewById(R.id.buttonUpdate);
        listview = findViewById(R.id.list);
        DBHelper dbHelper = new DBHelper(this);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                vitri = position;
                listAuthors = dbHelper.getAllAuthor();
                Author author = listAuthors.get(position);
                et_id.setText(author.getIdAuthor()+"");
                et_name.setText(author.getName());
                et_address.setText(author.getAddress());
                et_email.setText(author.getEmail());
            }
        });
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deleteAuthors(Integer.parseInt(et_id.getText().toString()));
                ArrayList<String> listString = new ArrayList<>();
                listAuthors = dbHelper.getAllAuthor();
                for(Author author : listAuthors){
                    listString.add(author.getIdAuthor()+"");
                    listString.add(author.getName());
                    listString.add(author.getAddress());
                    listString.add(author.getEmail());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(AuthorActivity.this, android.R.layout.simple_list_item_1,listString);
                listview.setAdapter(adapter);
            }
        });
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> listString = new ArrayList<>();
                if(dbHelper.updateAuthor(Integer.parseInt(et_id.getText().toString()),et_name.getText().toString(),et_address.getText().toString(),et_email.getText().toString())){
                    Toast.makeText(getApplicationContext(), "UPDATE Complete", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "UPDATE FAIL", Toast.LENGTH_SHORT).show();
                }
                listAuthors = dbHelper.getAllAuthor();
                for(Author author : listAuthors){
                    listString.add(author.getIdAuthor()+"");
                    listString.add(author.getName());
                    listString.add(author.getAddress());
                    listString.add(author.getEmail());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(AuthorActivity.this, android.R.layout.simple_list_item_1,listString);
                listview.setAdapter(adapter);
            }
        });
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Author author = new Author();
                author.setIdAuthor(Integer.parseInt(et_id.getText().toString()));
                author.setName(et_name.getText().toString());
                author.setAddress(et_address.getText().toString());
                author.setEmail(et_email.getText().toString());
                if(dbHelper.insertAuthors(author) > 0) {
                    Toast.makeText(getApplicationContext(), "ban da luu thanh cong", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "luu khong thanh cong", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Author authortemp = null;
                ArrayList<String> listString = new ArrayList<>();
                ArrayList<Author> listAuthors = new ArrayList<>();
                if(et_id.getText().toString().equals("")){
                    listAuthors = dbHelper.getAllAuthor();
                }else{
                   try {
                        authortemp = dbHelper.getIdAuthor(Integer.parseInt(et_id.getText().toString()));
                   }catch (Exception e){
                       Toast.makeText(getApplicationContext(), "Khong ton tai id " +et_id.getText().toString(), Toast.LENGTH_SHORT).show();
                   }
                    if(authortemp != null){
                        listAuthors.add(authortemp);
                    }else{
                        Toast.makeText(getApplicationContext(), "Khong ton tai id " +et_id.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
                for(Author author : listAuthors){
                    listString.add(author.getIdAuthor()+"");
                    listString.add(author.getName());
                    listString.add(author.getAddress());
                    listString.add(author.getEmail());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(AuthorActivity.this, android.R.layout.simple_list_item_1,listString);
                listview.setAdapter(adapter);
            }
        });

    }
}