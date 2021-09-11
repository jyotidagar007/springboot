package com.example.demo.dto.transformation;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.TaskDTO;
import com.example.demo.entity.Task;

public class TaskTransformation {
	 public static TaskDTO fromEntity(Task task) {
	    	
	    	TaskDTO taskDTO = new TaskDTO();
	    	
	    	taskDTO.setTitle(task.getTitle());
	    	taskDTO.setDesc(task.getDesc());
	    	taskDTO.setDateCreated(task.getDateCreated());	
	    	taskDTO.setComplete(task.isComplete());
	    	
	    	return taskDTO;
	    }

	public static List<TaskDTO> fromEntity(List<Task> list) {
		
		 List<TaskDTO> listDTO = new ArrayList<>();
		
			for(int i=0;i<list.size();i++)
			{
				
			    Task task = list.get(i);  
			    TaskDTO taskDTO = fromEntity(task);   
			    listDTO.add(taskDTO);
			} 
		
		return listDTO;
	}
}
