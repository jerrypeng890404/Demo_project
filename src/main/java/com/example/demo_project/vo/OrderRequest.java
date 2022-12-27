package com.example.demo_project.vo;

import com.example.demo_project.entity.Menu;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderRequest {
	
	@JsonProperty("one")
	private Menu one;
	
	@JsonProperty("two")
	private Menu two;

	public Menu getOne() {
		return one;
	}

	public void setOne(Menu one) {
		this.one = one;
	}

	public Menu getTwo() {
		return two;
	}

	public void setTwo(Menu two) {
		this.two = two;
	}
	
}
