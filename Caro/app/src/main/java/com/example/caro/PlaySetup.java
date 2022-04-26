package com.example.caro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PlaySetup extends AppCompatActivity {
    private EditText player1,player2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_setup);
        player1 = findViewById(R.id.player1Name);
        player2 = findViewById(R.id.player2Name);
    }
    public  void submitButtonClick(View view){
        String player1Name = player1.getText().toString();
        String player2Name = player2.getText().toString();

        Intent intent = new Intent(this,GameDisPlay.class);
        intent.putExtra("PLAYER_NAMES",new String[]{player1Name,player2Name});
        startActivity(intent);
    }
}