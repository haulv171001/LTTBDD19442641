package com.example.baicao;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int manghinhbai[]={
            R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
            R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,
            R.drawable.cj,R.drawable.cq,R.drawable.ck,
            R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,
            R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,
            R.drawable.dj,R.drawable.dq,R.drawable.dk,
            R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,
            R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,
            R.drawable.hj,R.drawable.hq,R.drawable.hk,
            R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,
            R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,
            R.drawable.sj,R.drawable.sq,R.drawable.sk};
    ArrayList<String> arr = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textViewDiemCuaMay = findViewById(R.id.tvDiemCuaMay);
        TextView textViewDiemCuaBan = findViewById(R.id.tvDiemCuaBan);
        TextView textViewKetQua = findViewById(R.id.tvKetQua);
        Button buttonPlay = findViewById(R.id.btnPlay);
        Button buttonAutoPlay = findViewById(R.id.btnAutoPlay);
        EditText editTextTime = findViewById(R.id.etTime);
        ImageView iv1 = findViewById(R.id.imgView1);
        ImageView iv2 = findViewById(R.id.imgView2);
        ImageView iv3 = findViewById(R.id.imgView3);
        ImageView iv4 = findViewById(R.id.imgView4);
        ImageView iv5 = findViewById(R.id.imgView5);
        ImageView iv6 = findViewById(R.id.imgView6);
        Context context = this;
        ListView listView = new ListView(context);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arr);
        listView.setAdapter(adapter);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Lịch Sử");
        builder.setPositiveButton("Trở lại", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setCancelable(true);
        builder.setView(listView);

        final AlertDialog dialog = builder.create();
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play();
            }
        });
        buttonAutoPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int t = Integer.parseInt(editTextTime.getText().toString());
                CountDownTimer countDownTimer = new CountDownTimer(t*1000+100,1500) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        Play();
                        arr.add(textViewKetQua.getText().toString());
                    }

                    @Override
                    public void onFinish() {
                    dialog.show();

                    }
                }.start();
            }
        });
    }
    //
    void Play(){
        TextView textViewDiemCuaMay = findViewById(R.id.tvDiemCuaMay);
        TextView textViewDiemCuaBan = findViewById(R.id.tvDiemCuaBan);
        TextView textViewKetQua = findViewById(R.id.tvKetQua);
        Button buttonPlay = findViewById(R.id.btnPlay);
        Button buttonAutoPlay = findViewById(R.id.btnAutoPlay);
        EditText editTextTime = findViewById(R.id.etTime);
        ImageView iv1 = findViewById(R.id.imgView1);
        ImageView iv2 = findViewById(R.id.imgView2);
        ImageView iv3 = findViewById(R.id.imgView3);
        ImageView iv4 = findViewById(R.id.imgView4);
        ImageView iv5 = findViewById(R.id.imgView5);
        ImageView iv6 = findViewById(R.id.imgView6);
        int[]balaCuaBan = new int[3];
        int[]balaCuaMay = new int[3];
        int[]balabai = Lay3SoNgauNhien(0,51);
        iv1.setImageResource(manghinhbai[balabai[0]]);
        iv2.setImageResource(manghinhbai[balabai[1]]);
        iv3.setImageResource(manghinhbai[balabai[2]]);
        iv4.setImageResource(manghinhbai[balabai[3]]);
        iv5.setImageResource(manghinhbai[balabai[4]]);
        iv6.setImageResource(manghinhbai[balabai[5]]);
        balaCuaMay[0] = balabai[0];
        balaCuaMay[1] = balabai[1];
        balaCuaMay[2] = balabai[2];
        balaCuaBan[0] = balabai[3];
        balaCuaBan[1] = balabai[4];
        balaCuaBan[2] = balabai[5];
        textViewKetQua.setGravity(Gravity.CENTER);
        if(tinhketqua(balaCuaMay).toString().equalsIgnoreCase(tinhketqua(balaCuaBan).toString())){
            textViewKetQua.setText("Hòa");
        }else if(tinhketqua(balaCuaMay).toString().equalsIgnoreCase("3 tây")){
            textViewKetQua.setText("Máy Thắng");
        }else if(tinhketqua(balaCuaBan).toString().equalsIgnoreCase("3 tây")){
            textViewKetQua.setText("Bạn Thắng");
        }else if(tinhketqua(balaCuaMay).toString().equalsIgnoreCase("bù") && !(tinhketqua(balaCuaBan).toString().equalsIgnoreCase("bù"))){
            textViewKetQua.setText("Bạn Thắng");
        }else if(tinhketqua(balaCuaBan).toString().equalsIgnoreCase("bù") && !(tinhketqua(balaCuaMay).toString().equalsIgnoreCase("bù"))){
            textViewKetQua.setText("Máy Thắng");
        }else
        {
            int sonutcuaBan = Integer.parseInt(tinhketqua(balaCuaBan));
            int sonutcuaMay = Integer.parseInt(tinhketqua(balaCuaMay));
            if(sonutcuaBan>sonutcuaMay){
                textViewKetQua.setText("Bạn Thắng");
            }else{
                textViewKetQua.setText("Máy Thắng");
            }
        }
        textViewDiemCuaMay.setText(tinhketqua(balaCuaMay));
        textViewDiemCuaBan.setText(tinhketqua(balaCuaBan));
    }
    //lay ba so ngau nhien
    private int[] Lay3SoNgauNhien(int min,int max){
        int[] baso = new int[6];
        int i = 0;
        baso[i++] = random(min,max);
        do{
            int k = random(min,max);
            if(!kiemtraTrung(k,baso));
            baso[i++] = k;

        }while(i < 6);
        return baso;
    }
    //Ham Kiem tra trung
    private boolean kiemtraTrung(int k ,int[]arr){
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == k){
                return true;
            }
            return false;
        }
        return false;
    }
    // Ham random
    private int random(int min,int max){
        return min + (int)(Math.random()*((max-min)+1));
    }
    //
    private String tinhketqua(int[] arr){
        String ketqua = "";
        if(tinhsoTay(arr)==3)
            ketqua = "3 tây";
        else{
            int tong = 0;
            for(int i=0;i<arr.length;i++)
                if(arr[i] % 13 < 10)
                    tong += arr[i] % 13 + 1;
            if(tong % 10 == 0){
                ketqua = "bù";
            }else{
                ketqua = (tong%10)+"";
            }
        }
        return ketqua;
    }
    //
    private int tinhsoTay(int[]arr){
        int  k= 0;
        for(int i = 0 ; i < arr.length;i++)
            if (arr[i] % 13 >= 10) {
                k++;
            }
        return k;
    }
}