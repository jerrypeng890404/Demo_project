package com.example.demo_project.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Users;
import com.example.demo_project.repository.UsersDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsersDao usersDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users item = usersDao.findByUserName(username);
		UserDetails userDetails = User.builder()
		.username(item.getUserName())
		.password(item.getPassword())
		.roles(item.getRole())
		.build();
		return userDetails;
	}

}
