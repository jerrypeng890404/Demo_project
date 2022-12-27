package com.example.demo_project.ifs;

import java.util.List;

import com.example.demo_project.entity.Menuu;
import com.example.demo_project.vo.OrderrRequest;

public interface MenuuService {
	
	public Menuu createMeals(String name, int price);
	
	public List<Menuu> getAllMeals();
	
	public Menuu findMealByName(String name);
	
	public Integer order(List<OrderrRequest> order);
	
}
