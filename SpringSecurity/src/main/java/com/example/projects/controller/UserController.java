package com.example.projects.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projects.Service.UserService;
import com.example.projects.User.User;

@RestController
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	private UserService userservice;
	
	@GetMapping("/")
	public List<User> getAllUsers()
	{
		return this.userservice.getAllUsers();
	}
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username)
	{
		return this.userservice.getUser(username);
	}
	@PostMapping("/")
	public User add(@RequestBody User user)
	{
		return this.userservice.addUser(user);
	}
}
