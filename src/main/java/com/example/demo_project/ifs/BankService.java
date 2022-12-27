package com.example.demo_project.ifs;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Bank;
@Service
public interface BankService {
	public void getAmounts(Bank bank);

	public void deposit(Bank bank, int depositAmount);

	public void withdraw(Bank bank, int withdrawAmount);
	
	public Bank getAmount(String account);
	
	public Bank deposit(String account, int depositAmount);
	
	public Bank withdraw(String account, int withdrawAmount);
}
