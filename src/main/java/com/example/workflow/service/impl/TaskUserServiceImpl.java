package com.example.workflow.service.impl;

import com.example.workflow.model.DTO.TaskDTO;
import com.example.workflow.model.entity.TaskEntity;
import com.example.workflow.model.entity.TaskUserEntity;
import com.example.workflow.model.entity.UserEntity;
import com.example.workflow.model.entity.enums.TaskEnum;
import com.example.workflow.model.service.TaskServiceModel;
import com.example.workflow.model.view.TaskUserView;
import com.example.workflow.model.view.UserView;
import com.example.workflow.repository.TaskUserRepository;
import com.example.workflow.service.TaskService;
import com.example.workflow.service.TaskUserService;
import com.example.workflow.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class TaskUserServiceImpl implements TaskUserService {

    private final TaskUserRepository taskUserRepository;
    private final UserService userService;
    private final TaskService taskService;
    private final ModelMapper modelMapper;

    public TaskUserServiceImpl(TaskUserRepository taskUserRepository, UserService userService, TaskService taskService, ModelMapper modelMapper) {
        this.taskUserRepository = taskUserRepository;
        this.userService = userService;
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }


    @Override
    public void addTask(TaskServiceModel taskServiceModel, String name) {

        TaskUserEntity task = new TaskUserEntity();
        task.setUserId(modelMapper.map(userService.findByUsername(name), UserEntity.class));
        task.setTaskName(taskServiceModel.getTaskName());
        task.setTask(taskService.findByTask(taskServiceModel.getTaskEnum()));
        task.setDate(LocalDate.now());
        task.setTime(LocalTime.now());


        taskUserRepository.save(task);

    }

    @Override
    public List<TaskUserEntity> findTaskByUser(String name) {
        UserView username = userService.findByUsername(name);
        Long userId = username.getId();
        List<TaskUserEntity> taskUserEntityByUserId_id = taskUserRepository.findTaskUserEntityByUserId_Id(userId);
        TaskUserView taskUserView = modelMapper.map(taskUserEntityByUserId_id, TaskUserView.class);
        return taskUserEntityByUserId_id;
    }


}
