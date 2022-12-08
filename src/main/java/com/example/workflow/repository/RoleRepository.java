package com.example.workflow.repository;

import com.example.workflow.model.entity.RoleEntity;
import com.example.workflow.model.entity.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByRole(RoleEnum admin);
}
