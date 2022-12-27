package com.example.demo_project.impl;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Bank;
import com.example.demo_project.ifs.BankService;

@Service
public class BankServiceImpl implements BankService {

	@Override
	public void getAmounts(Bank bank) {
		System.out.println("�b��: " + bank.getAccount() + "\n" + "�l�B: " + bank.getAmount());
	}

	@Override
	public void deposit(Bank bank, int depositAmount) {
		int dep = bank.getAmount() + depositAmount;
		bank.setAmount(dep);
		System.out.println("�b��: " + bank.getAccount() + "\n" + "�s�ګ�l�B: " + dep);
	}

	@Override
	public void withdraw(Bank bank, int withdrawAmount) {
		if (withdrawAmount >= 0 && bank.getAmount() >= withdrawAmount) {
			int wit = bank.getAmount() - withdrawAmount;
			bank.setAmount(wit);
			System.out.println("�b��: " + bank.getAccount() + "\n" + "���ګ�l�B: " + wit);
		} else {
			System.out.println("�l�B�ѤU: " + bank.getAmount() + "\n" + "�l�B���� �L�k����");
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
