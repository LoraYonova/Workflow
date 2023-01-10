package com.example.workflow.model.service;

public class TaskServiceModel {

    private String taskName;
    private String taskEnum;

    public TaskServiceModel() {
    }

    public String getTaskName() {
        return taskName;
    }

    public TaskServiceModel setTaskName(String taskName) {
        this.taskName = taskName;
        return this;
    }

    public String getTaskEnum() {
        return taskEnum;
    }

    public TaskServiceModel setTaskEnum(String taskEnum) {
        this.taskEnum = taskEnum;
        return this;
    }
}
