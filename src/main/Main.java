package main;

import controller.CalculatorController;
import model.StackCalculator;
import view.CalculatorView;

public class Main {
    public static void main(String[] args) {
        StackCalculator model = new StackCalculator();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);
        controller.run();
    }
}
