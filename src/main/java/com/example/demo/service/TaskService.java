package com.example.demo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;

@Component
@Transactional
public class TaskService {
	 private @Autowired
	    TaskRepository repository;
	 
	    public int i = 0;

	    public String getByS_no(int s_no) {
	        Optional<Task> entity = repository.findByS_No(s_no);
	        if(entity.isPresent()){
	            return entity.get().toString();
	        }else{
	            return "Not found";
	        }
	    }

	    public Task createTask(String text, String desc, String tag) {

	        Task task = new Task();
	        
	        i++;
	        task.setS_no(i);
	        task.setTask(text);
	        task.setDesc(desc);
	        task.setTag(tag);
	        
	        repository.save(task);

	        return task;
	    }
	    
	    public String updateTask(int s_no, String text, String desc, String tag) {
	    	 Optional<Task> entity = repository.findByS_No(s_no);
	         if(entity.isPresent())
	         {
	            Task task = entity.get();
	             task.setTask(text);
	             task.setDesc(desc);
	             task.setTag(tag);
	            
	             repository.save(task);
	             return "Data updated";
	         }else{
	             return "Not found";
	         }
	    }
	    
	    public String deleteTask(int s_no) {
	   	 Optional<Task> entity = repository.findByS_No(s_no);
	        if(entity.isPresent())
	        {
	           Task task = entity.get();
	           repository.deleteById(task.id);
	           return "deleted";
	       }
	        else{
	            return "Not found";
	        }
	   }
	
}
