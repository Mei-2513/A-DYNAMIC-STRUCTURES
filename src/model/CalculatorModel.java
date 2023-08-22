package model;

import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
import java.util.function.DoubleUnaryOperator;

public class CalculatorModel {
    private Stack<Double> operandStack = new Stack<>();
    private Stack<String> operatorStack = new Stack<>();
    private Map<String, DoubleUnaryOperator> functions = new HashMap<>();

    public CalculatorModel() {
        functions.put("sin", Math::sin);
        functions.put("cos", Math::cos);
    }

    public double evaluateExpression(String expression) {
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (isNumber(token)) {
                operandStack.push(Double.parseDouble(token));
            } else if (functions.containsKey(token)) {
                double operand = operandStack.pop();
                double result = functions.get(token).applyAsDouble(Math.toRadians(operand));
                operandStack.push(result);
            } else if (isOperator(token)) {
                while (!operatorStack.isEmpty() && hasHigherPrecedence(operatorStack.peek(), token)) {
                    String operator = operatorStack.pop();
                    double secondOperand = operandStack.pop();
                    double firstOperand = operandStack.pop();
                    double intermediateResult = performOperation(firstOperand, secondOperand, operator);
                    operandStack.push(intermediateResult);
                }
                operatorStack.push(token);
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.peek().equals("(")) {
                    String operator = operatorStack.pop();
                    double secondOperand = operandStack.pop();
                    double firstOperand = operandStack.pop();
                    double intermediateResult = performOperation(firstOperand, secondOperand, operator);
                    operandStack.push(intermediateResult);
                }
                operatorStack.pop(); // Pop the "("
            }
        }

        while (!operatorStack.isEmpty()) {
            String operator = operatorStack.pop();
            double secondOperand = operandStack.pop();
            double firstOperand = operandStack.pop();
            double result = performOperation(firstOperand, secondOperand, operator);
            operandStack.push(result);
        }

        return operandStack.pop();
    }

    private boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private boolean hasHigherPrecedence(String op1, String op2) {
        int precedence1 = getPrecedence(op1);
        int precedence2 = getPrecedence(op2);
        return precedence1 >= precedence2;
    }

    private int getPrecedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }

    private double performOperation(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}





