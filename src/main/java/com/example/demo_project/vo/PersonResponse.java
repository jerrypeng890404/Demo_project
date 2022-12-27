package com.example.demo_project.vo;

import java.util.List;

import com.example.demo_project.entity.Person;
import com.fasterxml.jackson.annotation.JsonInclude;

public class PersonResponse {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String id;
	
	private String name;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer age;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Person> personList;

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}
