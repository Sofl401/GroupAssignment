package com.example.cocktailWizard.Quiz;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

// Code for random sequence generator taken from https://stackoverflow.com/questions/21049747/how-can-i-generate-a-random-number-in-a-certain-range/21049922
// and adapted for use in our application.
public class RandomSequenceGenerator {

    private final int maxBound = 29;
    private final Random random = new Random();
    private final Set<Integer> uniqueSet = new HashSet<>();

    public Integer[] getNextRandomSeq(int maxNoOfQuestions) {
        uniqueSet.clear();
        while(uniqueSet.size() < maxNoOfQuestions){
            uniqueSet.add(random.nextInt(maxBound));
        }
        Integer arraySize = uniqueSet.size();
        Integer array[] = new Integer[arraySize];
        return uniqueSet.toArray(array);
    }



}
