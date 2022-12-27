package com.example.demo_project.vo;

import java.util.List;

import com.example.demo_project.entity.Menu;

public class Order {
	
	private List<Menu> menuList;
	
	private int totalPrice;
	
	public Order() {
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
