package com.example.cocktailWizard;
import com.example.cocktailWizard.Model.Drink;
import com.example.cocktailWizard.Model.Drinks;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

// contains relative url for relative.

public interface DrinksApi {

    @GET("random.php")
    Call <Drinks> getRandom();


}
