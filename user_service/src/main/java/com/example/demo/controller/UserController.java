package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private UserService userservice;
	
	@GetMapping("/{userId}")
	public User getUser(@PathVariable("userId") Long userId)
	{
		return this.userservice.getUser(userId);
	}
}
