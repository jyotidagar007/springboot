package com.example.demo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.demo.entity.Tag;

public class TaskDTO {
		    
		    private String title;
		    
		    private String desc;
		    
		    private String userId;
		    
		    List<String> tagList= new ArrayList<String>();

			public String getTitle() {
		        return title;
		    }

		    public void setTitle(String title) {
		        this.title = title;
		    }
		    
		    
		    public String getDesc() {
		        return desc;
		    }

		    public void setDesc(String desc) {
		        this.desc = desc;
		    }
		    

			public List<String> getTagList() {
				return tagList;
			}

			public void setTagList(List<String> tagList) {
				this.tagList = tagList;
			}

			public String getUserId() {
				return userId;
			}

			public void setUserId(String userId) {
				this.userId = userId;
			}

			
		    
		
	}
		    
