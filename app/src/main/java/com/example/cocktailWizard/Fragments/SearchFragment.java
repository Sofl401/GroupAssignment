package com.example.cocktailWizard.Fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cocktailWizard.Adapters.CategoryAdapter;
import com.example.cocktailWizard.DrinksApi;
import com.example.cocktailWizard.Model.Category;
import com.example.cocktailWizard.R;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchFragment extends Fragment {
    private RecyclerView recyclerView;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // add r.id.textviews/buttons etc.
        View view = inflater.inflate(R.layout.categories_rv, container, false);
        recyclerView = view.findViewById(R.id.catRv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);


        List<String> categories = Arrays.asList("Ordinary Drink", "Cocktail", "Milk / Float / Shake","Cocoa",
                "Shot", "Coffee", "Homemade Liqueur", "Punch / Party Drink", "Beer", "Soft Drink / Soda", "Other/Unknown");

        CategoryAdapter categoryAdapter = new CategoryAdapter();
        categoryAdapter.setData(categories);
        recyclerView.setAdapter(categoryAdapter);

        return view;

    }
    //setup Async/Adapters


}




