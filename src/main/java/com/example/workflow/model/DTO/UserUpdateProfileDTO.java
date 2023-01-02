package com.example.workflow.model.DTO;

import com.example.workflow.model.validation.UniqueEmail;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserUpdateProfileDTO {


    @NotEmpty
    @Size(min = 2, max = 20)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 20)
    private String lastName;

    @NotEmpty
    @UniqueEmail(message = "Email already used!")
    @Email(message = "User email should be valid.")
    private String email;


    public UserUpdateProfileDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public UserUpdateProfileDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserUpdateProfileDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserUpdateProfileDTO setEmail(String email) {
        this.email = email;
        return this;
    }
}
