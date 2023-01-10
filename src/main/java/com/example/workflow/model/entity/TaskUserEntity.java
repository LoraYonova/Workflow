package com.example.workflow.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tasks_users")
public class TaskUserEntity extends BaseEntity {

    @Column(nullable = false)
    private String taskName;

    @ManyToOne
    private TaskEntity task;

    @ManyToOne(cascade = CascadeType.MERGE)
    private UserEntity userId;

    public TaskUserEntity() {
    }

    public String getTaskName() {
        return taskName;
    }

    public TaskUserEntity setTaskName(String taskName) {
        this.taskName = taskName;
        return this;
    }

    public TaskEntity getTask() {
        return task;
    }

    public TaskUserEntity setTask(TaskEntity task) {
        this.task = task;
        return this;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public TaskUserEntity setUserId(UserEntity userId) {
        this.userId = userId;
        return this;
    }
}
