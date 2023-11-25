package com.example.projects.Entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class VerificationToken 
{
	private static final int EXPIRATION_TIME=10;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String token;
	private Date expirationTime;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id",nullable = false,foreignKey = @ForeignKey(name="FK_USER_VERIFY_TOKEN"))
	private User user;
	public VerificationToken(User user,String token)
	{
		super();
		this.token=token;
		this.user=user;
		this.expirationTime=calculateExpirationDate(EXPIRATION_TIME);
	}
	public VerificationToken(String token)
	{
		super();
		this.token=token;
		this.expirationTime=calculateExpirationDate(EXPIRATION_TIME);
	}
	private Date calculateExpirationDate(int expirationTime2)
	{
		Calendar calender=Calendar.getInstance();
		calender.setTimeInMillis(new Date().getTime());
		calender.add(Calendar.MINUTE,expirationTime2);
		return new Date(calender.getTime().getTime());
	}
	public VerificationToken() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
