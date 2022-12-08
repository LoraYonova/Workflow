package com.example.workflow.model.entity;

import com.example.workflow.model.entity.enums.RoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    public RoleEntity() {
    }

    public RoleEnum getRole() {
        return role;
    }

    public RoleEntity setRole(RoleEnum role) {
        this.role = role;
        return this;
    }
}
