package com.example.workflow.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

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

    public String getDate() {
        return date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
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
