package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

public class BankResponse {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String account;
	private int amount;
	private String message;

	public BankResponse() {
	}

	 public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
