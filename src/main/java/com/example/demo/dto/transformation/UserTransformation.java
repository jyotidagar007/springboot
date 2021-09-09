package com.example.demo.dto.transformation;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;

public class UserTransformation {
    public static UserDTO fromEntity(User user) {
    	
    	UserDTO userDTO = new UserDTO();
    	userDTO.setFirstName(user.getFirstName());
    	userDTO.setLastName(user.getLastName());
    	userDTO.setUsername(user.getUsername());
    	
    	return userDTO;
    }
}
