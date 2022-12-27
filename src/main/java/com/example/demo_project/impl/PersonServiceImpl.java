package com.example.demo_project.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Person;
import com.example.demo_project.ifs.PersonService;
import com.example.demo_project.repository.PersonDao;
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao persondao;
	
	//init
//	Person mrA = new Person("A123456789", "A����", 10);
//	Person mrB = new Person("B123456789", "B����", 20);
//	Person mrC = new Person("C123456789", "C����", 30);

	@Override
	public List<Person> getPersonInfo() {
		
		List<Person> list = persondao.findAll();
//		list.add(mrA);
//		list.add(mrB);
//		list.add(mrC);
		return list;
	}

	@Override
	public Person getPersonInfoById(String id) {
//		List<Person> list = new ArrayList<>();
//		list.add(mrA);
//		list.add(mrB);
//		list.add(mrC);
		//====================
		//���b
		Optional <Person> list = persondao.findById(id);
		
		if(!list.isPresent()){ //��isPresent�P�_Option<Person>���L�F��
			return null;
		}
		
		return list.orElse(null);
		//====================
//		Person per = null;
//		for(Person person : list) {
//			if(id.equalsIgnoreCase(person.getId())) { //equalsIgnoreCase: �����j�p�g
//				per = person;
//			}
//		}
//		return per;
	}

	@Override
	public List<Person> getPersonInfoByAgeLargerThan(int age) {
		List<Person> list = persondao.findByAgeGreaterThan(age);
		return list;
		//====================
//		List<Person> list = persondao.findAll();
//		List<Person> list1 = new ArrayList<>();
//		
//		for(Person person : list) {
//			if(person.getAge() > age) {
//				list1.add(person);
//			}
//		}
//		
//		return list1;
	}
//	@Override
//	public List<Person> findByNameAndAge(String name, int age){
//		List<Person> list = persondao.findByNameAndAge(name, age);
//		
//		return list;
//	}
	
	@Override
	public List<Person> findByNameAndAgeGreaterThan(String name, int age){
		List<Person> list = persondao.findByNameAndAgeGreaterThan(name, age);
		
		return list;
	}
}
