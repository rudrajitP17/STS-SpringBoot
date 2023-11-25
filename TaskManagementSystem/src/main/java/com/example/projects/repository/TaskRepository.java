package com.example.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projects.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{

}
