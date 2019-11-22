package com.example.cocktailWizard.Activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.cocktailWizard.DrinksApi;
import com.example.cocktailWizard.Model.Drinks;
import com.example.cocktailWizard.R;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Code for Retrofit taken from https://www.youtube.com/watch?v=4JGvDUlfk7Y&t=8s and adapted
// Appending textview code https://www.youtube.com/watch?v=a7gxZKW4VkE
// Async task example https://www.youtube.com/watch?v=uKx0FuVriqA

public class DetailActivityRecycler extends AppCompatActivity {
    TextView name;
    ImageView image;
    TextView ingredients;
    TextView measures;
    TextView instructions;
    Button refresh;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_fragment);

        name = findViewById(R.id.name);
        image = findViewById(R.id.ranImage);
        ingredients = findViewById(R.id.ing);
        measures = findViewById(R.id.measures);
        instructions = findViewById(R.id.instructions);
        refresh = findViewById(R.id.refresh);

        DrinksClass drinksClass = new DrinksClass();
        drinksClass.execute();
        refresh.setVisibility(View.GONE);

    }
    private class DrinksClass extends AsyncTask<Void, Void, List<Drinks.Drink>> {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Intent intent = getIntent();
        String id = intent.getStringExtra("cID");

        DrinksApi service = retrofit.create(DrinksApi.class);

        @Override
        protected List<Drinks.Drink> doInBackground(Void... voids) {
            Call<Drinks> RandomCall = service.getCocktail(id);
            try {
                Response<Drinks> drinkResponse = RandomCall.execute();
                List<Drinks.Drink> myDrink = drinkResponse.body().getDrinks();
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
            Glide.with(getApplicationContext()).load(result.get(0).getStrDrinkThumb()).into(image);
            name.setText(result.get(0).getStrDrink());
            instructions.setText(result.get(0).getStrInstructions());

            ingredients.setText(" ");
            measures.setText(" ");
            if (result.get(0).getStrIngredient1() != null) {
                ingredients.append("\n " + result.get(0).getStrIngredient1());
            } else {
            }
            if (result.get(0).getStrIngredient2() != null) {
                ingredients.append("\n " + result.get(0).getStrIngredient2());
            } else {
            }
            if (result.get(0).getStrIngredient3() != null) {
                ingredients.append("\n " + result.get(0).getStrIngredient3());
            } else {
            }
            if (result.get(0).getStrIngredient4() != null) {
                ingredients.append("\n " + result.get(0).getStrIngredient4());
            } else {
            }
            if (result.get(0).getStrIngredient5() != null) {
                ingredients.append("\n " + result.get(0).getStrIngredient5());
            } else {
            }
            if (result.get(0).getStrIngredient6() != null) {
                ingredients.append("\n " + result.get(0).getStrIngredient6());
            } else {
            }
            if (result.get(0).getStrIngredient7() != null) {
                ingredients.append("\n " + result.get(0).getStrIngredient7());
            } else {
            }
            if (result.get(0).getStrIngredient8() != null) {
                ingredients.append("\n " + result.get(0).getStrIngredient8());
            } else {
            }
            if (result.get(0).getStrIngredient9() != null) {
                ingredients.append("\n " + result.get(0).getStrIngredient9());
            } else {
            }
            if (result.get(0).getStrIngredient10() != null) {
                ingredients.append("\n " + result.get(0).getStrIngredient10());
            } else {
            }
            if (result.get(0).getStrMeasure1() != null) {
                measures.append("\n " + result.get(0).getStrMeasure1());
            } else {
            }
            if (result.get(0).getStrMeasure2() != null) {
                measures.append("\n " + result.get(0).getStrMeasure2());
            } else {
            }
            if (result.get(0).getStrMeasure3() != null) {
                measures.append("\n " + result.get(0).getStrMeasure3());
            } else {
            }
            if (result.get(0).getStrMeasure4() != null) {
                measures.append("\n " + result.get(0).getStrMeasure4());
            } else {
            }
            if (result.get(0).getStrMeasure5() != null) {
                measures.append("\n " + result.get(0).getStrMeasure5());
            } else {
            }
            if (result.get(0).getStrMeasure6() != null) {
                measures.append("\n " + result.get(0).getStrMeasure6());
            } else {
            }
            if (result.get(0).getStrMeasure7() != null) {
                measures.append("\n " + result.get(0).getStrMeasure7());
            } else {
            }
            if (result.get(0).getStrMeasure8() != null) {
                measures.append("\n " + result.get(0).getStrMeasure8());
            } else {
            }
            if (result.get(0).getStrMeasure9() != null) {
                measures.append("\n " + result.get(0).getStrMeasure9());
            } else {
            }
            if (result.get(0).getStrMeasure10() != null) {
                measures.append("\n " + result.get(0).getStrMeasure10());
            } else {
            }
        }
    }
}

