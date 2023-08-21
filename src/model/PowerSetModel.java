package model;

import java.util.*;

public class PowerSetModel {
    public List<Set<Integer>> generatePowerSet(List<Integer> inputList) {
        int n = inputList.size();
        int powerSetSize = (int) Math.pow(2, n);

        List<Set<Integer>> powerSet = new ArrayList<>();

        for (int i = 0; i < powerSetSize; i++) {
            Set<Integer> subset = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    subset.add(inputList.get(j));
                }
            }
            powerSet.add(subset);
        }

        return powerSet;
    }
}
