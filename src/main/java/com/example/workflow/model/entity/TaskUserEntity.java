package com.example.workflow.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "tasks_users")
public class TaskUserEntity extends BaseEntity {

    @Column(nullable = false)
    private String taskName;

    @ManyToOne
    private TaskEntity task;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime time;

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

    public LocalDate getDate() {
        return date;
    }

    public TaskUserEntity setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public LocalTime getTime() {
        return time;
    }

    public TaskUserEntity setTime(LocalTime time) {
        this.time = time;
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
