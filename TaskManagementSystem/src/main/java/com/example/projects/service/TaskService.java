package com.example.projects.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projects.entity.Task;
import com.example.projects.repository.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepository;
	
	public List<Task> gettask(){
		return taskRepository.findAll();
	}
	
	public Task gettaskbyid(long id) {
		return taskRepository.findById(id).orElse(null);
	}
	
	public String addTask(Task task) {
		taskRepository.save(task);
		return "Task Added";
	}
	
	public String updateTask(Task task) {
		Task existing_task=taskRepository.findById(task.getTid()).orElse(null);
		existing_task.setT_dept(task.getT_dept());
		existing_task.setT_duration(task.getT_duration());
		existing_task.setT_name(task.getT_name());
		existing_task.setTid(task.getTid());
		return "Task Updated";
	}
	
	public String deleteTask(long id) {
		taskRepository.deleteById(id);
		return "Task Deleted";
	}
	
	public TaskService(TaskRepository repo) {
		this.taskRepository=repo;
	}
}
