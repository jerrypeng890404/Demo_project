package com.example.demo_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_project.entity.Widget;

public interface WidgetDao extends JpaRepository<Widget, Integer>{
	
}
