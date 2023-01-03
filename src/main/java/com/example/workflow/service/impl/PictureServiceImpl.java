package com.example.workflow.service.impl;

import com.example.workflow.model.entity.PictureEntity;
import com.example.workflow.repository.PictureRepository;
import com.example.workflow.service.CloudinaryService;
import com.example.workflow.service.PictureService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;
    private final CloudinaryService cloudinaryService;

    public PictureServiceImpl(PictureRepository pictureRepository, CloudinaryService cloudinaryService) {
        this.pictureRepository = pictureRepository;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public void savePicture(PictureEntity picture) {
        pictureRepository.save(picture);
    }

    @Override
    public PictureEntity createPictureEntity(MultipartFile picture) throws IOException {
        CloudinaryImage upload = cloudinaryService.upload(picture);
        PictureEntity pictureEntity = new PictureEntity();

        pictureEntity.setPublicId(upload.getPublicId());
        pictureEntity.setUrl(upload.getUrl());
        return pictureEntity;

    }

    @Override
    public void delete(String id) {
        pictureRepository.deleteByPublicId(id);
    }
}
