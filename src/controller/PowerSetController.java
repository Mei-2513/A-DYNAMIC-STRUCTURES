package controller;

import java.util.HashSet;
import java.util.Set;

import model.PowerSetModel;
import view.PowerSetView;

public class PowerSetController {
    public static void main(String[] args) {
        Set<Integer> inputSet = new HashSet<>();
        inputSet.add(1);
        inputSet.add(2);
        inputSet.add(3);
        
        PowerSetModel model = new PowerSetModel();
        Set<Set<Integer>> powerSet = model.generatePowerSet(inputSet);
        
        PowerSetView view = new PowerSetView();
        view.displayPowerSet(powerSet);
    }
}

