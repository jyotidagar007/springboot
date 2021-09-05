package com.example.demo.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.entity.User;
import com.example.demo.repository.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Component
@Transactional
public class UserService {

    private @Autowired
    UserRepository repository;

    public String getByUserName(String username) {
        Optional<User> entity = repository.findByUsername(username);
        if(entity.isPresent()){
            return entity.get().toString();
        }else{
            return "Not found";
        }
    }

    public User createUser(String firstName, String lastName, String username, String password) {

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setPassword(password);
        repository.save(user);

        return user;
    }
    
    public String updateUser(String firstName, String lastName, String username, String password) {
    	 Optional<User> entity = repository.findByUsername(username);
         if(entity.isPresent())
         {
            User user = entity.get();
             user.setFirstName(firstName);
             user.setLastName(lastName);
             user.setUsername(username);
             user.setPassword(password);
             repository.save(user);
             return "Data updated";
         }else{
             return "Not found";
         }
    }
    
    public String deleteUser(String username) {
   	 Optional<User> entity = repository.findByUsername(username);
        if(entity.isPresent())
        {
           User user = entity.get();
           repository.deleteById(user.id);
           return "deleted";
       }
        else{
            return "Not found";
        }
   }
}

