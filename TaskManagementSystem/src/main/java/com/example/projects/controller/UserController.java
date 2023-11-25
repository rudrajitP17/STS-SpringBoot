package com.example.projects.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projects.entity.User;
import com.example.projects.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("/getUser")
	public List<User> findAllUser(){
		return userService.getAll();
	}
	
	@GetMapping("/getUserById/{id}")
	@Cacheable(value = "user",key="#id")
	public User findUserById(@PathVariable long id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/getUserByName/{name}")
	@Cacheable(value = "user",key = "#name")
	public User findUserByName(@PathVariable String name) {
		return userService.getUserByName(name);
	}
	
	@PutMapping("/updateUser")
	@Cacheable(value = "user",key="user.id")
	public String updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	@CacheEvict(value = "user",key="#id")
	public String deleteUser(@PathVariable long id){
		return userService.deleteUser(id);
	}
}
