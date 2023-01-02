package com.example.workflow.service;

import com.example.workflow.model.DTO.PictureDTO;
import com.example.workflow.model.DTO.UserRegisterDTO;
import com.example.workflow.model.service.UserServiceModel;
import com.example.workflow.model.view.UserView;
import com.example.workflow.service.impl.CloudinaryImage;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {
    void registerAndLoginUser(UserRegisterDTO userRegisterDTO);

    void initializeAdmin();

    UserView findByUsername(String username);


    void addProfilePicture(String name, PictureDTO pictureDTO) throws IOException;

    void updateProfile(UserServiceModel userServiceModel, String username);
}

