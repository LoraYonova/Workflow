package com.example.workflow.repository;

import com.example.workflow.model.entity.TaskUserEntity;
import com.example.workflow.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskUserRepository extends JpaRepository<TaskUserEntity, Long> {

    List<TaskUserEntity> findTaskUserEntityByUserId_Id(Long id);
}
