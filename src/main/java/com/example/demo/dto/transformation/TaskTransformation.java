package com.example.demo.dto.transformation;

import com.example.demo.dto.TaskDTO;
import com.example.demo.entity.Task;

public class TaskTransformation {
	 public static TaskDTO fromEntity(Task task) {
	    	
	    	TaskDTO taskDTO = new TaskDTO();
	    	taskDTO.setTitle(task.getTitle());
	    	taskDTO.setDesc(task.getDesc());
	 //   	taskDTO.setTag(task.getTag());
	    	
	    	return taskDTO;
	    }
}
