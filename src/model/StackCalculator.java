package model;

import java.util.Stack;

public class StackCalculator {
    private Stack<Double> operandStack;

    public StackCalculator() {
        operandStack = new Stack<>();
    }

    public double evaluateExpression(String expression) {
        String[] tokens = expression.split("\\s+");
        
        for (String token : tokens) {
            if (isNumber(token)) {
                operandStack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                evaluateOperator(token);
            } else if (isFunction(token)) {
                evaluateFunction(token);
            }
        }
        
        return operandStack.pop();
    }

    private boolean isNumber(String token) {
        return token.matches("-?\\d+(\\.\\d+)?");
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private boolean isFunction(String token) {
        return token.equals("sin") || token.equals("cos");
    }

    private void evaluateOperator(String operator) {
        double operand2 = operandStack.pop();
        double operand1 = operandStack.pop();
        
        switch (operator) {
            case "+":
                operandStack.push(operand1 + operand2);
                break;
            case "-":
                operandStack.push(operand1 - operand2);
                break;
            case "*":
                operandStack.push(operand1 * operand2);
                break;
            case "/":
                operandStack.push(operand1 / operand2);
                break;
        }
    }

    private void evaluateFunction(String function) {
        double operand = operandStack.pop();
        
        switch (function) {
            case "sin":
                operandStack.push(Math.sin(Math.toRadians(operand)));
                break;
            case "cos":
                operandStack.push(Math.cos(Math.toRadians(operand)));
                break;
        }
    }
}

