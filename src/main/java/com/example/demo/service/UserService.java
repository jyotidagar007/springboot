package com.example.demo.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
public class UserService {

    public String getByUserName() {
        return "hello world";
    }
	
    public String createUser() {
        return "hello world";
    }
}
