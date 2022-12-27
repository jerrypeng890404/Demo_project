package com.example.demo_project.vo;

import java.util.List;

import com.example.demo_project.entity.Menuu;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuuResponse {
	
	private String name;
	
	private int price;
	
	private List<Menuu> menuulist;
	
	public MenuuResponse() {
	}

	public MenuuResponse(List<Menuu> menuulist) {
		this.menuulist = menuulist;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Menuu> getMenuulist() {
		return menuulist;
	}

	public void setMenuulist(List<Menuu> menuulist) {
		this.menuulist = menuulist;
	}

}
