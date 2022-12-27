package com.example.demo_project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.entity.Bank;
import com.example.demo_project.ifs.BankService;

@SpringBootTest
public class ATM_UnitTest {
	@Autowired
	private BankService bankService;
	@Test
	public void ss() {
		Set<String> name= new TreeSet<>();
		Set<String> lable= new TreeSet<>();
		List<String> ssssComons= new ArrayList<>();
		ssssComons.add("平和"+"資料庫"+"下拉式");
		ssssComons.add("平和"+"資料庫"+"下拉式");
		ssssComons.add("平和"+"資料庫"+"下拉式");
		ssssComons.add("平和"+"資料庫"+"下拉式");
		lable.add("La1");
		lable.add("La2");
		lable.add("La3");
		lable.add("La4");
		for(var s:ssssComons) {
			name.add(s);
		}
		name.addAll(lable);
		System.out.println(name);
	}
	@Test
	public void ATM() {
		Bank ban = new Bank("AAA", 10000); //初始存款
		System.out.println("===================");
		bankService.getAmounts(ban); //方法一
		System.out.println("===================");
		bankService.deposit(ban, 1000); //方法二
		System.out.println("===================");
		bankService.withdraw(ban, 5000); //方法三
	}
}
