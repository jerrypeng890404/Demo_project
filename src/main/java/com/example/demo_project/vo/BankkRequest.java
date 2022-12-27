package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankkRequest {
	
	@JsonProperty("account")
	private String account;
	
	@JsonProperty("amount")
	private int amount;
	
	//奇怪的東西
	@JsonProperty("deposit")
	private int deposit;
	//奇怪的東西
	@JsonProperty("withdraw")
	private int withdraw;
	
	@JsonProperty("delete")
	private int delete;
	
	@JsonProperty("name")
	private String name;

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

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}

	public int getDelete() {
		return delete;
	}

	public void setDelete(int delete) {
		this.delete = delete;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
