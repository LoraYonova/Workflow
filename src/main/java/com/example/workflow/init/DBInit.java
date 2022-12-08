package com.example.workflow.init;

import com.example.workflow.service.UserService;
import com.example.workflow.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final RoleService roleService;
    private final UserService companyService;

    public DBInit(RoleService roleService, UserService companyService) {
        this.roleService = roleService;
        this.companyService = companyService;
    }

    @Override
    public void run(String... args) throws Exception {

        roleService.initializeRole();
        companyService.initializeAdmin();
    }
}
