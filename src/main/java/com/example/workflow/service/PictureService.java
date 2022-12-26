package com.example.workflow.service;

import com.example.workflow.model.entity.PictureEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PictureService {

    void savePicture(PictureEntity picture);

    PictureEntity createPictureEntity(MultipartFile picture) throws IOException;
}
