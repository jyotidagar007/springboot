package com.example.demo.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.sun.istack.NotNull;

@Entity
@Table(name = "task")
public class Task {
		    @Id
		    @GeneratedValue(generator = "system-uuid")
		    @GenericGenerator(name = "system-uuid", strategy = "uuid")
	    	public String id;
		    
		    @Column(name="S.no")
		    public int s_no;
		    
//		    @Column(name = "Time")
//		    private String time;
		    
		    @Column(name="Task")
		    private String text;
		    
		    @Column(name="Description")
		    private String desc;
		    
		    @Column(name="Tag")
		    private String tag;
		    
//		    private String prio;
//		    
//		    private String complete;
//		    
//		    private String col;
		    
		    public String getTask() {
		        return text;
		    }

		    public void setTask(String text) {
		        this.text = text;
		    }
		    
		    
//		    public int getS_no() {
//		        return s_no;
//		    }

		    public void setS_no(int s_no) {
		        this.s_no = s_no;
		    }
		    
		    
		    public String getDesc() {
		        return desc;
		    }

		    public void setDesc(String desc) {
		        this.desc = desc;
		    }
		    
		    public String getTag() {
		        return tag;
		    }

		    public void setTag(String tag) {
		        this.tag = tag;
		    }
		    
		    @java.lang.Override
		    public java.lang.String toString() {
		        return "Task{" +
		                "id='" + id + '\'' +
		                ", S.No='" + s_no + '\'' +
		                ", task='" + text + '\'' +
		                ", description='" + desc + '\'' +
		                ", tag='" + tag + '\'' +
		                '}';
		    }

}
