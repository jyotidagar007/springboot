package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.TaskDTO;
import com.example.demo.entity.Task;
import com.example.demo.entity.User;
import com.example.demo.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

	 private @Autowired
	    TaskService taskService;
	    
		@GetMapping(value = "/get")
	    public ResponseEntity getByTitle(String title) {
	        return ResponseEntity.ok(taskService.getByTitle(title));
	    }
		
		@GetMapping(value = "/get/tasks")
	    public ResponseEntity getTasksByUserId(String userId) {
	        return ResponseEntity.ok(taskService.getTasksByUserId(userId));
		}		
		
		@PostMapping(value = "/create")
	    public ResponseEntity createTask(@RequestBody TaskDTO taskDTO) {
	       Task task = taskService.createTask(taskDTO);
	        return ResponseEntity.ok(task);
	    }
		
		@PutMapping(value = "/update")
		public ResponseEntity updateTask(@RequestBody TaskDTO taskDTO)
		{
			return ResponseEntity.ok(taskService.updateTask(taskDTO));
		}
		
		@PutMapping(value = "/update/complete")
	    public ResponseEntity updateComplete(String id) {
	        return ResponseEntity.ok(taskService.updateComplete(id));
	    }
		
		@DeleteMapping(value = "/delete")
		public ResponseEntity deleteTask(String title)
		{
			return ResponseEntity.ok(taskService.deleteTask(title));
		}

}
