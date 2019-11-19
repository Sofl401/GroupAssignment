package com.example.cocktailWizard.Quiz;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomSequenceGenerator {

    private final int maxBound = 29;
    private final Random random = new Random();
    private final Set<Integer> uniqueSet = new HashSet<>();

    public Integer[] getNextRandomSeq() {
        uniqueSet.clear();
        while(uniqueSet.size() < 10){
            uniqueSet.add(random.nextInt(29));
        }
        Integer arraySize = uniqueSet.size();
        Integer array[] = new Integer[arraySize];
        return uniqueSet.toArray(array);
    }


}
