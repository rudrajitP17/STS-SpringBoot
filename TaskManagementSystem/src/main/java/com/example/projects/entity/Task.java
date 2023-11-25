package com.example.projects.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "Task_Details")
public class Task implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Task_id")
	private long tid;
	
	@Column(name = "Task_Name")
	private String t_name;
	
	@Column(name = "Task_Department")
	private String t_dept;
	
	@Column(name = "Task_Durations")
	private double t_duration;
	
	
	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public String getT_dept() {
		return t_dept;
	}

	public void setT_dept(String t_dept) {
		this.t_dept = t_dept;
	}

	public double getT_duration() {
		return t_duration;
	}

	public void setT_duration(double t_duration) {
		this.t_duration = t_duration;
	}

	public Task(long tid, String t_name, String t_dept, double t_duration) {
		super();
		this.tid = tid;
		this.t_name = t_name;
		this.t_dept = t_dept;
		this.t_duration = t_duration;
	}

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Task [tid=" + tid + ", t_name=" + t_name + ", t_dept=" + t_dept + ", t_duration=" + t_duration
				+ "]";
	}
}
