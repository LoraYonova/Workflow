package com.example.workflow.model.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class TaskDTO {

    @NotEmpty
    @Size(min = 2, message = "Task name must be more than 2 characters")
    private String taskName;

    @NotEmpty
    private String taskEnum;

    public TaskDTO() {
    }

    public String getTaskName() {
        return taskName;
    }

    public TaskDTO setTaskName(String taskName) {
        this.taskName = taskName;
        return this;
    }

    public String getTaskEnum() {
        return taskEnum;
    }

    public TaskDTO setTaskEnum(String taskEnum) {
        this.taskEnum = taskEnum;
        return this;
    }
}
