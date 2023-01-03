package com.example.workflow.model.view;

public class PictureView {

    private Long id;
    private String url;
    private String publicId;

    public PictureView() {
    }

    public Long getId() {
        return id;
    }

    public PictureView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public PictureView setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getPublicId() {
        return publicId;
    }

    public PictureView setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }
}
