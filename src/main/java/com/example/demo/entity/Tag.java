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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "tag_id"),
             inverseJoinColumns = @JoinColumn(name = "task_id"))
	List<Task> tasks = new ArrayList<Task>();
	
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(nullable = false)
	private User user;
	
	
	public Tag() {
		super();
	}



	public Tag(String id, String title, String color, List<Task> taskList) {
		super();
		this.id = id;
		this.title = title;
		this.color = color;
		this.tasks = taskList;
	}



	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
