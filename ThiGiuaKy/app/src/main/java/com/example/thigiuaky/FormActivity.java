package com.example.thigiuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class FormActivity extends AppCompatActivity {
    Spinner spinner;
    String[] dv_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        spinner = findViewById(R.id.spinnerDonVi);
        dv_list = getResources().getStringArray(R.array.donvi_list);
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,dv_list);
        spinner.setAdapter(adapter);
    }
}