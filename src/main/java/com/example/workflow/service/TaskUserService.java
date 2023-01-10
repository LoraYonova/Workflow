package com.example.workflow.service;

import com.example.workflow.model.DTO.TaskDTO;
import com.example.workflow.model.service.TaskServiceModel;

public interface TaskUserService {

    void addTask(TaskDTO taskDTO, String name);


}
