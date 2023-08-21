package controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import model.Task;
import view.TaskView;

public class TaskController {
    private List<Task> tasks;
    private TaskView view;

    public TaskController() {
        tasks = new LinkedList<>();
        view = new TaskView();
    }

    public void addTask(String description, Date dueDate) {
        Task task = new Task(description, dueDate);
        tasks.add(task);
    }

    public void assignTask(int taskIndex, String userName) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            Task task = tasks.get(taskIndex);
            task.setAssignedUser(userName);
        }
    }

    public void displayTasks() {
        view.printTasks(tasks);
    }
}

