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

import com.example.projects.entity.Task;
import com.example.projects.service.TaskService;

@RestController
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/getAllTasks")
	public List<Task> getAllTasks(){
		return taskService.gettask();
	}
	
	@GetMapping("getTaskById/{id}")
	@Cacheable(value="task",key="#id")
	public Task getTaskById(@PathVariable long id) {
		return taskService.gettaskbyid(id);
	}
	
	@PostMapping("/addTask")
	public String addTask(@RequestBody Task task) {
		return taskService.addTask(task);
	}
	
	@PutMapping("/updateTask")
	@Cacheable(value="task",key="task.id")
	public String updateTask(@RequestBody Task task) {
		return taskService.updateTask(task);
	}
	
	@DeleteMapping("deleteTask/{id}")
	@CacheEvict(value="task",key="#id")
	public String deleteTask(@PathVariable long id) {
		return taskService.deleteTask(id);
	}
}