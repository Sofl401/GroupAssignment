package com.example.cocktailWizard.Activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;
import android.widget.Toast;

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
import com.example.cocktailWizard.DrinksApi;
import com.example.cocktailWizard.Model.Drink;
import com.example.cocktailWizard.Model.Drinks;
import com.example.cocktailWizard.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

    }
    private void getVolley(String category){
        final SpecificCategoryAdapter sCategoryAdapter = new SpecificCategoryAdapter();

        final RequestQueue requestQueue =  Volley.newRequestQueue(this);
        String url = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?c="+category;

        System.out.println(category);
        System.out.println(url);

        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
//                Type listType = new TypeToken<ArrayList<Drink>>(){}.getType();
//                ArrayList<Drink> results = new Gson().fromJson(response, listType);
                Drinks drinkList = gson.fromJson(response, Drinks.class);
                System.out.println(Log.w("2.0 getFeed > Full json res wrapped in pretty printed gson => ", new GsonBuilder().setPrettyPrinting().create().toJson(drinkList)));
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

//    private class SpecificCategory extends AsyncTask<Void, Void, List<Drinks.Drink>> {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//

//
////        @Override
////        protected List<Drinks.Drink> doInBackground(Void... voids) {
////            Call<Drinks> catCall = service2.getCategoryDrinks(catLink);
////
////            try {
////                Response<Drinks> drinkResponse = catCall.execute();
////                System.out.println(Log.w("2.0 getFeed > Full json res wrapped in pretty printed gson => ", new GsonBuilder().setPrettyPrinting().create().toJson(drinkResponse)));
////                List<Drinks.Drink> catDrinks = drinkResponse.body().getDrinks();
////                return catDrinks;
////            } catch (IOException e){
////                e.printStackTrace();
////                return null;
////            } catch (NullPointerException e){
////                e.printStackTrace();
////                return null;
////            }
////        }
////
////        @Override
////        protected void onPostExecute(List<Drinks.Drink> result) {
////            SpecificCategoryAdapter specificCategoryAdapter = new SpecificCategoryAdapter();
////            specificCategoryAdapter.setData(result);
////            recyclerView.setAdapter(specificCategoryAdapter);
////        }
////    }
}
