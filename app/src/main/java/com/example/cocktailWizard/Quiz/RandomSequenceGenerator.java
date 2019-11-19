package com.example.cocktailWizard.Quiz;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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
