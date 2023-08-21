package controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import model.Task;


import java.text.SimpleDateFormat;

import java.util.Scanner;

public class TaskController {
    private List<Task> tasks;
    private Scanner scanner;

    public TaskController() {
        tasks = new LinkedList<>();
        scanner = new Scanner(System.in);
    }
    

    public void runConsoleApp() {
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Agregar tarea");
            System.out.println("2. Asignar tarea");
            System.out.println("3. Mostrar tareas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de la entrada numérica

            switch (choice) {
                case 1:
                    System.out.print("Ingrese la descripción: ");
                    String description = scanner.nextLine();
                    System.out.print("Ingrese la fecha de vencimiento (dd/mm/yyyy): ");
                    String dueDateStr = scanner.nextLine();
                    Date dueDate = parseDate(dueDateStr);
                    addTask(description, dueDate);
                    break;
                case 2:
                    System.out.println("Tareas:");
                    displayTasks();
                    System.out.print("Seleccione el índice de la tarea para asignar: ");
                    int taskIndex = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea después de la entrada numérica
                    System.out.print("Ingrese el nombre del usuario asignado: ");
                    String userName = scanner.nextLine();
                    assignTask(taskIndex, userName);
                    break;
                case 3:
                    displayTasks();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    public void addTask(String description, Date dueDate) {
        Task task = new Task(description, dueDate);
        tasks.add(task);
        System.out.println("Tarea agregada con éxito.");
    }
    

    public void assignTask(int taskIndex, String userName) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            Task task = tasks.get(taskIndex);
            task.setAssignedUser(userName);
            System.out.println("Tarea asignada a " + userName + ".");
        } else {
            System.out.println("Índice de tarea no válido.");
        }
    }

    public void displayTasks() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        int index = 0;
        
        for (Task task : tasks) {
            System.out.println("Índice: " + index);
            System.out.println("Descripción: " + task.getDescription());
            System.out.println("Fecha de vencimiento: " + dateFormat.format(task.getDueDate()));
            System.out.println("Asignado a: " + task.getAssignedUser());
            System.out.println("------------");
            index++;
        }
    }

    private Date parseDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(dateStr);
        } catch (Exception e) {
            System.out.println("Error al analizar la fecha. Utilizando fecha actual.");
            return new Date();
        }
    }
}


