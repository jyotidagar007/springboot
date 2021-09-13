package com.example.demo.service;

import java.util.*;

import javax.transaction.Transactional;
import java.lang.Iterable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.example.demo.dto.TaskDTO;
import com.example.demo.dto.transformation.TaskTransformation;
import com.example.demo.entity.Tag;
import com.example.demo.entity.Task;
import com.example.demo.entity.User;

import com.example.demo.repository.TagRepository;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.UserRepository;

@Component
@Transactional
public class TaskService {
	private @Autowired
	    TaskRepository repository;
	 private @Autowired
	    UserRepository userRepository;
	 private @Autowired
	     TagRepository tagRepository;
	 

	    public TaskDTO getById(String id) {
	        Task task = repository.getById(id);
	        return TaskTransformation.fromEntity(task);
	    }
	    

	    public List<TaskDTO> getTasksByUserId(String userId, Boolean complete, int page) {
	    	
	    	Pageable pageable = PageRequest.of(page, 5);
	  
		    Page<Task> tasks = repository.findAllByUserIdAndIsCompleteAndFlag(userId, complete, false, pageable);
  
	    	 return TaskTransformation.fromEntity(tasks);
	    }
	   

	    public TaskDTO createTask(TaskDTO taskDTO) {
	    	
	    	Task task = new Task();
	    	
	    	if(taskDTO.getId() != null)
	    	{
	    		task = repository.getById(taskDTO.getId());
	    	}

	        User user = userRepository.getById(taskDTO.getUserId());
	        
	        List<String> tagIds = taskDTO.getTagIds();
	        
	        List<Tag> tags = new ArrayList<Tag>();
	        
	        for(int i=0; i<tagIds.size(); i++)
			{
			    Tag tag = tagRepository.getById(tagIds.get(i));
			    
			    	tags.add(tag);
			} 
	        
	        System.out.println(tags);
	        
	        Date date = new Date();
            task.setDateCreated(date);
            
	        task.setTitle(taskDTO.getTitle());
	        task.setDesc(taskDTO.getDesc());
	        task.setUser(user);
	        
	        task.setTags(tags);
	        
	        repository.save(task);
	        
	        //return taskDTO;

	        return TaskTransformation.fromEntity(task);
	    }
	    
	    public TaskDTO updateTask(TaskDTO taskDTO) {
	    	
	    	return createTask(taskDTO);
	        
	    }
	    
		public String updateComplete(String id) {
			Task task = repository.getById(id);
			task.setComplete(true);
			return "task completed";
		}
		

		public String updateDelete(String id) {
			Task task = repository.getById(id);
			task.setFlag(true);
			return "soft deleted";
		}

	    
	    public String deleteTask(String id) {
	   	    Task task = repository.getById(id);
	           repository.delete(task);
	           return "hard deleted";
	   }

	
}
