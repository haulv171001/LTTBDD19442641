package com.example.sqlitedemo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DepartmentActivity extends AppCompatActivity {
    AppCompatButton btInsert,btSelect,btUpdate,btDelete;
    EditText etId,etname,etlocation;
    ListView DepartmentList;
    ArrayList<Department> departmentArrayList;
    DepartmentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);
        etId = findViewById(R.id.etidDepartment);
        etname = findViewById(R.id.etNameDepartment);
        etlocation = findViewById(R.id.etlocationDepartment);
        btInsert = findViewById(R.id.buttonSave);
        btSelect = findViewById(R.id.buttonSelect);
        btUpdate = findViewById(R.id.buttonUpdate);
        btDelete = findViewById(R.id.buttonDelete);
        DepartmentList = findViewById(R.id.lv_Department);
        DbHelper dbHelper = new DbHelper(this);
        DepartmentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Department Tempdepartment = null;
                Tempdepartment = dbHelper.getIdDepartment(position+1);
                etId.setText(Tempdepartment.getId()+"");
                etname.setText(Tempdepartment.getName());
                etlocation.setText(Tempdepartment.getLocation());
            }
        });
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Department department = new Department();
                department.setId(Integer.parseInt(etId.getText().toString()));
                department.setName(etname.getText().toString());
                department.setLocation(etlocation.getText().toString());
                if(dbHelper.insertDepartment(department)>0) {
                    Toast.makeText(getApplicationContext(), "ban da luu thanh cong", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "luu khong thanh cong", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Department Tempdepartment = null;
                departmentArrayList = new ArrayList<>();
                if(etId.getText().toString().equals("")){
                    departmentArrayList = dbHelper.getAllDepartment();
                }else{
                    try{
                        Tempdepartment = dbHelper.getIdDepartment(Integer.parseInt(etId.getText().toString()));
                    }catch(Exception e){
                        Toast.makeText(getApplicationContext(), "Khong ton tai id " +etId.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                    if(Tempdepartment != null){
                        departmentArrayList.add(Tempdepartment);
                    }else{
                        Toast.makeText(getApplicationContext(), "Khong ton tai id " +etId.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
                adapter = new DepartmentAdapter(getApplicationContext(),R.layout.row_departmentitem,departmentArrayList);
                DepartmentList.setAdapter(adapter);
            }
        });
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(dbHelper.updateDepartment(Integer.parseInt(etId.getText().toString()),etname.getText().toString(),etlocation.getText().toString())){
                        Toast.makeText(getApplicationContext(), "UPDATE Complete", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "UPDATE FAIL", Toast.LENGTH_SHORT).show();
                    }
                    departmentArrayList = new ArrayList<>();
                    departmentArrayList = dbHelper.getAllDepartment();
                    adapter = new DepartmentAdapter(getApplicationContext(),R.layout.row_departmentitem,departmentArrayList);
                    DepartmentList.setAdapter(adapter);
            }
        });
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deleteDepartment(Integer.parseInt(etId.getText().toString()));
                etId.setText("");
                etname.setText("");
                etlocation.setText("");
                departmentArrayList = new ArrayList<>();
                departmentArrayList = dbHelper.getAllDepartment();
                adapter = new DepartmentAdapter(getApplicationContext(),R.layout.row_departmentitem,departmentArrayList);
                DepartmentList.setAdapter(adapter);
            }
        });
    }
}