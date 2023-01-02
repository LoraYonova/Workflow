package com.example.workflow.model.view;

public class UserView {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String picture;

    public UserView() {
    }

    public Long getId() {
        return id;
    }

    public UserView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserView setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserView setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserView setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserView setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPicture() {
        return picture;
    }

    public UserView setPicture(String picture) {
        this.picture = picture;
        return this;
    }
}
