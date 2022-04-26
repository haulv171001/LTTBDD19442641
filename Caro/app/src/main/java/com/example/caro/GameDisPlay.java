package com.example.caro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameDisPlay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_dis_play);
    }
    public  void playAgainButtonClick(View view){

    }
    public void homeButtonClick(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}