package model;

import java.util.Stack;
import java.util.function.DoubleUnaryOperator;

public class StackCalculator {
    private Stack<Double> operandStack;
    private Stack<String> operatorStack;
    private final DoubleUnaryOperator SIN_FUNCTION = Math::sin;
    private final DoubleUnaryOperator COS_FUNCTION = Math::cos;

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
            } else if (isFunction(token)) {
                operatorStack.push(token);
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.peek().equals("(")) {
                    evaluateOperator(operatorStack.pop());
                }
                operatorStack.pop(); // Remove "(" from stack
                if (!operatorStack.isEmpty() && isFunction(operatorStack.peek())) {
                    evaluateFunction(operatorStack.pop());
                }
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

    private boolean isFunction(String token) {
        return token.equals("sin") || token.equals("cos");
    }

    private boolean hasHigherPrecedence(String op1, String op2) {
        if ((op1.equals("*") || op1.equals("/")) && (op2.equals("+") || op2.equals("-"))) {
            return true;
        }
        return false;
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

    private void evaluateFunction(String function) {
        double operand = operandStack.pop();
        DoubleUnaryOperator operator;
        if (function.equals("sin")) {
            operator = SIN_FUNCTION;
        } else {
            operator = COS_FUNCTION;
        }

        operandStack.push(operator.applyAsDouble(operand));
    }
}


