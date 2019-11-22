package com.example.cocktailWizard.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cocktailWizard.MainActivity;
import com.example.cocktailWizard.Model.Mark;
import com.example.cocktailWizard.Quiz.QuestionLibrary;
import com.example.cocktailWizard.Quiz.RandomSequenceGenerator;
import com.example.cocktailWizard.R;

import java.util.ArrayList;

// quiz ideas taken from https://www.youtube.com/watch?v=PiCZQg4mhBQ and https://www.youtube.com/watch?v=JA9s_Fntg_4

public class QuizActivity extends AppCompatActivity {
    public ArrayList<Mark> eResults;


    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();
    private RandomSequenceGenerator rsg = new RandomSequenceGenerator();
    private final int maxQuesToDisplay = 11;

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button backBtn;

    private String mAnswer;
    private int count = 1;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    private Integer[] randomSeq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        eResults = new ArrayList<Mark>();
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
                boolean choice;
                if (mButtonChoice1.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    choice = true;
                    Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(QuizActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                    choice = false;
                }
                updateQuestion();
                eResults.add(new Mark(count,mAnswer, mButtonChoice1.getText().toString(), choice));
                count++;
            }
        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                boolean choice2;

                if (mButtonChoice2.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                    choice2 = true;

                }else {
                    Toast.makeText(QuizActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                    choice2 = false;
                }
                updateQuestion();
                eResults.add(new Mark(count,mAnswer, mButtonChoice2.getText().toString(), choice2));
                count++;

            }
        });

        //End of Button Listener for Button2


        //Start of Button Listener for Button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                boolean choice3;

                if (mButtonChoice3.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    choice3 = true;
                    Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(QuizActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                    choice3 = false;
                }
                updateQuestion();
                eResults.add(new Mark(count,mAnswer, mButtonChoice3.getText().toString(),choice3));
                count++;
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
            QuizResult quizResult = new QuizResult();
            quizResult.setData(eResults);
            intent.putExtra("eResults", eResults);
            String mark = Integer.toString(mScore);
            intent.putExtra("mark", mark);
            startActivity(intent);



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

