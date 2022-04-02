package com.example.fragmenttestdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements TruyenProduct {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void DataProduct(Product product) {
        Fragment2 fragment2 = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.detailFragment);

        Configuration configuration = getResources().getConfiguration();

        if(fragment2 != null && configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            fragment2.setProduct(product);
        }else {
            Intent intent = new Intent(this,MainActivity2.class);
            intent.putExtra("ThongTinSanPham",product);
            startActivity(intent);
        }
    }
}