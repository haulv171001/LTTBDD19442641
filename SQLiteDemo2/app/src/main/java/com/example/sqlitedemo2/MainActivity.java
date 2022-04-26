package com.example.sqlitedemo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    AppCompatButton btCallDepartment,btCallEmployee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btCallDepartment = findViewById(R.id.buttonCallDepartment);
        btCallEmployee = findViewById(R.id.buttonCallEmployee);
        btCallDepartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DepartmentActivity.class);
                startActivity(intent);
            }
        });
        btCallEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,EmployeeMainActivity.class);
                startActivity(intent);
            }
        });
    }
}