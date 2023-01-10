package com.example.workflow.init;

import com.example.workflow.service.TaskService;
import com.example.workflow.service.UserService;
import com.example.workflow.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final RoleService roleService;
    private final UserService userService;
    private final TaskService taskService;

    public DBInit(RoleService roleService, UserService userService, TaskService taskService) {
        this.roleService = roleService;
        this.userService = userService;
        this.taskService = taskService;
    }

    @Override
    public void run(String... args) throws Exception {

        roleService.initializeRole();
        userService.initializeAdmin();
        taskService.initializeTasks();

    }
}
