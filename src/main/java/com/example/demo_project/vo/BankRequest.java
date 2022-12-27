package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankRequest {
	
	@JsonProperty("account") //要求要加
	private String account;
	
	@JsonProperty("amount")
	private int amount;
	
	@JsonProperty("deposit")
	private int deposit;
	
	@JsonProperty("withdraw")
	private int withdraw;
	
	public BankRequest() {
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
	
}
