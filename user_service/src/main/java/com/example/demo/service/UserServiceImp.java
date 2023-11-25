package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;

@Service
public class UserServiceImp implements UserService 
{
	List<User> list=List.of(
			new  User(1311L,"Durgesh Tiwari","78799797"),
			new  User(1312L,"Ankit Tiwari","78799798"),
			new  User(1314L,"Ravi Tiwari","78799799")
			);
	@Override
	public User getUser(Long id) 
	{
		return list.stream().filter(user->user.getUserId().equals(id)).findAny().orElse(null);
	}

}