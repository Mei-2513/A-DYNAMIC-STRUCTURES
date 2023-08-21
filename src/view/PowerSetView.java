package view;

import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import model.PowerSetModel;


import java.util.*;

public class PowerSetView extends JFrame {
    private JTextArea textArea;

    public PowerSetView() {
        setTitle("Power Set Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);
    }

    public void displayPowerSet(List<Set<Integer>> powerSet) {
        textArea.setText("Power Set:\n");
        for (Set<Integer> subset : powerSet) {
            textArea.append(subset.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        List<Integer> inputList = new ArrayList<>();
        inputList.add(1);
        inputList.add(2);
        inputList.add(3);

        PowerSetModel model = new PowerSetModel();
        List<Set<Integer>> powerSet = model.generatePowerSet(inputList);

        SwingUtilities.invokeLater(() -> {
            PowerSetView view = new PowerSetView();
            view.displayPowerSet(powerSet);
            view.setVisible(true);
        });
    }
}



