package com.example.workflow.service;

import com.example.workflow.model.DTO.PictureDTO;
import com.example.workflow.model.DTO.UserRegisterDTO;
import com.example.workflow.model.service.UserServiceModel;
import com.example.workflow.model.view.UserView;

import java.io.IOException;
import java.util.Locale;

public interface UserService {
    void registerAndLoginUser(UserRegisterDTO userRegisterDTO, Locale locale);

    void initializeAdmin();

    UserView findByUsername(String username);


    void addProfilePicture(String name, PictureDTO pictureDTO) throws IOException;

    void updateProfile(UserServiceModel userServiceModel, String email);

    UserServiceModel findUser(String username);

    void deletePicture(String name);


}


