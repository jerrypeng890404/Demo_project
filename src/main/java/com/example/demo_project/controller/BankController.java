package com.example.demo_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Bank;
import com.example.demo_project.ifs.BankService;
import com.example.demo_project.vo.BankRequest;
import com.example.demo_project.vo.BankResponse;

@RestController
public class BankController {
	// localhost:8080
	@Autowired
	private BankService bankservice;

	@PostMapping(value = "/api/getAmount") //API定址(輸入字串找到此方法)
	/*@ResponseBody <- 使用@RestController不必加*/
	public BankResponse getAmount(@RequestBody BankRequest request) {
		BankResponse res = new BankResponse();
		
		if (!StringUtils.hasText(request.getAccount())) {
			res.setMessage("Account is empty!!");
			return res;
		}

		Bank bank = bankservice.getAmount(request.getAccount());
		res.setAccount(bank.getAccount());
		res.setAmount(bank.getAmount());
		res.setMessage("success");
		return res;
	}
	
	@PostMapping(value = "/api/deposit") //存款
	public BankResponse deposit(@RequestBody BankRequest request) {
		BankResponse res = new BankResponse();
		
		if (!StringUtils.hasText(request.getAccount())) {
			res.setMessage("Account is empty!!");
			return res;
		}else if(request.getDeposit() == 0 ) {
			res.setMessage("存款為零");
			return res;
		}else if(request.getDeposit() < 0) {
			res.setMessage("存款為負值");
			return res;
		}
	
		Bank bank = bankservice.deposit(request.getAccount(), request.getDeposit());
		res.setAccount(bank.getAccount());
		res.setAmount(bank.getAmount());
		res.setMessage("deposit success");
		return res;
	}
	
	@PostMapping(value = "/api/withdraw") //取款
	public BankResponse withdraw(@RequestBody BankRequest request) {
		BankResponse res = new BankResponse();
		
		if (!StringUtils.hasText(request.getAccount())) {
			res.setMessage("Account is empty!!");
			return res;
		}else if(request.getWithdraw() == 0 ) {
			res.setMessage("取款為零");
			return res;
		}else if(request.getWithdraw() < 0 ) {
			res.setMessage("取款為負值");
			return res;
		}
		Bank bank = bankservice.withdraw(request.getAccount(), request.getWithdraw());
		res.setAccount(bank.getAccount());
		res.setAmount(bank.getAmount());
		res.setMessage("withdraw success");
		return res;
	}
	
//	@GetMapping(value = "/api/get")
//	public BankResponse getAmount() {
//		BankResponse res = new BankResponse();
//		Bank bank = new Bank();
//		bank.setAccount("AAA");
//		bank.setAmount(2000);
//		res.setAccount(null);
//		res.setAmount(0);
//		return res;
//	}
	
}
