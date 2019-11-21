package com.example.cocktailWizard.Quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cocktailWizard.Activities.QuizResult;
import com.example.cocktailWizard.MainActivity;
import com.example.cocktailWizard.R;

public class QuizActivity extends AppCompatActivity {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();
    private RandomSequenceGenerator rsg = new RandomSequenceGenerator();
    private final int maxQuesToDisplay = 10;

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button backBtn;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    private Integer[] randomSeq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        randomSeq = rsg.getNextRandomSeq(maxQuesToDisplay);

        mScoreView = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        backBtn = (Button)findViewById(R.id.quit);

        updateQuestion();

        //Start of Button Listener for Button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice1.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optional
                    Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(QuizActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button1

        //Start of Button Listener for Button2
        mButtonChoice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice2.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optional
                    Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(QuizActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button2


        //Start of Button Listener for Button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice3.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optional
                    Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(QuizActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button3


        //Start of Button listener for Quit

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });

    }

    private void updateQuestion(){
        if(mQuestionNumber < maxQuesToDisplay){
            int questionIndex = getQuestionIndex();
            mQuestionView.setText(mQuestionLibrary.getQuestion(questionIndex));
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(questionIndex));
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(questionIndex));
            mButtonChoice3.setText(mQuestionLibrary.getChoice3(questionIndex));

            mAnswer = mQuestionLibrary.getCorrectAnswer(questionIndex);
            mQuestionNumber++;
        }else{
            Intent intent = new Intent(getApplicationContext(), QuizResult.class);
            String mark = Integer.toString(mScore);
            intent.putExtra("mark", mark);
            startActivity(intent);

            QuizActivity.this.finish();

        }
    }


    private int getQuestionIndex(){
        int questionIndex = randomSeq[mQuestionNumber];
        return questionIndex;
    }


    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }

}

