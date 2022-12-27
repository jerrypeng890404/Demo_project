package com.example.demo_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_project.entity.Menuu;

@Repository                                  //<Entity¦WºÙ, @Id«¬ºA>
public interface MenuuDao extends JpaRepository<Menuu, String>{
	
}
