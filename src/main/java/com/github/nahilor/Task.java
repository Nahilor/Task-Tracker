package com.github.nahilor;

import java.time.LocalDate;

// Only handles Strings
public class Task {
    private String description;
    private Status currentStatus = Status.TO_DO;
    private final LocalDate createdAt;
    private LocalDate updatedAt;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Status currentstatus) {
        this.currentStatus = currentstatus;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDate date) {
        this.updatedAt = date;
    }

    private Task(String description) {
        this.description = description;
        this.createdAt = LocalDate.now();
    }

    public static Task toDo(String description) {
        return new Task(description);
    }
}
