package com.example.cocktailWizard.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.cocktailWizard.Adapters.SearchAdapter;
import com.example.cocktailWizard.Model.Drinks;
import com.example.cocktailWizard.R;
import com.google.gson.Gson;

// Volley example taken from https://www.youtube.com/watch?v=y2xtLqP8dSQ and adapted
// https://www.youtube.com/watch?v=KlylC2rgAWM search view fragment example taken from here
// Searchview with recycler code adapted from https://www.youtube.com/watch?v=sJ-Z9G0SDhc


public class SearchActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_recycler);

        recyclerView = findViewById(R.id.results_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Intent intent = getIntent();
        String search = intent.getStringExtra("query");
        getVolley(search);

    }
    private void getVolley(String search){
        final SearchAdapter searchAdapter = new SearchAdapter();

        final RequestQueue requestQueue =  Volley.newRequestQueue(this);
        String url = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s="+search;

        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Drinks drinkList = gson.fromJson(response, Drinks.class);
                searchAdapter.setData(drinkList.results);
                recyclerView.setAdapter(searchAdapter);
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
}
