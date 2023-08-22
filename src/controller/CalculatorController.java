package controller;

import javax.swing.JLabel;
import javax.swing.JTextField;

import model.CalculatorModel;
import view.CalculatorGUI;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorGUI view;

    public CalculatorController(CalculatorModel model, CalculatorGUI view) {
        this.model = model;
        this.view = view;
    }

    public void processExpression() {
        JTextField expressionField = view.getInputExpressionField();
        JLabel resultLabel = view.displayResultLabel();

        String expression = expressionField.getText();
        double result = model.evaluateExpression(expression);
        resultLabel.setText("El resultado es: " + result);
    }
}


