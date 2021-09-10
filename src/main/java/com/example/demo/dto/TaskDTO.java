package com.example.demo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.example.demo.entity.Tag;

public class TaskDTO {
		    
		    private String title;
		    
		    private String desc;
		    
           private boolean isComplete;
		    
		    private boolean flag;
		    
		    private Date dateCreated;
           
			private Date lastUpdated;
		    
		    private String userId;
		    
		    List<String> tagList= new ArrayList<String>();
		    
		    

			public boolean isComplete() {
				return isComplete;
			}

			public void setComplete(boolean isComplete) {
				this.isComplete = isComplete;
			}

			public boolean isFlag() {
				return flag;
			}

			public void setFlag(boolean flag) {
				this.flag = flag;
			}

			public Date getDateCreated() {
				return dateCreated;
			}

			public void setDateCreated(Date dateCreated) {
				this.dateCreated = dateCreated;
			}

			public Date getLastUpdated() {
				return lastUpdated;
			}

			public void setLastUpdated(Date lastUpdated) {
				this.lastUpdated = lastUpdated;
			}

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
		    
