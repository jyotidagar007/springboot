package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Task;


public interface TaskRepository extends JpaRepository<Task, String>{

	Task findByTitle(String title);

	public Page<Task> findAllByUserIdAndIsCompleteAndFlag(String userId, Boolean complete, Boolean flag, Pageable pePageable);

}
