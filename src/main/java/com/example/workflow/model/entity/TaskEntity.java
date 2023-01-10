package com.example.workflow.model.entity;

import com.example.workflow.model.entity.enums.TaskEnum;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class TaskEntity extends BaseEntity {

    @Column(nullable = false)
    private String taskName;

    @Enumerated(EnumType.STRING)
    private TaskEnum taskEnum;

    @ManyToOne
    private UserEntity userId;

    public TaskEntity() {
    }

    public String getTaskName() {
        return taskName;
    }

    public TaskEntity setTaskName(String taskName) {
        this.taskName = taskName;
        return this;
    }

    public TaskEnum getTaskEnum() {
        return taskEnum;
    }

    public TaskEntity setTaskEnum(TaskEnum taskEnum) {
        this.taskEnum = taskEnum;
        return this;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public TaskEntity setUserId(UserEntity userId) {
        this.userId = userId;
        return this;
    }
}
