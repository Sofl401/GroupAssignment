package com.example.cocktailWizard.Fragments;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.example.cocktailWizard.DrinksApi;
import com.example.cocktailWizard.Model.Drinks;
import com.example.cocktailWizard.R;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RandomFragment extends Fragment {
    TextView name;
    ImageView image;
    TextView ingredients;
    TextView measures;
    TextView instructions;
    Button refresh;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // add r.id.textviews/buttons etc.
        View view = inflater.inflate(R.layout.random_fragment, container, false);

        name = view.findViewById(R.id.name);
        image = view.findViewById(R.id.ranImage);
        ingredients = view.findViewById(R.id.ing);
        measures = view.findViewById(R.id.measures);
        instructions = view.findViewById(R.id.instructions);
        refresh = view.findViewById(R.id.refresh);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshFragment();
            }
        });

        DrinksClass myDrinksClass = new DrinksClass();
        myDrinksClass.execute();

        return view;
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
                Response<Drinks> drinkResponse = RandomCall.execute();
                List<Drinks.Drink> myDrink = drinkResponse.body().getDrinks();
                //System.out.println(Log.w("2.0 getFeed > Full json res wrapped in pretty printed gson => ", new GsonBuilder().setPrettyPrinting().create().toJson(myDrink)));
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
            Glide.with(getContext()).load(result.get(0).getStrDrinkThumb()).into(image);
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

    private void refreshFragment() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        if (Build.VERSION.SDK_INT >= 26) {
            ft.setReorderingAllowed(false);
        }
        ft.detach(this).attach(this).commit();
    }


}




