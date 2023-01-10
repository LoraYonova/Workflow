package com.example.workflow.model.entity;

import com.example.workflow.model.entity.enums.RoleEnum;
import com.example.workflow.model.entity.enums.TaskEnum;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class TaskEntity extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskEnum taskEnum;

    public TaskEntity() {
    }

    public TaskEnum getTaskEnum() {
        return taskEnum;
    }

    public TaskEntity setTaskEnum(TaskEnum taskEnum) {
        this.taskEnum = taskEnum;
        return this;
    }
}
