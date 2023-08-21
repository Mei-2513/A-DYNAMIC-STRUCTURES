package view;

import java.util.Scanner;

public class CalculatorView {
    public String getInputExpression() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la expresión matemática: ");
        return scanner.nextLine();
    }

    public void displayResult(double result) {
        System.out.println("El resultado es: " + result);
    }
}



