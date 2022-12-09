package com.example.workflow.init;

import com.example.workflow.service.UserService;
import com.example.workflow.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final RoleService roleService;
    private final UserService userService;

    public DBInit(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        roleService.initializeRole();
        userService.initializeAdmin();
    }
}
