package com.example.cocktailWizard;

public class QuestionLibrary {

    private String mQuestions [] = {
            "What is it called when you mix 4 oz tequila, 2 oz Cointreau, and the juice of two limes?",
            "What do you get when you mix 3 oz rye, 1 oz sweet vermouth, Angostura bitters, and top it with a maraschino cherry?",
            "Which cocktail calls for 2 oz of light rum, 1 oz lime juice, and ½ oz simple syrup?",
            "What drink requires fresh mint leaves, 1 ½ tbsp simple syrup, 1 tbsp fresh lime juice, 2 oz of light rum, and 2 fl oz of club soda?"

    };


    private String mChoices [][] = {
            {"Margarita", "Daiquiri", "Pisco Sour"},
            {"Bellini", "Manhattan", "Negroni"},
            {"Daiquiri", "Tom Collins", "Sidecar"},
            {"Gimlet", "Sazerac", "Mojito"}
    };



    private String mCorrectAnswers[] = {"Margarita", "Manhattan", "Daiquiri", "Mojito"};




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


}
