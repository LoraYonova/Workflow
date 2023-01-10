package com.example.workflow.service;

import com.example.workflow.model.entity.TaskEntity;
import com.example.workflow.model.entity.enums.TaskEnum;

import java.util.List;

public interface TaskService {
    void initializeTasks();


    TaskEntity findByTask(TaskEnum name);
}
