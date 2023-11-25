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
import com.example.projects.repository.TaskRepository;

@SpringBootTest
public class TaskServiceTest {
	
	@MockBean
	private TaskRepository taskRepository;
	@Autowired
	private TaskService taskService;

	@Test
	public void addTask() {
		Task task=new Task(1L,"Java","Tech",23);
		when(taskRepository.save(task)).thenReturn(task);
		assertEquals(task, taskService.addTask(task));
	}
	
	@Test
	public void getTask() {
		List<Task> list=Arrays.asList(new Task(3L,"GoLang","Tech",12), new Task(4L,"Python","Tech",13));
		when(taskRepository.findAll()).thenReturn(list);
		assertEquals(2, taskService.gettask().size());
	}
	
	@Test
	public void getTaskById() {
		Task task=new Task(2L,"C","Tech",24);
		when(taskRepository.findById(2L)).thenReturn(Optional.of(task));
		assertEquals("C", taskService.gettaskbyid(2L).getT_name());
	}
	
	
	@Test
	public void deleteTask() {
		Task task=new Task(6L,"Excel","Management",24);
		taskService.deleteTask(6L);
		verify(taskRepository,times(1)).delete(task);
	}
}
