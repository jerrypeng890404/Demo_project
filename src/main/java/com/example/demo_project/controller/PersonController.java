package com.example.demo_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Person;
import com.example.demo_project.ifs.PersonService;
import com.example.demo_project.vo.PersonRequest;
import com.example.demo_project.vo.PersonResponse;

@RestController
public class PersonController {
	@Autowired
	private PersonService personservice;

	@GetMapping(value = "/api/getPersonInfo")
	public PersonResponse getPersonInfo() {
		PersonResponse pres = new PersonResponse();

		pres.setPersonList(personservice.getPersonInfo());

		return pres;

	}

	@PostMapping(value = "/api/getPersonInfoById")
	public PersonResponse getPersonInfoById(@RequestBody PersonRequest request) {

		Person per = personservice.getPersonInfoById(request.getId());

		PersonResponse pres = new PersonResponse();
		pres.setPersonList(pres.getPersonList()); //加入43, 44, 45行內容

		// 防呆
		if (per == null) {
//			Person per1 = new Person();
			pres.setName("查無此人");
			return pres;
		}else { //可不用else
		pres.setId(per.getId());
		pres.setName(per.getName());
		pres.setAge(per.getAge());
		}
		return pres;

	}

	@PostMapping(value = "/api/getPersonInfoByAgeLargerThan")
	public PersonResponse getPersonInfoByAgeLargerThan(@RequestBody PersonRequest request) {

		PersonResponse pres = new PersonResponse();

		pres.setPersonList(personservice.getPersonInfoByAgeLargerThan(request.getAge()));

		return pres;
	}

//	@PostMapping(value = "/api/findByNameAndAge")
//	public PersonResponse findByNameAndAge(@RequestBody PersonRequest request) {
//		
//		PersonResponse pres = new PersonResponse();
//		
//		pres.setPersonList(personservice.findByNameAndAge(request.getName(), request.getAge()));
//		
//		return pres;
//	}

	@PostMapping(value = "/api/findByNameAndAgeGreaterThan")
	public PersonResponse findByNameAndAgeGreaterThan(@RequestBody PersonRequest request) {

		PersonResponse pres = new PersonResponse();

		pres.setPersonList(personservice.findByNameAndAgeGreaterThan(request.getName(), request.getAge()));

		return pres;
	}

}
