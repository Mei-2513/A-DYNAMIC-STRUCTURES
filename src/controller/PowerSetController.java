package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.PowerSetModel;
import view.PowerSetView;

public class PowerSetController {
    public static void main(String[] args) {
        List<Integer> inputList = new ArrayList<>();
        inputList.add(1);
        inputList.add(2);
        inputList.add(3);

        PowerSetModel model = new PowerSetModel();
        List<Set<Integer>> powerSet = model.generatePowerSet(inputList);

        PowerSetView view = new PowerSetView();
        view.displayPowerSet(powerSet);
    }
}
