package com.example.cocktailWizard.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cocktailWizard.Quiz.QuestionLibrary;
import com.example.cocktailWizard.Quiz.QuizActivity;
import com.example.cocktailWizard.R;


public class QuizResult extends AppCompatActivity {
    TextView mGrade;
    TextView mFinalScore;
    Button mRetryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_result);

        mGrade = (TextView)findViewById(R.id.grade);
        mFinalScore = (TextView)findViewById(R.id.outOf);
        mRetryButton = (Button)findViewById(R.id.retry);

        Intent intent = getIntent();
        String mark = intent.getStringExtra("mark");
        System.out.println(mark);
        int score = Integer.valueOf(mark);

        mFinalScore.setText("You scored " + score + " out of 10");

        if (score == 9){
            mGrade.setText("Outstanding");
        }else if (score == 8){
            mGrade.setText("Good Work");
        }else if (score == 7) {
            mGrade.setText("Good Effort");
        }else {
            mGrade.setText("Go through the cocktails again!");
        }

        mRetryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizResult.this, QuizActivity.class));
                QuizResult.this.finish();
            }
        });







    }}
