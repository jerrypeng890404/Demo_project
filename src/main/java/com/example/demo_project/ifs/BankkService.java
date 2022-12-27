package com.example.demo_project.ifs;

import com.example.demo_project.entity.Bankk;

public interface BankkService {
	
	public Bankk createAccount(String account);
	
	public Bankk getAmount(String account);
	
	public Bankk deposit(String account, int depositAmount);
	
	public Bankk withdraw(String account, int withdrawAmount);
	
	public Bankk deleteAccount(String account) throws RuntimeException;
	
	public void deleteByName(String name) throws RuntimeException;
	
}
