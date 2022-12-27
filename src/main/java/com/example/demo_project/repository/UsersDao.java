package com.example.demo_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_project.entity.Users;

public interface UsersDao extends JpaRepository<Users, Integer>{

	public Users findByUserName(String userName);
}
