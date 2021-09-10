package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Tag;
import com.example.demo.repository.TagRepository;

@Component
@Transactional
public class TagService {
    
	@Autowired
	private TagRepository tagRepository;

	public Tag getById(String id) {
		Tag tag = tagRepository.getById(id);
		return tag;
	}

	public String createTag(String title, String color) {
		Tag tag = new Tag();
		
		tag.setTitle(title);
		tag.setColor(color);
		
		tagRepository.save(tag);
		
		return "created";
	}

	public String updateTag(String id, String title, String color) {
	
		Tag tag = tagRepository.getById(id);
		tag.setTitle(title);
		tag.setColor(color);
		
		tagRepository.save(tag);
		
		return "updated";
	}

	public String deleteTag(String id) {
		
		Tag tag = tagRepository.getById(id);
        tagRepository.delete(tag);
		
		return "deleted";
	}
	
	
}
