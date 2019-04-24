package com.example.bhathiya.questiongame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }
        setContentView(R.layout.activity_main_game);
    }
}
