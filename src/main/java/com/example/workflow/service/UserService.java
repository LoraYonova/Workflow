package com.example.workflow.service;

import com.example.workflow.model.DTO.UserRegisterDTO;

public interface UserService {
    void registerAndLoginUser(UserRegisterDTO userRegisterDTO);

    void initializeAdmin();
}
