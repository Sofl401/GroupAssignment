package com.example.cocktailWizard.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.cocktailWizard.Adapters.SpecificCategoryAdapter;
import com.example.cocktailWizard.Model.Drinks;
import com.example.cocktailWizard.R;
import com.google.gson.Gson;

// Volley Example used here https://www.youtube.com/watch?v=y2xtLqP8dSQ and adapted
// https://www.youtube.com/watch?v=KlylC2rgAWM search view fragment example taken from here
// Searchview with recycler code adapted from https://www.youtube.com/watch?v=sJ-Z9G0SDhc

public class SpecificCategoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_activity);
        recyclerView  = findViewById(R.id.sCatRv);
        searchView = findViewById(R.id.searchView2);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Intent intent = getIntent();
        final String catLink = intent.getStringExtra("category");
        getVolley(catLink);

        searchView = findViewById(R.id.searchView2);
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

    }
    private void getVolley(String category){
        final SpecificCategoryAdapter sCategoryAdapter = new SpecificCategoryAdapter();

        final RequestQueue requestQueue =  Volley.newRequestQueue(this);
        String url = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?c="+category;

        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Drinks drinkList = gson.fromJson(response, Drinks.class);
                sCategoryAdapter.setData(drinkList.results);
                recyclerView.setAdapter(sCategoryAdapter);
                requestQueue.stop();
            }
        };
        com.android.volley.Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                requestQueue.stop();
            }
        };
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener, errorListener);
        requestQueue.add(stringRequest);
    }
    private void sendMessage(CharSequence query){
        Intent intent = new Intent(this, SearchActivity.class);
        intent.putExtra("query", query);
        startActivity(intent);
    }

}
