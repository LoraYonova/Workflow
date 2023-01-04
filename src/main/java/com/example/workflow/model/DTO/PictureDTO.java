package com.example.workflow.model.DTO;

import org.springframework.web.multipart.MultipartFile;

public class PictureDTO {

    private MultipartFile picture;


    public MultipartFile getPicture() {
        return picture;
    }

    public PictureDTO setPicture(MultipartFile picture) {
        this.picture = picture;
        return this;
    }
}
