package com.example.demo_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Widget;
import com.example.demo_project.ifs.WidgetService;

@RestController
public class Widget_Controller {
	
	@Autowired
	private WidgetService widgetservice;
	
	@PostMapping(value = "/api/saveWidget")
	public Widget save() {
		return widgetservice.save();
	}
	
}
