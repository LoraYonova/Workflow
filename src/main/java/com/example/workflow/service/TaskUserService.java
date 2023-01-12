package com.example.workflow.service;

import com.example.workflow.model.DTO.TaskDTO;
import com.example.workflow.model.entity.TaskEntity;
import com.example.workflow.model.entity.TaskUserEntity;
import com.example.workflow.model.service.TaskServiceModel;
import com.example.workflow.model.view.TaskUserView;

import java.util.List;

public interface TaskUserService {

    void addTask(TaskServiceModel taskServiceModel, String name);


    List<TaskUserEntity> findTaskByUser(String name);
}
