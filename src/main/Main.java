package main;

import java.util.Date;

import controller.TaskController;
import model.Task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import java.util.Date;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        TaskController controller = new TaskController();

        controller.addTask("Hacer informe", new Date(2023 - 1900, 9, 1)); // Restamos 1900 al año y restamos 1 al mes
        controller.addTask("Preparar presentación", new Date(2023 - 1900, 8, 28)); // Restamos 1900 al año y restamos 1 al mes

        controller.assignTask(0, "Usuario1");
        controller.assignTask(1, "Usuario2");

        controller.runConsoleApp();
    }
}

