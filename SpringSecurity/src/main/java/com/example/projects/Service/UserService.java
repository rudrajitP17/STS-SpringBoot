package com.example.projects.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.projects.User.User;

@Service
public class UserService 
{
	List<User> list=new ArrayList<>();

	public UserService() {
		list.add(new User("Abc","Abc","abc@abc.com"));
		list.add(new User("Bcd","Bcd","Bcd@Bcd.com"));
	}
	public List<User> getAllUsers()
	{
		return list;
	}
	public User getUser(String username)
	{
		return this.list.stream().filter((user)->user.getUsername().equals(username)).findAny().orElse(null);
	}
	public User addUser(User user)
	{
		this.list.add(user);
		return user;
	}
}

