package com.example.cocktailWizard.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

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
import com.example.cocktailWizard.Adapters.SpecificCategoryAdapter;
import com.example.cocktailWizard.DrinksApi;
import com.example.cocktailWizard.Model.Drinks;
import com.example.cocktailWizard.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchActivity extends AppCompatActivity {
    private TextView textView;
    private RecyclerView recyclerView;
    public ImageView image;

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
//                Type listType = new TypeToken<ArrayList<Drink>>(){}.getType();
//                ArrayList<Drink> results = new Gson().fromJson(response, listType);
                Drinks drinkList = gson.fromJson(response, Drinks.class);
                System.out.println(Log.w("2.0 getFeed > Full json res wrapped in pretty printed gson => ", new GsonBuilder().setPrettyPrinting().create().toJson(drinkList)));
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
