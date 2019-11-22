package com.example.cocktailWizard;
import com.example.cocktailWizard.Model.Drinks;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


// Used for retrofit examples taken from https://www.youtube.com/watch?v=4JGvDUlfk7Y&t=8s
public interface DrinksApi {

    @GET("random.php")
    Call <Drinks> getRandom();

    @GET("lookup.php")
    Call <Drinks> getCocktail(@Query("i") String id);


}
