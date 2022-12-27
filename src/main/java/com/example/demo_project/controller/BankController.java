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

	@PostMapping(value = "/api/getAmount") //API�w�}(��J�r���즹��k)
	/*@ResponseBody <- �ϥ�@RestController�����[*/
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
	
	@PostMapping(value = "/api/deposit") //�s��
	public BankResponse deposit(@RequestBody BankRequest request) {
		BankResponse res = new BankResponse();
		
		if (!StringUtils.hasText(request.getAccount())) {
			res.setMessage("Account is empty!!");
			return res;
		}else if(request.getDeposit() == 0 ) {
			res.setMessage("�s�ڬ��s");
			return res;
		}else if(request.getDeposit() < 0) {
			res.setMessage("�s�ڬ��t��");
			return res;
		}
	
		Bank bank = bankservice.deposit(request.getAccount(), request.getDeposit());
		res.setAccount(bank.getAccount());
		res.setAmount(bank.getAmount());
		res.setMessage("deposit success");
		return res;
	}
	
	@PostMapping(value = "/api/withdraw") //����
	public BankResponse withdraw(@RequestBody BankRequest request) {
		BankResponse res = new BankResponse();
		
		if (!StringUtils.hasText(request.getAccount())) {
			res.setMessage("Account is empty!!");
			return res;
		}else if(request.getWithdraw() == 0 ) {
			res.setMessage("���ڬ��s");
			return res;
		}else if(request.getWithdraw() < 0 ) {
			res.setMessage("���ڬ��t��");
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
