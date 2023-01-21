package com.example.workflow.model.service;

import com.example.workflow.model.entity.enums.TaskEnum;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class TaskServiceModel {

    private String taskName;
    private TaskEnum taskEnum;
    private LocalDate date;
    private LocalTime time;

    public TaskServiceModel() {
    }

    public String getTaskName() {
        return taskName;
    }

    public TaskServiceModel setTaskName(String taskName) {
        this.taskName = taskName;
        return this;
    }

    public TaskEnum getTaskEnum() {
        return taskEnum;
    }

    public TaskServiceModel setTaskEnum(TaskEnum taskEnum) {
        this.taskEnum = taskEnum;
        return this;
    }

    public String getDate() {
        return date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
    }

    public TaskServiceModel setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public LocalTime getTime() {
        return time;
    }

    public TaskServiceModel setTime(LocalTime time) {
        this.time = time;
        return this;
    }
}
