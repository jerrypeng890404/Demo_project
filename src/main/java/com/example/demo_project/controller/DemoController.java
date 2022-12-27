package com.example.demo_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

	//網址?後有參數一定用GET
	@GetMapping(value = "/hello")
	public String hello(@RequestParam(name = "name", required = false, defaultValue = "World")
	String name, Model model) {
		model.addAttribute("name", name);
		//回傳hello.html頁面
		return "hello.html";
	}
}
