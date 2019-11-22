
package com.example.cocktailWizard.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

// Model class generated from http://www.jsonschema2pojo.org/ and the drink class combined within Drinks class for easier access
public class Drinks {

    @SerializedName("drinks")
    @Expose
    public List<Drink> results;

    public List<Drink> getDrinks() {
        return results;
    }

    public void setDrinks(List<Drink> drinks){
        this.results=drinks;
    }
    public class Drink {

        @SerializedName("idDrink")
        @Expose
        public String idDrink;

        @SerializedName("strDrink")
        @Expose
        public String strDrink;

        @SerializedName("strDrinkAlternate")
        @Expose
        public Object strDrinkAlternate;

        @SerializedName("strCategory")
        @Expose
        public String strCategory;

        @SerializedName("strAlcoholic")
        @Expose
        public String strAlcoholic;

        @SerializedName("strGlass")
        @Expose
        public String strGlass;

        @SerializedName("strInstructions")
        @Expose
        public String strInstructions;

        @SerializedName("strDrinkThumb")
        @Expose
        public String strDrinkThumb;

        @SerializedName("strIngredient1")
        @Expose
        public String strIngredient1;

        @SerializedName("strIngredient2")
        @Expose
        public String strIngredient2;

        @SerializedName("strIngredient3")
        @Expose
        public String strIngredient3;

        @SerializedName("strIngredient4")
        @Expose
        public String strIngredient4;

        @SerializedName("strIngredient5")
        @Expose
        public String strIngredient5;

        @SerializedName("strIngredient6")
        @Expose
        public String strIngredient6;

        @SerializedName("strIngredient7")
        @Expose
        public String strIngredient7;

        @SerializedName("strIngredient8")
        @Expose
        public String strIngredient8;

        @SerializedName("strIngredient9")
        @Expose
        public String strIngredient9;

        @SerializedName("strIngredient10")
        @Expose
        public String strIngredient10;

        @SerializedName("strMeasure1")
        @Expose
        public String strMeasure1;

        @SerializedName("strMeasure2")
        @Expose
        public String strMeasure2;

        @SerializedName("strMeasure3")
        @Expose
        public String strMeasure3;

        @SerializedName("strMeasure4")
        @Expose
        public String strMeasure4;

        @SerializedName("strMeasure5")
        @Expose
        public String strMeasure5;

        @SerializedName("strMeasure6")
        @Expose
        public String strMeasure6;

        @SerializedName("strMeasure7")
        @Expose
        public String strMeasure7;

        @SerializedName("strMeasure8")
        @Expose
        public String strMeasure8;

        @SerializedName("strMeasure9")
        @Expose
        public String strMeasure9;

        @SerializedName("strMeasure10")
        @Expose
        public String strMeasure10;

        @SerializedName("strCreativeCommonsConfirmed")
        @Expose
        public String strCreativeCommonsConfirmed;

        @SerializedName("dateModified")
        @Expose
        public String dateModified;

        public String getIdDrink() {
            return idDrink;
        }

        public void setIdDrink(String idDrink) {
            this.idDrink = idDrink;
        }

        public String getStrDrink() {
            return strDrink;
        }

        public void setStrDrink(String strDrink) {
            this.strDrink = strDrink;
        }

        public Object getStrDrinkAlternate() {
            return strDrinkAlternate;
        }

        public void setStrDrinkAlternate(Object strDrinkAlternate) {
            this.strDrinkAlternate = strDrinkAlternate;
        }

        public String getStrCategory() {
            return strCategory;
        }

        public void setStrCategory(String strCategory) {
            this.strCategory = strCategory;
        }

        public String getStrAlcoholic() {
            return strAlcoholic;
        }

        public void setStrAlcoholic(String strAlcoholic) {
            this.strAlcoholic = strAlcoholic;
        }

        public String getStrGlass() {
            return strGlass;
        }

        public void setStrGlass(String strGlass) {
            this.strGlass = strGlass;
        }

        public String getStrInstructions() {
            return strInstructions;
        }

        public void setStrInstructions(String strInstructions) {
            this.strInstructions = strInstructions;
        }

        public String getStrDrinkThumb() {
            return strDrinkThumb;
        }

        public void setStrDrinkThumb(String strDrinkThumb) {
            this.strDrinkThumb = strDrinkThumb;
        }

        public String getStrIngredient1() {
            return strIngredient1;
        }

        public void setStrIngredient1(String strIngredient1) {
            this.strIngredient1 = strIngredient1;
        }

        public String getStrIngredient2() {
            return strIngredient2;
        }

        public void setStrIngredient2(String strIngredient2) {
            this.strIngredient2 = strIngredient2;
        }

        public String getStrIngredient3() {
            return strIngredient3;
        }

        public void setStrIngredient3(String strIngredient3) {
            this.strIngredient3 = strIngredient3;
        }

        public String getStrIngredient4() {
            return strIngredient4;
        }

        public void setStrIngredient4(String strIngredient4) {
            this.strIngredient4 = strIngredient4;
        }

        public String getStrIngredient5() {
            return strIngredient5;
        }

        public void setStrIngredient5(String strIngredient5) {
            this.strIngredient5 = strIngredient5;
        }

        public String getStrIngredient6() {
            return strIngredient6;
        }

        public void setStrIngredient6(String strIngredient6) {
            this.strIngredient6 = strIngredient6;
        }

        public String getStrIngredient7() {
            return strIngredient7;
        }

        public void setStrIngredient7(String strIngredient7) {
            this.strIngredient7 = strIngredient7;
        }

        public String getStrIngredient8() {
            return strIngredient8;
        }

        public void setStrIngredient8(String strIngredient8) {
            this.strIngredient8 = strIngredient8;
        }

        public String getStrIngredient9() {
            return strIngredient9;
        }

        public void setStrIngredient9(String strIngredient9) {
            this.strIngredient9 = strIngredient9;
        }

        public String getStrIngredient10() {
            return strIngredient10;
        }

        public void setStrIngredient10(String strIngredient10) {
            this.strIngredient10 = strIngredient10;
        }

        public String getStrMeasure1() {
            return strMeasure1;
        }

        public void setStrMeasure1(String strMeasure1) {
            this.strMeasure1 = strMeasure1;
        }

        public String getStrMeasure2() {
            return strMeasure2;
        }

        public void setStrMeasure2(String strMeasure2) {
            this.strMeasure2 = strMeasure2;
        }

        public String getStrMeasure3() {
            return strMeasure3;
        }

        public void setStrMeasure3(String strMeasure3) {
            this.strMeasure3 = strMeasure3;
        }

        public String getStrMeasure4() {
            return strMeasure4;
        }

        public void setStrMeasure4(String strMeasure4) {
            this.strMeasure4 = strMeasure4;
        }

        public String getStrMeasure5() {
            return strMeasure5;
        }

        public void setStrMeasure5(String strMeasure5) {
            this.strMeasure5 = strMeasure5;
        }

        public String getStrMeasure6() {
            return strMeasure6;
        }

        public void setStrMeasure6(String strMeasure6) {
            this.strMeasure6 = strMeasure6;
        }

        public String getStrMeasure7() {
            return strMeasure7;
        }

        public void setStrMeasure7(String strMeasure7) {
            this.strMeasure7 = strMeasure7;
        }

        public String getStrMeasure8() {
            return strMeasure8;
        }

        public void setStrMeasure8(String strMeasure8) {
            this.strMeasure8 = strMeasure8;
        }

        public String getStrMeasure9() {
            return strMeasure9;
        }

        public void setStrMeasure9(String strMeasure9) {
            this.strMeasure9 = strMeasure9;
        }

        public String getStrMeasure10() {
            return strMeasure10;
        }

        public void setStrMeasure10(String strMeasure10) {
            this.strMeasure10 = strMeasure10;
        }

        public String getStrCreativeCommonsConfirmed() {
            return strCreativeCommonsConfirmed;
        }

        public void setStrCreativeCommonsConfirmed(String strCreativeCommonsConfirmed) {
            this.strCreativeCommonsConfirmed = strCreativeCommonsConfirmed;
        }

        public String getDateModified() {
            return dateModified;
        }

        public void setDateModified(String dateModified) {
            this.dateModified = dateModified;
        }
    }

}
