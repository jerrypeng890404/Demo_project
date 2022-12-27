package com.example.demo_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

	//���}?�ᦳ�ѼƤ@�w��GET
	@GetMapping(value = "/hello")
	public String hello(@RequestParam(name = "name", required = false, defaultValue = "World")
	String name, Model model) {
		model.addAttribute("name", name);
		//�^��hello.html����
		return "hello.html";
	}
}
