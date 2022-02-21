package com.example.module22bai5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Employee employee = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listViewNV = findViewById(R.id.listNV);
        EditText editTextTenNV = findViewById(R.id.etTenNV);
        EditText editTextMaNV = findViewById(R.id.etMaNV);
        RadioGroup radioGroupLoaiNV = findViewById(R.id.radiogroupLoaiNV);
        Button buttonNhap = findViewById(R.id.btNhapNV);
        ArrayList<Employee> arr = new ArrayList<Employee>();
        ArrayAdapter<Employee> adapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1,arr);
        listViewNV.setAdapter(adapter);
        buttonNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radid = radioGroupLoaiNV.getCheckedRadioButtonId();
                String id = editTextMaNV.getText().toString();
                String ten = editTextTenNV.getText().toString();
                if(radid == R.id.cbFullTime){
                    employee = new EmployeeFullTime();
                }else{
                    employee = new EmployeePartTime();
                }
                employee.setId(id);
                employee.setName(ten);
                arr.add(employee);
                adapter.notifyDataSetChanged();
            }
        });

    }
}