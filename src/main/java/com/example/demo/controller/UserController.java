package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;

import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
    private @Autowired
    UserService userService;
    
	@GetMapping(value = "/get/username")
    public ResponseEntity getByUserName(String username) {
        return ResponseEntity.ok(userService.getByUserName(username));
    }
	
	@GetMapping(value = "/get/id")
    public ResponseEntity getById(String id) {
        return ResponseEntity.ok(userService.getById(id));
    }
	
	@PostMapping(value = "/create")
    public ResponseEntity createUser(@RequestBody UserDTO userDTO) {
        User user = userService.createUser(userDTO);
        return ResponseEntity.ok(user);
    }
	
	@PutMapping(value = "/update")
	public ResponseEntity updateUser(@RequestBody UserDTO userDTO)
	{
		  User user = userService.updateUser(userDTO);
	        return ResponseEntity.ok(user);
	}
	
	@DeleteMapping(value = "/delete")
	public ResponseEntity deleteUser(String username)
	{
		return ResponseEntity.ok(userService.deleteUser(username));
	}
}
