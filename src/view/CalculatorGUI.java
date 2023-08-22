package view;


import javax.swing.*;

import controller.CalculatorController;
import model.CalculatorModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI {
    private JFrame frame;
    private JTextField expressionField;
    private JLabel resultLabel;

    public CalculatorGUI() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel exampleLabel = new JLabel("Ejemplo es necesario usar los espacios correctos: 5 + 3 * sin ( 30 )");
        expressionField = new JTextField(30); 
        JButton calculateButton = new JButton("Calcular");
        resultLabel = new JLabel("Resultado: ");

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalculatorController controller = new CalculatorController(new CalculatorModel(), CalculatorGUI.this);
                controller.processExpression();
            }
        });

        frame.add(exampleLabel);
        frame.add(expressionField);
        frame.add(calculateButton);
        frame.add(resultLabel);

        frame.setSize(400, 200); 
        frame.setVisible(true);
    }

    public JTextField getInputExpressionField() {
        return expressionField;
    }

    public JLabel displayResultLabel() {
        return resultLabel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculatorGUI();
            }
        });
    }
}


