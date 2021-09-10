package com.example.demo.service;

import java.util.*;

import javax.transaction.Transactional;
import java.lang.Iterable;

import org.springframework.beans.factory.annotation.Autowired;
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
	 private static final int Iterable = 0;
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
	    

	    public List<TaskDTO> getTasksByUserId(String userId) {
	  
			List<Task> task = repository.findAllByUserId(userId);
	       
	    	 return TaskTransformation.fromEntity(task);
	    }
	    
	    
	    public List<TaskDTO> getCompletedTasksByUserId(String userId) {
	    	
	    	List<Task> list = repository.findAllByUserId(userId);
	    	List<Task> newList = new ArrayList<Task>();
	    	
	    	for(int i=0;i<list.size();i++)
			{
			    Task task = list.get(i);
			    
			    if(task.isComplete());
			    {
			    	newList.add(task);
			    }
			    
			} 
	    	
	    	return TaskTransformation.fromEntity(newList);
		}
	    
	    
	    public List<TaskDTO> getIncompletedTasksByUserId(String userId) {
	    	
	    	List<Task> list = repository.findAllByUserId(userId);
             List<Task> newList = new ArrayList<Task>();
	    	
	    	for(int i=0;i<list.size();i++)
			{
			    Task task = list.get(i);
			    
			    if(!task.isComplete());
			    {
			    	newList.add(task);
			    }
			    
			}
	    	
	    	return TaskTransformation.fromEntity(newList);
        }

	    public TaskDTO createTask(TaskDTO taskDTO) {

	        Task task = new Task();
	        User user = userRepository.getById(taskDTO.getUserId());
	       
	        Date date = new Date();
            task.setDateCreated(date);
	        task.setTitle(taskDTO.getTitle());
	        task.setDesc(taskDTO.getDesc());
	        task.setUser(user);
	        
	        repository.save(task);

	        return taskDTO;
	    }
	    
	    public TaskDTO updateTask(TaskDTO taskDTO) {
	    	
	    	 Task task = repository.findByTitle(taskDTO.getTitle());
	    	 
	             
	             Date date = new Date();
	             task.setLastUpdated(date);
	             task.setTitle(taskDTO.getTitle());
	             task.setDesc(taskDTO.getDesc());
	          
	             repository.save(task);
	             return taskDTO;
	        
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
