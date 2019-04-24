package com.example.bhathiya.questiongame;

import android.content.Intent;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SelectionRoundActivity extends AppCompatActivity {
    public String [] orderdAnswers;
    public ArrayList<String> ClickedAnsArray = new ArrayList<String>();
    public List <String> changeAnswers = new ArrayList<String>();
    String question ;
    String answer1 ;
    String answer2 ;
    String answer3 ;
    String answer4;
    public int RandomId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }
        setContentView(R.layout.activity_selection_round);

        final TextView txtQuestion = findViewById(R.id.txt_question);
        final Button selectAns1 = findViewById(R.id.selectAns1);
        final Button selectAns2 = findViewById(R.id.selectAns2);
        final Button selectAns3 = findViewById(R.id.selectAns3);
        final Button selectAns4 = findViewById(R.id.selectAns4);
        final Button btnNext = findViewById(R.id.btnNext);


        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("selectionRound")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            RandomId = new Random().nextInt(task.getResult().size()) + 1;
                            Log.d("id", " " + RandomId);// get random no of id in the database
                            Log.d("Qgame", "Number is => " + RandomId);
                            DocumentReference docRef = db.collection("selectionRound").document(String.valueOf(RandomId));
                            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                    if(task.isSuccessful()){
                                        DocumentSnapshot document = task.getResult();
                                        if (document.exists()){
//                                          Get data from database
                                            question = (String) document.get("question");
                                            answer1 = (String) document.get("answer1");
                                            answer2 = (String) document.get("answer2");
                                            answer3 = (String) document.get("answer3");
                                            answer4 = (String) document.get("answer4");
//                                          set oreder of answers as a array and change the order
                                            orderdAnswers = new String[]{answer1, answer2, answer3, answer4};

//                                            changeAnswers = Arrays.asList(orderdAnswers);
                                            changeAnswers.add(answer1);
                                            changeAnswers.add(answer2);
                                            changeAnswers.add(answer3);
                                            changeAnswers.add(answer4);
                                            Collections.shuffle(changeAnswers);

//                                            Assign Element in UI
                                            Log.d("Qgame", "testing => "+ orderdAnswers[0]);

                                            txtQuestion.setText(question);
                                            selectAns1.setText((String) changeAnswers.toArray()[0]);
                                            selectAns2.setText((String) changeAnswers.toArray()[1]);
                                            selectAns3.setText((String) changeAnswers.toArray()[2]);
                                            selectAns4.setText((String) changeAnswers.toArray()[3]);

                                        }else{
                                            Log.d("Qgame", "Error in document");
                                        }


                                    }else{
                                        Log.d("Qgame", "Error in task");
                                    }
                                }
                            });
                        }else{
                            Log.d("Qgame", "Error in task");
                        }


                    }

                });

        final int[] StateBtn1 = {0};
        final int[] StateBtn2 = {0};
        final int[] StateBtn3 = {0};
        final int[] StateBtn4 = {0};

//          Button 1
        selectAns1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectAns1.setBackgroundResource(R.drawable.yellowbuttons);
                Button b = (Button)v;
                String TxtselectAns1= b.getText().toString();
                if (StateBtn1[0] == 0){
                    ClickedAnsArray.add(TxtselectAns1);
                    Log.d("Qgame", "buttom click=> " + ClickedAnsArray);
                    StateBtn1[0] =1;
                }

            }
        });

//        Button 2
        selectAns2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectAns2.setBackgroundResource(R.drawable.yellowbuttons);
                Button b = (Button)v;
                String TxtselectAns2= b.getText().toString();
                if (StateBtn2[0] == 0){
                    ClickedAnsArray.add(TxtselectAns2);
                    Log.d("Qgame", "buttom click=> " + ClickedAnsArray);
                    StateBtn2[0] =1;
                }

            }
        });

//        Button 3
        selectAns3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectAns3.setBackgroundResource(R.drawable.yellowbuttons);
                Button b = (Button)v;
                String TxtselectAns3= b.getText().toString();
                if (StateBtn3[0] == 0){
                    ClickedAnsArray.add(TxtselectAns3);
                    Log.d("Qgame", "buttom click=> " + ClickedAnsArray);
                    StateBtn3[0] =1;
                }

            }
        });

//        Button 4
        selectAns4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectAns4.setBackgroundResource(R.drawable.yellowbuttons);
                Button b = (Button)v;
                String TxtselectAns4= b.getText().toString();
                if (StateBtn4[0] == 0){
                    ClickedAnsArray.add(TxtselectAns4);
                    Log.d("Qgame", "buttom click=> " + ClickedAnsArray);
                    StateBtn4[0] =1;
                }

            }
        });


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String [] ClickedAnswer = ClickedAnsArray.toArray(new String [ClickedAnsArray.size()]);
                if (orderdAnswers[0] == ClickedAnswer[0] && orderdAnswers[1] == ClickedAnswer[1] && orderdAnswers[2] == ClickedAnswer[2] && orderdAnswers[3] == ClickedAnswer[3]){
                    Log.d("Qgame", "You selected for the game =>" );
                    Intent selectionRoundResult = new Intent(SelectionRoundActivity.this, SelectionRoundResultActivity.class);
                    selectionRoundResult.putExtra("result", 1); // win is 1
                    startActivity(selectionRoundResult);

                }else {
                    Log.d("Qgame", "You Loss => "+ orderdAnswers[0] + orderdAnswers[1]);
                    Intent selectionRoundResult = new Intent(SelectionRoundActivity.this, SelectionRoundResultActivity.class);
                    selectionRoundResult.putExtra("result", 0); // win is 1
                    startActivity(selectionRoundResult);

                }
            }
        });







    }
}