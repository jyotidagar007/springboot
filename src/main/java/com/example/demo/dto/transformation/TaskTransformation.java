package com.example.demo.dto.transformation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.dto.TaskDTO;
import com.example.demo.entity.Task;
import com.example.demo.entity.User;
import com.example.demo.entity.Tag;

public class TaskTransformation {
	 public static TaskDTO fromEntity(Task task) {
	    	
	    	TaskDTO taskDTO = new TaskDTO();
	    	
	    	taskDTO.setTitle(task.getTitle());
	    	taskDTO.setDesc(task.getDesc());
	    	
	    	User user = task.getUser();
	    	taskDTO.setUserId(user.getId());
	    	
	    	List<Tag> tags = task.getTags();
	    	List<String> tagIds = new ArrayList<String>();
	    	
	    	for(int i=0; i<tags.size(); i++)
			{	
			    Tag tag = tags.get(i);  
			    tagIds.add(tag.getId());	    
			} 
	    			
	    	taskDTO.setTagIds(tagIds);
	    	
	    	return taskDTO;
	    }

	public static List<TaskDTO> fromEntity(Page<Task> page) {
		
		 List<Task> list = page.getContent();
				
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
