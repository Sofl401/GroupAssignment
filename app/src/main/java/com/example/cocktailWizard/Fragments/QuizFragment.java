package com.example.cocktailWizard.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.cocktailWizard.Quiz.QuizActivity;
import com.example.cocktailWizard.R;

public class QuizFragment extends Fragment {
    Button startQuiz;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.quiz_fragment, container, false);

        startQuiz = view.findViewById(R.id.startQuiz);

        startQuiz.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), QuizActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
