package com.example.demo_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Bankk;
import com.example.demo_project.ifs.BankkService;
import com.example.demo_project.vo.BankkRequest;
import com.example.demo_project.vo.BankkResponse;

@RestController
public class Bankk_Controller {

	@Autowired
	private BankkService bankkService;

	@PostMapping(value = "/api/createAccount")
	public BankkResponse createAccount(@RequestBody BankkRequest request) { // 輸入請求參數
		BankkResponse bankkres = new BankkResponse(); // new Response
		
		Bankk bankk = bankkService.createAccount(request.getAccount()); // new entity = interface.方法名(輸入參數.取得帳號())
		// 防呆
		if (bankk == null) {
			bankkres.setAccount("此帳號重複!!");
			return bankkres;
		}
		// 否則取得輸入帳號名稱
		bankkres.setAccount(bankk.getAccount());
		return bankkres;
	}

	@PostMapping(value = "/api/getAmountt")
	public BankkResponse getAmount(@RequestBody BankkRequest request) {
		BankkResponse res = new BankkResponse();
		
		Bankk bankk = bankkService.getAmount(request.getAccount());
		if(bankk == null) {
			res.setAccount("查無此帳號!!");
			return res;
		}
		res.setAccount(bankk.getAccount());
		res.setAmount(bankk.getAmount());
		return res;
	}
	
	@PostMapping(value = "/api/depositt")
	public BankkResponse deposit(@RequestBody BankkRequest request) {
		BankkResponse res = new BankkResponse();
		
		Bankk bankk = bankkService.deposit(request.getAccount(), request.getAmount());
//		if(request.getDeposit() <= 0) {
//			res.setMessage("存款不得小於等於零");
//			return res;
//		}
//		if(bankk == null) {
//			res.setMessage("存款為空");
//			return res;
//		}
		res.setAccount(bankk.getAccount());
		res.setAmount(bankk.getAmount());
		res.setMessage("存款成功!!");
		return res;
	}
	
	@PostMapping(value = "/api/withdraww")
	public BankkResponse withdraw(@RequestBody BankkRequest request) {
		BankkResponse res = new BankkResponse();
		Bankk bankk = bankkService.withdraw(request.getAccount(), request.getAmount());
		res.setAccount(bankk.getAccount());
		res.setAmount(bankk.getAmount());
		res.setMessage("提款成功!!");
		return res;
	}
	
	@PostMapping(value = "/api/deleteAccount")
	public BankkResponse deleteAccount(@RequestBody BankkRequest request) {
		BankkResponse res = new BankkResponse();
		bankkService.deleteAccount(request.getAccount());
		return res;
	}
	
	@PostMapping(value = "/api/deleteByName")
	public BankkResponse deleteByName(@RequestBody BankkRequest request) {
		BankkResponse res = new BankkResponse();
		bankkService.deleteByName(request.getName());
		res.setMessage("刪除成功!!");
		return res;
	}
}
