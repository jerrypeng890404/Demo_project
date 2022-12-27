package com.example.demo_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo_project.entity.Bankk;

@Transactional //¨Æ°È©Ê
@Repository
public interface BankkDao extends JpaRepository<Bankk, String> {
	
	public void deleteByName(String name) throws RuntimeException;
	
}
