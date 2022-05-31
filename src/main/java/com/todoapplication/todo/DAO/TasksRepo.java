package com.todoapplication.todo.DAO;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todoapplication.todo.entities.Tasks;

@Repository
public interface TasksRepo extends JpaRepository<Tasks, Integer> {
	@Query("from tasks as c WHERE c.user.id= :userId")
	public List<Tasks> getTasksByUser(@PathParam("userId") int userId);

}
