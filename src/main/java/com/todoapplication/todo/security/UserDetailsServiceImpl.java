package com.todoapplication.todo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.todoapplication.todo.DAO.UserRepo;
import com.todoapplication.todo.entities.User;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User loadedUser = userRepo.loadUserByEmail(username);
		if(loadedUser == null) {
			throw new UsernameNotFoundException("Could not find the given User");
		}
		
		UserDetails userDetails = new UserDetailsImpl(loadedUser);
		return userDetails;
	}

}
