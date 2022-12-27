package com.example.demo_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_project.entity.Person;

@Repository //�Qspringboot�U��
public interface PersonDao extends JpaRepository<Person, String>{ //<Entity, �D�䫬�A>

	public List<Person> findByAgeGreaterThan(int age);
	
//	public List<Person> findByNameAndAge(String name, int age);
	
	public List<Person> findByNameAndAgeGreaterThan(String name, int age);
	
}
