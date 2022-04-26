package com.example.sqlitedemo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class EmployeeMainActivity extends AppCompatActivity {
    AppCompatButton btInsertEmp,btSelectEmp,btUpdateEmp,btDeleteEmp;
    EditText etId,etname,etaddress,etdeptid;
    ListView EmployeeList;
    ArrayList<Employee> EmployeeArrayList;
    EmployeeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DbHelper dbHelper = new DbHelper(this);
        setContentView(R.layout.activity_employee_main);
        btInsertEmp = findViewById(R.id.buttonSaveemp);
        btSelectEmp = findViewById(R.id.buttonSelectemp);
        EmployeeList = findViewById(R.id.lv_EMP);
        etId = findViewById(R.id.etidEmp);
        etname = findViewById(R.id.etNameEmp);
        etaddress = findViewById(R.id.etaddressEmp);
        etdeptid = findViewById(R.id.etdeptId);

        btInsertEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Employee employee = new Employee();
                employee.setId(Integer.parseInt(etId.getText().toString()));
                employee.setName(etname.getText().toString());
                employee.setAddress(etaddress.getText().toString());
                employee.setDeptId(Integer.parseInt(etdeptid.getText().toString()));
                if(dbHelper.insertEmployee(employee) > 0){
                    Toast.makeText(getApplicationContext(), "ban da luu thanh cong", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "luu khong thanh cong", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btSelectEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmployeeArrayList = new ArrayList<>();
                EmployeeArrayList = dbHelper.getAllEmployees();
                adapter = new EmployeeAdapter(getApplicationContext(),R.layout.row_employeeitem,EmployeeArrayList);
                EmployeeList.setAdapter(adapter);
            }
        });

    }
}