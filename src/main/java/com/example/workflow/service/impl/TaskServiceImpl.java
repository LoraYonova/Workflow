package com.example.workflow.service.impl;

import com.example.workflow.model.entity.TaskEntity;
import com.example.workflow.model.entity.enums.TaskEnum;
import com.example.workflow.repository.TaskRepository;
import com.example.workflow.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void initializeTasks() {

        if (taskRepository.count() == 0) {
            Arrays.stream(TaskEnum.values())
                    .forEach(taskEnum -> {
                        TaskEntity task = new TaskEntity();
                        task.setTaskEnum(taskEnum);
                        taskRepository.save(task);
                    });

        }

    }

    @Override
    public TaskEntity findByTask(TaskEnum name) {
        return taskRepository.findByTaskEnum(name).orElse(null);
    }


}
