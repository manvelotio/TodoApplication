package com.todoapplication.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todoapplication.todo.entities.Tasks;
import com.todoapplication.todo.entities.User;

@Service
public interface UserService {
	User userRegister(User user);
	void updateTasks(Tasks tasks);
	void addTask(User user);
	void deleteTask(User user, Tasks tasks);
	User findUserByEmail(String email);
	Tasks getTasksbyId(int id);
	List<Tasks> getTasksList(int userId);
	List<User> findAll();
	}
