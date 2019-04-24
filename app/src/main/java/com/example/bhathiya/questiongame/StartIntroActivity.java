package com.example.bhathiya.questiongame;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StartIntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            this.getSupportActionBar().hide();
        }catch (NullPointerException e){}
        setContentView(R.layout.activity_start_intro);


        final int[] count = {0};
        final ImageView img_talkBuble = findViewById(R.id.img_talkbubble);
        final TextView txt_talk = findViewById(R.id.txt_talk);
        final String[] paragraph = {
                "ආයුබෝවන් !!! මේ ඔබ රුඳී සිටින්නේ සල්ලිපති වැඩසටහන සමගයි",
                "පලමුව තිබෙන්නේ Hot seat එකට තෝරාගැනීමේ වටයයි",
                "මේ සඳහා ඔබට ලැබෙන පැනයට පිලිතුරු තත්පර 30 ක් ඇතුලත පිලිවෙලට සකසන්න "
        };

//        Next button set
        final Button next_btn = findViewById(R.id.btn_next);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( count[0] != 3){
                    txt_talk.setText(paragraph[count[0]]);
                    count[0] = count[0] +1;
                }else{
                    Intent selectionRound = new Intent(StartIntroActivity.this, SelectionRoundActivity.class);
                    startActivity(selectionRound);
                }
            }
        });



        img_talkBuble.setVisibility(View.INVISIBLE);
        txt_talk.setVisibility(View.INVISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                img_talkBuble.setVisibility(View.VISIBLE);
                txt_talk.setVisibility(View.VISIBLE);
            }
        },1000);
    }
}
