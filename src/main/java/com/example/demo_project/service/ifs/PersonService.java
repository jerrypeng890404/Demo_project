package com.example.demo_project.service.ifs;

import com.example.demo_project.entity.Person;

public interface PersonService {
	default Person getPersonInfo(String id) { //�v����default�ɤ~�i�b��������@
		return new Person();
	}
//	public String getPersonId();
}
