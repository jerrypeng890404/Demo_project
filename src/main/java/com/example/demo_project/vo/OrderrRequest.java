package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;


public class OrderrRequest {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("quantity")
	private int quantity; //¼Æ¶q

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
