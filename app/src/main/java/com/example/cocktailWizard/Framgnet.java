package com.example.cocktailWizard;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.cocktailWizard.Model.Drinks;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Framgnet extends AppCompatActivity {
    TextView example;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_fragment);

        example = findViewById(R.id.textView);
        DrinksClass myDrinksClass = new DrinksClass();
        myDrinksClass.execute();
    }

    private class DrinksClass extends AsyncTask<Void, Void, List<Drinks.Drink>> {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DrinksApi service = retrofit.create(DrinksApi.class);

        @Override
        protected List<Drinks.Drink> doInBackground(Void... voids) {
            Call<Drinks> RandomCall = service.getRandom();
            try {
                Response<Drinks> MealResponse = RandomCall.execute();
                List<Drinks.Drink> myDrink = MealResponse.body().getDrinks();
                System.out.println(Log.w("2.0 getFeed > Full json res wrapped in pretty printed gson => ", new GsonBuilder().setPrettyPrinting().create().toJson(myDrink)));
                return myDrink;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            } catch (NullPointerException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<Drinks.Drink> result) {
            //System.out.println(result.get(0).getStrDrink());
            example.setText(result.get(0).getStrDrink());
        }

    }


}
