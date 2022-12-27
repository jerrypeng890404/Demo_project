package com.example.demo_project.vo;

import java.util.List;

import com.example.demo_project.entity.Menu;

public class OrderResponse {

	private String message;
	
	private int number;
	
	private List<Menu> menuList;

	public OrderResponse() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
	
}
