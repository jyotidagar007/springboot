package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
    private @Autowired
    UserService userService;
    
	@PostMapping(value = "/get")
    public String getByUserName() {
        return "hello world";
    }
	
	@PostMapping(value = "/create")
    public String createUser(String email) {
        return email;
    }
}
