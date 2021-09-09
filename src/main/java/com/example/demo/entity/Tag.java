package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tag")
public class Tag {
	
	@Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "color")
	private String color;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	List<Task> taskList = new ArrayList<Task>();
	
	
	public Tag() {
		super();
	}



	public Tag(String id, String title, String color, List<Task> taskList) {
		super();
		this.id = id;
		this.title = title;
		this.color = color;
		this.taskList = taskList;
	}



	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	

	
	
	
}
