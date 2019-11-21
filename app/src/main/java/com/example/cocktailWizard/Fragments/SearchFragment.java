package com.example.cocktailWizard.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cocktailWizard.Activities.SearchActivity;
import com.example.cocktailWizard.Adapters.CategoryAdapter;
import com.example.cocktailWizard.R;

import java.util.Arrays;
import java.util.List;

public class SearchFragment extends Fragment {
    private RecyclerView recyclerView;
    private SearchView searchView;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // add r.id.textviews/buttons etc.
        View view = inflater.inflate(R.layout.categories_rv, container, false);
        recyclerView = view.findViewById(R.id.catRv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);


        List<String> categories = Arrays.asList("Ordinary Drink", "Cocktail", "Milk / Float / Shake","Cocoa",
                "Shot", "Coffee / Tea", "Homemade Liqueur", "Punch / Party Drink", "Beer", "Soft Drink / Soda", "Other/Unknown");

        CategoryAdapter categoryAdapter = new CategoryAdapter();
        categoryAdapter.setData(categories);
        recyclerView.setAdapter(categoryAdapter);

        searchView = view.findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                sendMessage(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return view;

    }
    private void sendMessage(CharSequence query){
        Intent intent = new Intent(getContext(), SearchActivity.class);
        intent.putExtra("query", query);
        startActivity(intent);
    }
    //setup Async/Adapters


}




