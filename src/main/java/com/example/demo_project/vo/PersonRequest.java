package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonRequest {
	
	@JsonProperty("id") //輸入"id"找到第8行的id 不加的話直接找id
	private String id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("age")
	private int age;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
