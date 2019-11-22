package com.example.cocktailWizard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.cocktailWizard.Fragments.QuizFragment;
import com.example.cocktailWizard.Fragments.RandomFragment;
import com.example.cocktailWizard.Fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    // Swap Fragment code taken from tutorial

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RandomFragment randomFragment = new RandomFragment();
        final SearchFragment searchFragment = new SearchFragment();
        final QuizFragment quizFragment = new QuizFragment();


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.search){
                    swapFragment(searchFragment);
                }
                else if (menuItem.getItemId() == R.id.quiz){
                    swapFragment(quizFragment);
                }
                else if (menuItem.getItemId() == R.id.random){
                    swapFragment(randomFragment);
                }
                return true;
            }
        });

    }

    private void swapFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentSlot, fragment);
        fragmentTransaction.commit();
    }

}
