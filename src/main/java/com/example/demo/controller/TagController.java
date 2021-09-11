package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Tag;
import com.example.demo.service.TagService;

@RestController
@RequestMapping("/tag")
public class TagController {

	 private @Autowired
	    TagService tagService;
	    
		@GetMapping(value = "/get")
	    public ResponseEntity getById(String id) {
	        return ResponseEntity.ok(tagService.getById(id));
	    }		
		
		@PostMapping(value = "/create")
	    public ResponseEntity createTag(String title, String color, String userId) {
	        return ResponseEntity.ok(tagService.createTag(title, color, userId));
	    }
		
		@PutMapping(value = "/update")
		public ResponseEntity updateTag(String id, String title, String color)
		{
			return ResponseEntity.ok(tagService.updateTag(id, title, color));
		}
		
		
		@DeleteMapping(value = "/delete")
		public ResponseEntity deleteTag(String id)
		{
			return ResponseEntity.ok(tagService.deleteTag(id));
		}

}
