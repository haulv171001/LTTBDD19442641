package com.example.module2bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editTextDoC = findViewById(R.id.etdoC);
        EditText editTextDoF = findViewById(R.id.etdoF);
        Button buttonDoC = findViewById(R.id.btDoC);
        Button buttonDoF = findViewById(R.id.btDoF);
        Button buttonClear = findViewById(R.id.btclear);

        buttonDoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double DoF = Double.parseDouble(editTextDoF.getText().toString());
                Double chuyendoidoC = (DoF - 32) * 5/9;
                editTextDoC.setText(chuyendoidoC+"");
            }
        });
        buttonDoF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double DoC = Double.parseDouble(editTextDoC.getText().toString());
                Double chuyendoidoF = DoC * 9/5 +32;
                editTextDoF.setText(chuyendoidoF+"");
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextDoC.setText("");
                editTextDoF.setText("");
            }
        });
    }
}