package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "task")
public class Task {
		    @Id
		    @GeneratedValue(generator = "system-uuid")
		    @GenericGenerator(name = "system-uuid", strategy = "uuid")
	    	public String id;
		    
		    @Column(name="title")
		    private String title;
		    
		    @Column(name="description")
		    private String desc;
		    
		    private boolean isComplete = false;
		    
		    private boolean flag;
		    
		    @Column(name="Date_Created")
		    private Date dateCreated;
            
		    @Column(name="Date_Updated")
			private Date lastUpdated;
		    
		    @ManyToOne(fetch = FetchType.LAZY, optional = false)
		    @JoinColumn(nullable = false)
		    private User user;
		    
		    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		    List<Tag> tagList= new ArrayList<Tag>();
		    

			public Task() {
			}
		    
		    
	

			public Task(String id, String title, String desc, User user, List<Tag> tagList) {
				super();
				this.id = id;
				this.title = title;
				this.desc = desc;
				this.user = user;
				this.tagList = tagList;
			}




			public boolean isFlag() {
				return flag;
			}


			public void setFlag(boolean flag) {
				this.flag = flag;
			}


			public boolean isComplete() {
				return isComplete;
			}


			public void setComplete(boolean isComplete) {
				this.isComplete = isComplete;
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
		    
		    
		    public String getDesc() {
		        return desc;
		    }

		    public void setDesc(String desc) {
		        this.desc = desc;
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
		    
		    @java.lang.Override
		    public java.lang.String toString() {
		        return "Task{" +
		                "id='" + id + '\'' +
		                ", title='" + title + '\'' +
		                ", description='" + desc + '\'' +
		                ", date='" + dateCreated + '\'' +
		                '}';
		    }


			public List<Tag> getTagList() {
				return tagList;
			}


			public void setTagList(List<Tag> tagList) {
				this.tagList = tagList;
			}


			

}
