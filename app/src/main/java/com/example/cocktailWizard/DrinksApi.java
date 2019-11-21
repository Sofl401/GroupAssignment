package com.example.cocktailWizard;
import com.example.cocktailWizard.Model.Drinks;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

// contains relative url for relative.

public interface DrinksApi {

    @GET("random.php")
    Call <Drinks> getRandom();

    @GET("lookup.php")
    Call <Drinks> getCocktail(@Query("i") String id);

    @GET("search.php")
    Call <Drinks> getSearch (@Query("i") String search);
}
