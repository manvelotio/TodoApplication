package com.todoapplication.todo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Service;

import com.todoapplication.todo.DAO.TasksRepo;
import com.todoapplication.todo.DAO.UserRepo;
import com.todoapplication.todo.entities.Tasks;
import com.todoapplication.todo.entities.User;

@Service
@EnableGlobalMethodSecurity(securedEnabled = true)
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private TasksRepo tasksRepo;

	@Override
	public User userRegister(User user) {
		System.out.println("userService : "+user);
		return userRepo.save(user);
	}

	@Override
	public void updateTasks(Tasks tasks) {
		tasksRepo.save(tasks);

	}

	@Override
	public void addTask(User user) {
		userRepo.save(user);

	}
	
	@Secured("ROLE_USER")
	@Override
	public void deleteTask(User user, Tasks tasks) {
		user.getTasks().remove(tasks);
		tasks.setUser(user);
		this.tasksRepo.delete(tasks);

	}

	@Override
	public User findUserByEmail(String email) {
		User resultUser = userRepo.loadUserByEmail(email);
		return resultUser;
	}

	@Override
	public Tasks getTasksbyId(int tId) {
		Optional<Tasks> optionalTasks = this.tasksRepo.findById(tId);
		Tasks tasks = optionalTasks.get();
		return tasks;
	}

	@Override
	public List<Tasks> getTasksList(int userId) {
		List<Tasks> listTasksByUser = this.tasksRepo.getTasksByUser(userId);
		return listTasksByUser;
		
		
	}
	@Override
	   public List<User> findAll() {

        var it = userRepo.findAll();

        var users = new ArrayList<User>();
        it.forEach(e -> users.add(e));

        return users;
    }

}
