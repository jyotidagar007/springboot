package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Task;

public interface TaskRepository extends JpaRepository<Task, String>{

	Optional<Task> findByS_No(int s_no);
}
