package controller;

import model.StackCalculator;
import view.CalculatorView;

public class CalculatorController {
    private StackCalculator model;
    private CalculatorView view;

    public CalculatorController(StackCalculator model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        String expression = view.getInputExpression();
        double result = model.evaluateExpression(expression);
        view.displayResult(result);
    }
}


