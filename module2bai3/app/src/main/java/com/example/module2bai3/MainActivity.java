package com.example.module2bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editTextNam = findViewById(R.id.etNamduonglich);
        Button buttonChuyendoi = findViewById(R.id.btChuyenDoi);
        TextView textViewKQ = findViewById(R.id.tvNamamlich);


        buttonChuyendoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String can = "",chi = "";
                int namduong = Integer.parseInt(editTextNam.getText().toString());

                if(namduong < 1900) {
                    Toast.makeText(MainActivity.this, "Nhập sai ! Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                    editTextNam.setText("");
                }else {

                    switch (namduong%10){
                        case 0: can = "Canh";break;
                        case 1: can = "Tân";break;
                        case 2: can = "Nhâm";break;
                        case 3: can = "Quý";break;
                        case 4: can = "Giáp";break;
                        case 5: can = "Ất";break;
                        case 6: can = "Bính";break;
                        case 7: can = "Đinh";break;
                        case 8: can = "Mậu";break;
                        case 9: can = "Kỷ";
                            break;
                        default:
                            break;

                    }
                    switch (namduong%12){
                        case 0: chi = "Thân";break;
                        case 1: chi = "Dậu";break;
                        case 2: chi = "Tuất";break;
                        case 3: chi = "Hợi";break;
                        case 4: chi = "Tý";break;
                        case 5: chi = "Sửu";break;
                        case 6: chi = "Dần";break;
                        case 7: chi = "Mẹo";break;
                        case 8: chi = "Thìn";break;
                        case 9: chi = "Tỵ";break;
                        case 10: chi = "Ngọ";break;
                        case 11: chi = "Mùi";break;
                        default:
                            break;

                    }
                }

                textViewKQ.setText(can+" "+chi);
            }
        });
    }
}