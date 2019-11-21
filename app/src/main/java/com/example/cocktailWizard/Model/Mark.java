package com.example.cocktailWizard.Model;

public class Mark {
    int nQuestion;
    String answer;
    String wrong;
    boolean correctA;

    public Mark(int nQuestion, String answer, String wrong, boolean correctA){
        this.nQuestion = nQuestion;
        this.answer = answer;
        this.wrong = wrong;
        this.correctA = correctA;
    }

    public boolean isCorrectA() {
        return correctA;
    }

    public void setCorrectA(boolean correctA) {
        this.correctA = correctA;
    }

    public int getnQuestion() {
        return nQuestion;
    }

    public void setnQuestion(int nQuestion) {
        this.nQuestion = nQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getWrong() {
        return wrong;
    }

    public void setWrong(String wrong) {
        this.wrong = wrong;
    }
}
