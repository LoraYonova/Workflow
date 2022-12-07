package com.example.workflow.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "companies")
public class CompanyEntity extends BaseEntity {

    @Column(name = "company_name", nullable = false, unique = true)
    private String companyName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    public CompanyEntity() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public CompanyEntity setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CompanyEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CompanyEntity setPassword(String password) {
        this.password = password;
        return this;
    }
}
