package com.example.bhathiya.questiongame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SelectionRoundResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }
        setContentView(R.layout.activity_selection_round_result);

        Intent intent = getIntent();
        int num = intent.getIntExtra("result",1);
        Log.d("Qgame", "Parse int is => "+ num);

        ImageView ResultView = findViewById(R.id.ResultView);
        Button clickButton = findViewById(R.id.button);
        if (num == 1){
            ResultView.setImageResource(R.drawable.congrtulation);
            clickButton.setBackgroundResource(R.drawable.rightbtn);
            clickButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(SelectionRoundResultActivity.this, MainGameActivity.class);
                    startActivity(i);
                }
            });
        }else if(num == 0){
            ResultView.setImageResource(R.drawable.sorry);
            clickButton.setBackgroundResource(R.drawable.closebtn);
            clickButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(SelectionRoundResultActivity.this, MainActivity.class);
                    startActivity(i);
                }

            });
        }

    }

    @Override
    public void onBackPressed(){

    }
}
