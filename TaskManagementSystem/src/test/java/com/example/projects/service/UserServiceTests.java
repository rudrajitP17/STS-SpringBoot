package com.example.projects.service;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.projects.entity.Task;
import com.example.projects.entity.User;
import com.example.projects.repository.UserRepository;
@SpringBootTest
public class UserServiceTests {

	@MockBean
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@Test
	public void getAll(){

		List<Task> list1 = null;
		List<User> list3=Arrays.asList(new User(1L,"Ram","abc@abc.com","123445","Random Street",list1),new User(2L,"Ram","abc@abc.com","123445","Random Street",list1));
		when(userRepository.findAll()).thenReturn(list3);
		assertEquals(2, userService.getAll().size());
	}
	
	@Test
	public void saveUser() {
		List<Task> list = null;
		User user=new User(5L,"Rudra","abc@abc.com","123445","Random Street",list);
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userService.saveUser(user));
	}
	
	@Test
	public void getUserById() {
		List<Task> list=null;
		User user=new User(2L,"Ram","abc@abc.com","123445","Random Street",list);
		when(userRepository.findById(2L)).thenReturn(Optional.of(user));
		assertEquals("Ram", userService.getUserById(2L).getName());
	}
	
	@Test
	public void deleteUser() {
		List<Task> list=null;
		User user=new User(3L,"Shyam","abc@abc.com","123445","Random Street",list);
		userService.deleteUser(3L);
		verify(userRepository,times(1)).delete(user);
	}
	
	
}
