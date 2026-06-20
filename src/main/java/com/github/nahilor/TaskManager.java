package com.github.nahilor;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();

    public static TaskManager manager() {
        return new TaskManager();
    }

    public void addTask(String text) {
        Task task = Task.toDo(text);
        tasks.add(task);
        System.out.println("Task added successfully (ID: " + tasks.indexOf(task) + ")" );
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    public void update(int id, String text) {
        if (id >= tasks.size() || id < 0) {
            System.out.println("task not found.");
            return;
        }
        tasks.set(id, Task.toDo(text));
    }

    public void delete(int id) {
        if (id >= tasks.size() || id < 0) {
            System.out.println("task not found.");
            return;
        }
        tasks.remove(id);
    }

    public void markAsInProgress(int id) {
        if (id >= tasks.size() || id < 0) {
            System.out.println("task not found.");
            return;
        }
        tasks.get(id).setCurrentStatus(Status.IN_PROGRESS);
    }

    public void markAsDone(int id) {
        if (id >= tasks.size() || id < 0) {
            System.out.println("task not found.");
            return;
        }
        tasks.get(id).setCurrentStatus(Status.DONE);
    }

    public void listAll() {
        for (Task task : tasks) {
            System.out.println(tasks.indexOf(task) + ": " + task.getDescription() + " Status: " + task.getCurrentStatus());
        }
    }

    public void listDone() {
        for (Task task : tasks) {
            if (task.getCurrentStatus() == Status.DONE) {
                System.out.println(tasks.indexOf(task) + ": " + task.getDescription());
            }
        }
    }

    public void listToDo() {
        for (Task task : tasks) {
            if (task.getCurrentStatus() == Status.TO_DO) {
                System.out.println(tasks.indexOf(task) + ": " + task.getDescription());
            }
        }
    }

    public void listInProgress() {
        for (Task task : tasks) {
            if (task.getCurrentStatus() == Status.IN_PROGRESS) {
                System.out.println(tasks.indexOf(task) + ": " + task.getDescription());
            }
        }
    }

    public void getLatest() {
        if (tasks.isEmpty()) {
            System.out.println("Task list is empty");
            return;
        }
        Task latest = tasks.getFirst();
        for (Task task : tasks) {
            if (latest.getUpdatedAt().isBefore(task.getUpdatedAt())) {
                latest = task;
            }
        }
        System.out.println(latest);
    }

    public Task getOldest() {
        if (tasks.isEmpty()) {
            System.out.println("Task list is empty");
            return null;
        }
        Task oldest = tasks.getFirst();
        for (Task task : tasks) {
            if (oldest.getUpdatedAt().isAfter(task.getUpdatedAt())) {
                oldest = task;
            }
        }
        return oldest;
    }
}
