package com.example.imgview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
            ArrayList<LaBai> CacLaDaRut = new ArrayList<LaBai>();
            ArrayList<LaBai> CacLaBai = new ArrayList<LaBai>();// ds cac la bai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv1 = findViewById(R.id.imgView1);
        ImageView iv2 = findViewById(R.id.imgView2);
        ImageView iv3 = findViewById(R.id.imgView3);
        Button btnRutBai = findViewById(R.id.btnrutbai);
        TextView textViewKq = findViewById(R.id.tvKQ);

        btnRutBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[]balabai = Lay3SoNgauNhien(0,51);
                iv1.setImageResource(manghinhbai[balabai[0]]);
                iv2.setImageResource(manghinhbai[balabai[1]]);
                iv3.setImageResource(manghinhbai[balabai[2]]);
                textViewKq.setText(tinhketqua(balabai));
            }
        });

    }
    //lay ba so ngau nhien
    private int[] Lay3SoNgauNhien(int min,int max){
        int[] baso = new int[3];
        int i = 0;
        baso[i++] = random(min,max);
        do{
            int k = random(min,max);
            if(!kiemtraTrung(k,baso));
                baso[i++] = k;

        }while(i < 3);
        return baso;
    }
    //Ham Kiem tra trung
    private boolean kiemtraTrung(int k ,int[]arr){
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == k){
                return true;
            }
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
            ketqua = "Kết quả 3 tây";
        else{
            int tong = 0;
            for(int i=0;i<arr.length;i++)
                if(arr[i] % 13 < 10)
                    tong += arr[i] % 13 + 1;
            if(tong % 10 == 0){
                ketqua = "Kết quả bù,số tây là "+tinhsoTay(arr);
            }else{
                ketqua = "Kết quả"+(tong%10)+"nút,số tây là" + tinhsoTay(arr);
            }
        }
        return ketqua;
    }
    //
    private int tinhsoTay(int[]arr){
        int  k= 0;
        for(int i = 0 ; i < arr.length;i++)
            if (arr[i] % 13 >= 10 && arr[i] > 10) {
                k++;
            }
        return k;
    }
}