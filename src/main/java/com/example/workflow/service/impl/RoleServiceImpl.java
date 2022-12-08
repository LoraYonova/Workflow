package com.example.workflow.service.impl;

import com.example.workflow.model.entity.RoleEntity;
import com.example.workflow.model.entity.enums.RoleEnum;
import com.example.workflow.repository.RoleRepository;
import com.example.workflow.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public void initializeRole() {

        if (roleRepository.count() == 0) {
            RoleEntity admin = new RoleEntity();
            admin.setRole(RoleEnum.ADMIN);

            RoleEntity company = new RoleEntity();
            company.setRole(RoleEnum.USER);

            roleRepository.saveAll(List.of(admin, company));
        }
    }
}
