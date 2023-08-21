package main;

import java.util.Date;

import controller.TaskController;

public class Main {
    public static void main(String[] args) {
        TaskController controller = new TaskController();

        controller.addTask("Hacer informe", new Date(2023, 8, 31));
        controller.addTask("Preparar presentación", new Date(2023, 8, 28));

        controller.assignTask(0, "Usuario1");
        controller.assignTask(1, "Usuario2");

        controller.displayTasks();
    }
}
