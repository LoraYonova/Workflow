package com.example.workflow.model.DTO;

import com.example.workflow.model.entity.enums.TaskEnum;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TaskDTO {

    @NotEmpty
    @Size(min = 2, message = "Task name must be more than 2 characters")
    private String taskName;

    @NotNull
    private TaskEnum taskEnum;

    public TaskDTO() {
    }

    public String getTaskName() {
        return taskName;
    }

    public TaskDTO setTaskName(String taskName) {
        this.taskName = taskName;
        return this;
    }

    public TaskEnum getTaskEnum() {
        return taskEnum;
    }

    public TaskDTO setTaskEnum(TaskEnum taskEnum) {
        this.taskEnum = taskEnum;
        return this;
    }
}
