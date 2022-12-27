package com.example.demo_project.ifs;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Person;
@Service
public interface PersonService {
	
	public List<Person> getPersonInfo();
	
	public Person getPersonInfoById(String id);
	
	public List<Person> getPersonInfoByAgeLargerThan(int age);

//	public List<Person> findByNameAndAge(String name, int age);
	
	public List<Person> findByNameAndAgeGreaterThan(String name, int age);
	
}
