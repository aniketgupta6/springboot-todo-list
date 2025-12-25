package com.todoapp.to_do_app.repository;

import com.todoapp.to_do_app.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findBytaskName(String taskName);
}
