package com.example.module2bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editTextHoTen = findViewById(R.id.etHoTen);
        EditText editTextCMND = findViewById(R.id.etCmnd);
        EditText editTextThongTinBoSung = findViewById(R.id.etThongTinBoSung);
        RadioButton radioButtonTrungcap = findViewById(R.id.radiotrungcap);
        RadioButton radioButtonCaoDang = findViewById(R.id.radiocaodang);
        RadioButton radioButtonDaiHoc = findViewById(R.id.radiodaihoc);
        CheckBox checkBoxDocBao = findViewById(R.id.cbDocbao);
        CheckBox checkBoxDocSach = findViewById(R.id.cbDocsach);
        CheckBox checkBoxDocCoding = findViewById(R.id.cbDocCoding);
        Button buttonSubmit = findViewById(R.id.btsubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(KiemTraDuLieu()){
                    editTextHoTen.setText("");
                    editTextCMND.setText("");
                    radioButtonDaiHoc.setChecked(false);
                    radioButtonDaiHoc.setChecked(false);
                    radioButtonDaiHoc.setChecked(false);
                    checkBoxDocBao.setChecked(false);
                    checkBoxDocCoding.setChecked(false);
                    checkBoxDocSach.setChecked(false);
                    editTextThongTinBoSung.setText("");
                    editTextHoTen.requestFocus();
                    Toast.makeText(MainActivity.this, "Gửi Thành Công", Toast.LENGTH_SHORT).show();
                }
            }
        });
        }
        public boolean KiemTraDuLieu(){
            EditText editTextHoTen = findViewById(R.id.etHoTen);
            EditText editTextCMND = findViewById(R.id.etCmnd);
            RadioButton radioButtonTrungcap = findViewById(R.id.radiotrungcap);
            RadioButton radioButtonCaoDang = findViewById(R.id.radiocaodang);
            RadioButton radioButtonDaiHoc = findViewById(R.id.radiodaihoc);
            CheckBox checkBoxDocBao = findViewById(R.id.cbDocbao);
            CheckBox checkBoxDocSach = findViewById(R.id.cbDocsach);
            CheckBox checkBoxDocCoding = findViewById(R.id.cbDocCoding);
            if(!(editTextHoTen.getText().toString().length() > 2 && editTextHoTen.getText().toString() != "" )){
                editTextHoTen.setText("");
                editTextHoTen.requestFocus();
                Toast.makeText(MainActivity.this, "Tên phải có ít nhất 3 ký tự và không được để trống", Toast.LENGTH_SHORT).show();
                return false;

            }
            if(!(Pattern.matches("^[0-9]{9}",editTextCMND.getText().toString()))){
                editTextCMND.setText("");
                editTextCMND.requestFocus();
                Toast.makeText(MainActivity.this, "CMND chỉ được nhập số và có ít nhất 9 số", Toast.LENGTH_SHORT).show();
                return false;
            }
            if(!(checkBoxDocBao.isChecked() || checkBoxDocSach.isChecked() || checkBoxDocCoding.isChecked())){
                Toast.makeText(MainActivity.this, "Sở thích phải chọn ít nhất một", Toast.LENGTH_SHORT).show();
                return false;
            }
            return  true;
        }
}