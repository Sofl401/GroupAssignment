package com.example.cocktailWizard.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cocktailWizard.R;

public class CategoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_activity);

        Intent intent = getIntent();
        final String catLink = intent.getStringExtra("category");
        System.out.println(catLink);

    }
}
