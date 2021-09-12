package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Task;


public interface TaskRepository extends JpaRepository<Task, String>{

	Task findByTitle(String title);

	List<Task> findAllByUserIdAndIsCompleteAndFlag(String userId, Boolean complete, Boolean flag);

}
