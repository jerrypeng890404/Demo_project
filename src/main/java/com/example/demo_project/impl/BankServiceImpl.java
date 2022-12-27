package com.example.demo_project.impl;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Bank;
import com.example.demo_project.ifs.BankService;

@Service
public class BankServiceImpl implements BankService {

	@Override
	public void getAmounts(Bank bank) {
		System.out.println("±b¤á: " + bank.getAccount() + "\n" + "¾lÃB: " + bank.getAmount());
	}

	@Override
	public void deposit(Bank bank, int depositAmount) {
		int dep = bank.getAmount() + depositAmount;
		bank.setAmount(dep);
		System.out.println("±b¤á: " + bank.getAccount() + "\n" + "¦s´Ú«á¾lÃB: " + dep);
	}

	@Override
	public void withdraw(Bank bank, int withdrawAmount) {
		if (withdrawAmount >= 0 && bank.getAmount() >= withdrawAmount) {
			int wit = bank.getAmount() - withdrawAmount;
			bank.setAmount(wit);
			System.out.println("±b¤á: " + bank.getAccount() + "\n" + "´£´Ú«á¾lÃB: " + wit);
		} else {
			System.out.println("¾lÃB³Ñ¤U: " + bank.getAmount() + "\n" + "¾lÃB¤£¨¬ µLªk¨ú´Ú");
		}
	}

	@Override
	public Bank getAmount(String account) {
		Bank bank = new Bank();
		bank.setAccount(account);
		bank.setAmount(1000);
		return bank;
	}

	@Override
	public Bank deposit(String account, int depositAmount) {
		Bank bank = new Bank();
		bank.setAccount(account);
		bank.setAmount(1000);
		bank.setAmount(bank.getAmount() + depositAmount);
		return bank;
	}

	@Override
	public Bank withdraw(String account, int withdrawAmount) {
		Bank bank = new Bank();
		bank.setAccount(account);
		bank.setAmount(1000);
		bank.setAmount(bank.getAmount() - withdrawAmount);
		return bank;
	}
	
	
	
}
