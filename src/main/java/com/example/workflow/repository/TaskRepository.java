package com.example.workflow.repository;

import com.example.workflow.model.entity.TaskEntity;
import com.example.workflow.model.entity.enums.TaskEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    Optional<TaskEntity> findByTaskEnum(TaskEnum taskEnum);
}
