package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

	 private @Autowired
	    TaskService taskService;
	    
		@GetMapping(value = "/get")
	    public ResponseEntity getByS_no(int s_no) {
	        return ResponseEntity.ok(taskService.getByS_no(s_no));
	    }
		
		@PostMapping(value = "/create")
	    public ResponseEntity createTask(String text, String desc, String tag) {
	       Task task = taskService.createTask(text, desc, tag);
	        return ResponseEntity.ok(task);
	    }
		
		@PutMapping(value = "/update")
		public ResponseEntity updateTask(int s_no, String text, String desc,String tag)
		{
			return ResponseEntity.ok(taskService.updateTask(s_no, text, desc, tag));
		}
		
		@DeleteMapping(value = "/delete")
		public ResponseEntity deleteTask(int s_no)
		{
			return ResponseEntity.ok(taskService.deleteTask(s_no));
		}

}
