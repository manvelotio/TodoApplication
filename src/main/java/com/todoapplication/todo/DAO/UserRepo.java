package com.todoapplication.todo.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.todoapplication.todo.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
	
	@Query("Select u from User u WHERE u.email = :email")
	public User loadUserByEmail(@Param("email")String email);

}
