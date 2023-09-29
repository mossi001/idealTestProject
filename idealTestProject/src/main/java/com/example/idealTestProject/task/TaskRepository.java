package com.example.idealTestProject.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository
        extends JpaRepository <Task, Long> {


    Optional<Task> findTaskById(Long id);
}
