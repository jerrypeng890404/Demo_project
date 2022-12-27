package com.example.demo_project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //把Entity實體化
@Table(name = "bankk") //資料庫中Table名稱
public class Bankk {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account") //對照資料庫欄位
	private String account;

	@Column(name = "amount")
	private int amount;
	
	@Column(name = "name")
	private String name;
	
	public Bankk() {
	}

	public Bankk(String account, int amount) {
		this.account = account;
		this.amount = amount;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
