package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuuRequest {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("price")
	private int price;
	
	@JsonProperty("message")
	private String message;

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
