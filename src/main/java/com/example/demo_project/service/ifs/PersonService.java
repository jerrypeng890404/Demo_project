package com.example.demo_project.service.ifs;

import com.example.demo_project.entity.Person;

public interface PersonService {
	default Person getPersonInfo(String id) { //權限為default時才可在介面中實作
		return new Person();
	}
//	public String getPersonId();
}
