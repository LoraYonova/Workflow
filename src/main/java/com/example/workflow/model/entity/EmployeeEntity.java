package com.example.workflow.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class EmployeeEntity extends BaseEntity {

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String image;

    @ManyToOne
    private CompanyEntity companyEntity;

    public EmployeeEntity() {
    }

    public String getFullName() {
        return fullName;
    }

    public EmployeeEntity setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public EmployeeEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getImage() {
        return image;
    }

    public EmployeeEntity setImage(String image) {
        this.image = image;
        return this;
    }

    public CompanyEntity getCompanyEntity() {
        return companyEntity;
    }

    public EmployeeEntity setCompanyEntity(CompanyEntity companyEntity) {
        this.companyEntity = companyEntity;
        return this;
    }
}
