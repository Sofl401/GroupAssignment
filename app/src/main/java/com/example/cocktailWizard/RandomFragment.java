//package com.example.cocktailWizard;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//
//import com.example.cocktailWizard.Model.Drink;
//import com.example.cocktailWizard.Model.Drinks;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//
//public class RandomFragment extends Fragment {
//    TextView example;
//
//    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
//        // add r.id.textviews/buttons etc.
//        View view = inflater.inflate(R.layout.random_fragment, container, false);
//
//        example = view.findViewById(R.id.textView);
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        DrinksApi drinksApi = retrofit.create(DrinksApi.class);
//        Call<List<Drink>> call = drinksApi.getRandom();
//
//        call.enqueue(new Callback<List<Drinks>>() {
//            @Override
//            public void onResponse(Call<Drink> call, Response<Drink> response) {
//                Drink rDrink = response.body();
//                System.out.println(Log.w("2.0 getFeed > Full json res wrapped in pretty printed gson => ",new GsonBuilder().setPrettyPrinting().create().toJson(response)));
//
//                System.out.println(rDrink);
//                example.setText(rDrink.getStrDrink());
//            }
//
//            @Override
//            public void onFailure(Call<Drink> call, Throwable t) {
//                example.setText(t.getMessage());
//            }
//
//        });
//
//        return view;
//    }
//
//
//}
