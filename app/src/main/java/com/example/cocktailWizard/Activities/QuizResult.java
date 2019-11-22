package com.example.cocktailWizard.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cocktailWizard.MainActivity;
import com.example.cocktailWizard.Model.Mark;
import com.example.cocktailWizard.R;

import java.util.ArrayList;

// code to pass ArrayList as intent taken from https://stackoverflow.com/questions/21250339/how-to-pass-arraylistcustomeobject-from-one-activity-to-another
// code to close activity taken from https://stackoverflow.com/questions/15393899/how-to-close-activity-and-go-back-to-previous-activity-in-android
public class QuizResult extends AppCompatActivity {
    TextView mGrade;
    TextView mFinalScore;
    Button mRetryButton;
    Button exitbutton;
    TextView text;
    public ArrayList<Mark> eResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_result);

        eResults = new ArrayList<Mark>();

        mGrade = (TextView)findViewById(R.id.grade);
        mFinalScore = (TextView)findViewById(R.id.outOf);
        mRetryButton = (Button)findViewById(R.id.retry);
        exitbutton = (Button) findViewById(R.id.exitbtn);
        text = findViewById(R.id.answers);

        Intent intent = getIntent();
        String mark = intent.getStringExtra("mark");
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

        text.setText(" ");

        ArrayList<Mark> eResults = (ArrayList<Mark>)getIntent().getSerializableExtra("eResults");
        String answer;
        text.append("Your results for the quiz!");
        for (int i = 0; i < eResults.size(); i++){
            if (eResults.get(i).isCorrectA()){
                answer = "Correct: ";
            }
            else {
                answer = "Incorrect: ";
            }
                text.append("\n " + eResults.get(i).getnQuestion() + ". " + answer + " " +
                        eResults.get(i).getAnswer());

        }

        mRetryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizResult.this, QuizActivity.class));
                QuizResult.this.finish();
            }
        });

        exitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizResult.this, MainActivity.class));
            }
        });



    }
    public void setData(ArrayList<Mark> eResults){
        this.eResults = eResults;
    }

}
