package view;

import java.util.Set;

public class PowerSetView {
    public void displayPowerSet(Set<Set<Integer>> powerSet) {
        System.out.println("Power Set:");
        for (Set<Integer> subset : powerSet) {
            System.out.println(subset);
        }
    }
}


