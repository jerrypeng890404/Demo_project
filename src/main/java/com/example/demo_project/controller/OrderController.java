package com.example.demo_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.ifs.OrderService;
import com.example.demo_project.vo.OrderRequest;
import com.example.demo_project.vo.OrderResponse;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderservice;
	
	@PostMapping(value = "/api/one")
	public OrderResponse one(@RequestBody OrderRequest request) {
		OrderResponse ores = new OrderResponse();
		
		ores.setMenuList(orderservice.one());
		
//		List<Menu> menuList = orderservice.one();
		
		return ores;
	}
	
	@PostMapping(value = "/api/two")
	public OrderResponse two(@RequestBody OrderRequest request) {
		OrderResponse ores = new OrderResponse();
		return ores;
		
	}
	
}
