package model;

import java.util.Stack;

public class StackCalculator {
    private Stack<Double> operandStack;
    private Stack<String> operatorStack;

    public StackCalculator() {
        operandStack = new Stack<>();
        operatorStack = new Stack<>();
    }

    public double evaluateExpression(String expression) {
        String[] tokens = expression.split("\\s+");
        
        for (String token : tokens) {
            if (isNumber(token)) {
                operandStack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                while (!operatorStack.isEmpty() && hasHigherPrecedence(operatorStack.peek(), token)) {
                    evaluateOperator(operatorStack.pop());
                }
                operatorStack.push(token);
            }
        }
        
        while (!operatorStack.isEmpty()) {
            evaluateOperator(operatorStack.pop());
        }
        
        return operandStack.pop();
    }

    private boolean isNumber(String token) {
        return token.matches("-?\\d+(\\.\\d+)?");
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private boolean hasHigherPrecedence(String op1, String op2) {
        return (op1.equals("*") || op1.equals("/")) && (op2.equals("+") || op2.equals("-"));
    }

    private void evaluateOperator(String operator) {
        double operand2 = operandStack.pop();
        double operand1 = operandStack.pop();
        
        double result = 0.0;
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand1 / operand2;
                break;
        }
        
        operandStack.push(result);
    }
}


