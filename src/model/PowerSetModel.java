package model;

import java.util.HashSet;
import java.util.Set;

public class PowerSetModel {
    public Set<Set<Integer>> generatePowerSet(Set<Integer> inputSet) {
        Set<Set<Integer>> powerSet = new HashSet<>();
        generatePowerSetRec(inputSet, new HashSet<>(), powerSet);
        return powerSet;
    }

    private void generatePowerSetRec(Set<Integer> remaining, Set<Integer> currentSubset, Set<Set<Integer>> powerSet) {
        powerSet.add(new HashSet<>(currentSubset));
        
        for (int num : remaining) {
            Set<Integer> newRemaining = new HashSet<>(remaining);
            newRemaining.remove(num);
            
            Set<Integer> newSubset = new HashSet<>(currentSubset);
            newSubset.add(num);
            
            generatePowerSetRec(newRemaining, newSubset, powerSet);
        }
    }
}
