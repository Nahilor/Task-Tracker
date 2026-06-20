package com.github.nahilor;

import java.time.LocalDate;

public class Main {
    void main() {
       TaskManager taskManager = TaskManager.manager();
        taskManager.addTask("Do Home Work");
        taskManager.addTask("Study");
        taskManager.addTask("Draw");

        System.out.println(taskManager.getTasks().getFirst().getCreatedAt());
    }
}