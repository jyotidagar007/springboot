package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.User;

import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
    private @Autowired
    UserService userService;
    
	@GetMapping(value = "/get")
    public ResponseEntity getByUserName(String username) {
        return ResponseEntity.ok(userService.getByUserName(username));
    }
	
	@PostMapping(value = "/create")
    public ResponseEntity createUser( String firstName, String lastName, String username, String password) {
        User user = userService.createUser(firstName, lastName, username, password);
        return ResponseEntity.ok(user);
    }
	
	@PutMapping(value = "/update")
	public ResponseEntity updateUser(String firstName, String lastName,String username, String password)
	{
		return ResponseEntity.ok(userService.updateUser(firstName, lastName, username, password));
	}
	
	@DeleteMapping(value = "/delete")
	public ResponseEntity deleteUser(String username)
	{
		return ResponseEntity.ok(userService.deleteUser(username));
	}
}
