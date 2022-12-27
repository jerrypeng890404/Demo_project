package com.example.demo_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Menuu;
import com.example.demo_project.ifs.MenuuService;
import com.example.demo_project.vo.MenuuRequest;
import com.example.demo_project.vo.MenuuResponse;
import com.example.demo_project.vo.OrderrRequest;

@RestController
public class Menuu_Controller {
	
	@Autowired
	private MenuuService menuuService;
	
	@PostMapping(value = "/api/createMeals")
	public MenuuResponse createMeals(@RequestBody MenuuRequest req) {
		MenuuResponse res = new MenuuResponse();
		Menuu menuu = menuuService.createMeals(req.getName(), req.getPrice());
		//防呆
		if(menuu == null) {
			res.setName("餐點品項錯誤!!");
			return res;
		}
		res.setName(menuu.getName());
		res.setPrice(menuu.getPrice());
		return res;
	}
	
	@GetMapping(value = "/api/getAllMeals")
	public MenuuResponse getAllMeals(){
//		MenuuResponse res = new MenuuResponse();
//		res.setMenuulist(menuuService.getAllMeals());
//		return res;
		return new MenuuResponse(menuuService.getAllMeals());
	}
	
	@PostMapping(value = "/api/findMealByName")
	public MenuuResponse findMealByName(@RequestBody MenuuRequest req) {
		MenuuResponse res = new MenuuResponse();
		Menuu menuu = menuuService.findMealByName(req.getName());
		res.setMenuulist(res.getMenuulist());
		//防呆
		if(menuu == null) {
			res.setName("品項不存在!!");
			return res;
		}
		res.setName(menuu.getName());
		res.setPrice(menuu.getPrice());
		return res;
	}
	
	@PostMapping(value = "/api/order")
	public Integer order(@RequestBody List<OrderrRequest> orderr) {
		return menuuService.order(orderr);
	}
	
}
