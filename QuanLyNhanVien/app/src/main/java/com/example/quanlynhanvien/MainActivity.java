package com.example.quanlynhanvien;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final int TAKE_PHOTO = 123;
    final int CHOOSE_PHOTO = 321;
    RadioButton nam,nu;
    ImageView imageViewAvatar;
    EditText editTextmaNV,editTexttenNV;
    RadioGroup genderGroup;
    Spinner spinnerdonvi;
    ListView listView;
    ArrayList<NhanVien> list;
    String[] dv_list;
    String donvi;
    Button buttonThoat,buttonThem,buttonXoa,buttonSua,buttonchonanh,buttonchupanh;
    AdapterNhanVien adapterNhanVien;
    int vitrinhanvien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lv_row_item);
        dv_list = getResources().getStringArray(R.array.donvi_list);
        spinnerdonvi = findViewById(R.id.spinnerdonvi);
        buttonThem = findViewById(R.id.buttonThem);
        editTextmaNV = findViewById(R.id.editmaNV);
        editTexttenNV = findViewById(R.id.edittexttenNV);
        genderGroup = findViewById(R.id.gropradiogioitinh);
        buttonThoat = findViewById(R.id.btnThoat);
        buttonThem = findViewById(R.id.buttonThem);
        buttonXoa = findViewById(R.id.buttonXoa);
        buttonSua = findViewById(R.id.buttonSua);
        buttonchonanh = findViewById(R.id.buttonChonAnh);
        buttonchupanh = findViewById(R.id.buttonchupAnh);
        imageViewAvatar = findViewById(R.id.imageView);
         nam = findViewById(R.id.radioButtonNam);
         nu = findViewById(R.id.radioButtonNu);
        list = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,dv_list);
        spinnerdonvi.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        view.setSelected(true);
                        NhanVien nv = list.get(position);
                        Bitmap bitmap = BitmapFactory.decodeByteArray(nv.getAnh(),0,nv.getAnh().length);
                        imageViewAvatar.setImageBitmap(bitmap);
                        editTextmaNV.setText(nv.getMaNhanVien());
                        editTexttenNV.setText(nv.getTenNhanVien());
                        if(genderGroup.getCheckedRadioButtonId() == R.id.radioButtonNu){
                            nu.isChecked();
                        }else{
                            nam.isChecked();
                        }
                        spinnerdonvi.setSelection(position);
                        vitrinhanvien = position;
            }
        });
        spinnerdonvi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                donvi = dv_list[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        buttonSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NhanVien nv = list.get(vitrinhanvien);
                byte[] anh = getByteArrayFromImageView(imageViewAvatar);
                nv.setAnh(anh);
                nv.setMaNhanVien(editTextmaNV.getText().toString());
                nv.setTenNhanVien(editTexttenNV.getText().toString());
                nv.setGioitinh(((RadioButton)findViewById(genderGroup.getCheckedRadioButtonId())).getText().toString());
                nv.setDonvi(donvi);
                adapterNhanVien.notifyDataSetChanged();
            }
        });
        buttonchonanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePhoTo();
            }
        });
        buttonchupanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePhoTo();
            }
        });
        buttonThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gioitinh;
                String manv = editTextmaNV.getText().toString();
                String tennv = editTexttenNV.getText().toString();
                gioitinh = ((RadioButton)findViewById(genderGroup.getCheckedRadioButtonId())).getText().toString();
                byte[] anh = getByteArrayFromImageView(imageViewAvatar);
                NhanVien nhanVien = new NhanVien(manv,tennv,gioitinh,donvi,anh);
                list.add(nhanVien);
                adapterNhanVien = new AdapterNhanVien(MainActivity.this,list);
                listView.setAdapter(adapterNhanVien);
                imageViewAvatar.setImageBitmap(null);
                editTextmaNV.setText("");
                editTexttenNV.setText("");
                if(genderGroup.getCheckedRadioButtonId() == R.id.radioButtonNu){
                    nu.setChecked(false);
                }else{
                    nam.setChecked(false);
                }
                spinnerdonvi.setSelection(0);
            }
        });
        buttonXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    list.remove(vitrinhanvien);
                    imageViewAvatar.setImageBitmap(null);
                    editTextmaNV.setText("");
                    editTexttenNV.setText("");
                    if(genderGroup.getCheckedRadioButtonId() == R.id.radioButtonNu){
                        nu.setChecked(false);
                    }else{
                        nam.setChecked(false);
                    }
                    spinnerdonvi.setSelection(0);
                    adapterNhanVien.notifyDataSetChanged();
            }
        });
        buttonThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void takePhoTo(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,TAKE_PHOTO);
    }
    private void choosePhoTo(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,CHOOSE_PHOTO);
    }
    private byte[] getByteArrayFromImageView(ImageView imageView){
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] byteArray = stream.toByteArray();
        return  byteArray;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CHOOSE_PHOTO) {
            Uri imageUri = data.getData();
            try {
                InputStream is = getContentResolver().openInputStream(imageUri);
                Bitmap bitmap = BitmapFactory.decodeStream(is);
                imageViewAvatar.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else if (requestCode == TAKE_PHOTO) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageViewAvatar.setImageBitmap(bitmap);
        }
    }
}