package com.example.cocktailWizard.Quiz;

public class QuestionLibrary {

    private String mQuestions [] = {
            "What is it called when you mix 4 oz tequila, 2 oz Cointreau, and the juice of two limes?",
            "What do you get when you mix 3 oz rye, 1 oz sweet vermouth, Angostura bitters, and top it with a maraschino cherry?",
            "Which cocktail calls for 2 oz of light rum, 1 oz lime juice, and ½ oz simple syrup?",
            "What drink requires fresh mint leaves, 1 ½ tbsp simple syrup, 1 tbsp fresh lime juice, 2 oz of light rum, and 2 fl oz of club soda?",
            "What would you call 2 oz of Cachaca, limes and 2 tsp sugar?",
            "What drink calls for equal parts Campari, sweet vermouth, and gin?",
            "What needs a sugar cube, some water, 1 ½ oz rye, Peychaud Bitters, Angostura bitters, and absinthe?",
            "Which cocktail requires 1 oz gin, ½ oz simple syrup, ½ oz fresh lemon juice, and champagne?",
            "What turns a plain martini into a dirty martini?",
            "A gimlet requires two specific ingredients. Which of the following is NOT in a gimlet?",
            "Martini: dry vermouth, a lemon twist and...?",
            "Cuba Libre: rum, coke and...?",
            "Cosmopolitan: vodka, triple sec, lemon, sugar syrup and...?",
            "Piña Colada: rum, coconut cream, cream, pineapple slice, salt and...?",
            "Mai Tai: dark rum, orange liqueur, pineapple juice, sugar syrup and...?",
            "Moscow Mule: vodka, sugar syrup, ginger beer and...?",
            "Sex On The Beach: vodka, orange juice, cranberry juice and...?",
            "Blue Lagoon: vodka, lemonade and...?",
            "White Lady is made of 3 ingredients. Which one of the following is not its ingredient?",
            "The difference between a White Russian and a Black Russian is that a Black Russian contains cream/milk.",
            "What do vodka, Kahlua and milk (or cream) make?",
            "What do gin, sweet and sour mix and splash of Seven-up(or Sprite) or club soda make?",
            "What do tequila, orange juice and grenadine make?",
            "What do rum, tequila, gin, vodka, triple sec, sweet and sour mix and a splash of cola make?",
            "What do vodka (or gin) and grapefruit juice make?",
            "What do vodka, triple sec and lime juice make?",
            "Which drink consists of Bacardi rum, lime juice and grenadine?",
            "Which drink consists of applejack, lime juice and grenadine?",
            "Which drink consists of Bourbon, sugar and 2 dashes of Angostura Bitters?",
            "Which of these drinks consists of gin, lemon juice, sugar and soda water?"

    };



    private String mChoices [][] = {
            {"Margarita", "Daiquiri", "Pisco Sour"},
            {"Bellini", "Manhattan", "Negroni"},
            {"Daiquiri", "Tom Collins", "Sidecar"},
            {"Gimlet", "Sazerac", "Mojito"},
            {"Daiquiri", "Old Faishoned", "Caipirinha"}, //Caipirinha
            {"Americano", "Martinez", "Negroni"}, //negroni
            {"Sazerac", "Bee's Knees", "Pisco Sour"}, //Sazerac
            {"Gin Fizz", "French 75", "Americano"}, //French75
            {"More Gin", "Olives", "Lime"}, //olives
            {"Gin", "Lime Juice", "Tonic Water"},//tonicwater
            {"Coffee", "Ice", "Gin"}, //gin
            {"Apple Juice", "Lime Juice", "Orange Juice"}, //limejuice
            {"Apple Juice", "Cranberry Juice", "Kiwi Juice"}, //cranberryjuice
            {"Pepper", "Vodka", "Pineapple Juice"}, //pineapplejuice
            {"Orgeat Syrup", "Salt", "Lime Juice"}, //orgeatsyrup
            {"Pepper", "Lime Juice", "Ginger Beer"}, //limejuice
            {"Tequilla", "Rum", "Peach Schnapps"}, //peachschnapps
            {"WKD", "Vimto", "Blue Curacao"}, //bluecuracao
            {"Gin", "Lemon Juice", "Brandy"},
            {"True", "False", "Both have milk"},
            {"White Russian", "Black Russian", "None"},
            {"Margarita", "Tom Collins", "French 75"},
            {"Tequila Sunrise", "Pina Colada", "Greyhound"},
            {"Long Island Iced Tea", "Whiskey Sour", "Tom Collins"},
            {"Greyhound", "Screwdriver", "Sea Breeze"},
            {"Martini", "Kamikaze", "Manhattan"},
            {"Bacardi Cocktail", "Mai Tai", "Pina Colada"},
            {"Alexander", "Jack Rose", "Mai Tai"},
            {"Old Fashioned", "Grasshopper", "Kamikaze"},
            {"Gimlet", "French 75", "Gin Fizz"}


    };



    private String mCorrectAnswers[] = {"Margarita", "Manhattan", "Daiquiri", "Mojito", "Caipirinha", "Negroni", "Sazerac", "French 75", "Olives", "Tonic Water", "Gin", "Lime Juice", "Cranberry Juice", "Pineapple Juice", "Orgeat Syrup", "Lime Juice",
            "Peach Schnapps", "Blue Curacao", "Brandy", "False", "White Russian", "Tom Collins", "Tequila Sunrise", "Long Island Iced Tea", "Greyhound", "Kamikaze", "Bacardi Cocktail", "Jack Rose", "Old Fashioned", "Gin Fizz"};


    private String mID[] = {"11007", "11008", "11006", "11000", "11202", "11003", "12127", "17197", "17181", "17255", "11728", "11288", "17196", "17207", "11690", "11009", "12754", "11117", "17194", "11102", "12528", "12402", "13621", "17204", "17252",
                 "11600", "17183", "11542", "11001", "11410"};


    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }


    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }


    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

    public String getID (int a) {
        String id = mID[a];
        return id;
    }

}
