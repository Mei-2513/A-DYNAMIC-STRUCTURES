package view;

import java.util.List;

import model.Task;

public class TaskView {
    public void printTasks(List<Task> tasks) {
        for (Task task : tasks) {
            System.out.println("Descripción: " + task.getDescription());
            System.out.println("Fecha de vencimiento: " + task.getDueDate());
            System.out.println("Asignado a: " + task.getAssignedUser());
            System.out.println("------------");
        }
    }
}

