package com.example.projects.entity;

import java.io.Serializable;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "User_Details")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="User_id")
	private long uid;
	
	@Column(name = "User_Name")
	private String name;
	
	@Column(name = "User_Email")
	private String email;
	
	@Column(name = "User_PhoneNo")
	private String ph_no;
	
	@Column(name = "User_Address",length = 50)
	private String address;
	
	@Column(name = "Tasks")
	@OneToMany(targetEntity = Task.class,cascade = CascadeType.ALL)
	private List<Task> task_name;
	
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPh_no() {
		return ph_no;
	}
	public void setPh_no(String ph_no) {
		this.ph_no = ph_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Task> getTask_name() {
		return task_name;
	}
	public void setTask_name(List<Task> task_name) {
		this.task_name = task_name;
	}
	public User(long uid, String name, String email, String ph_no, String address, List<Task> task_name) {
		super();
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.ph_no = ph_no;
		this.address = address;
		this.task_name = task_name;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", email=" + email + ", ph_no=" + ph_no + ", address=" + address
				+ ", task_name=" + task_name + "]";
	}
}
