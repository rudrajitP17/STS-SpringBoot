package com.example.projects.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.projects.entity.User;
import com.example.projects.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	public String saveUser(User user) {
		userRepository.save(user);
		return "User Saved";
	}
	
	public User getUserById(long id) {
		return userRepository.findById(id).orElse(null); 
	}
	
	public User getUserByName(String name) {
		return userRepository.findByName(name);
	}
	
	public String deleteUser(long id) {
		userRepository.deleteById(id);
		return "User Deleted";
	}
	
	public String updateUser(User user) {
		User existing_user=userRepository.findById(user.getUid()).orElse(null);
		existing_user.setAddress(user.getAddress());
		existing_user.setName(user.getName());
		existing_user.setPh_no(user.getPh_no());
		existing_user.setTask_name(user.getTask_name());
		userRepository.save(existing_user);
		return "User Updated";
	}
}
