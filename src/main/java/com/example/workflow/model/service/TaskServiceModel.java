package com.example.workflow.model.service;

import com.example.workflow.model.entity.enums.TaskEnum;

public class TaskServiceModel {

    private String taskName;
    private TaskEnum taskEnum;
//    private Long userId;

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

//    public Long getUserId() {
//        return userId;
//    }
//
//    public TaskServiceModel setUserId(Long userId) {
//        this.userId = userId;
//        return this;
//    }
}
