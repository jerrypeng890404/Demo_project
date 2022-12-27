package com.example.demo_project.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo_project.entity.Bankk;
import com.example.demo_project.ifs.BankkService;
import com.example.demo_project.repository.BankkDao;

@Service
public class BankkServiceImpl implements BankkService {

	@Autowired
	private BankkDao bankkDao;

	@Override
	public Bankk createAccount(String account) {
		Bankk bankk = new Bankk();
		Optional<Bankk> bankkOp = bankkDao.findById(account);
		if (bankkOp.isPresent()) {
			return null;
		} else {
			bankk.setAccount(account);
			bankkDao.save(bankk);
		}
		return bankk;
	}

	@Override
	public Bankk getAmount(String account) {
		Optional<Bankk> bankkOp = bankkDao.findById(account);
		Bankk bankkw = bankkOp.orElse(null);
		return bankkw;
	}

	@Override
	public Bankk deposit(String account, int depositAmount) {
		
		Optional<Bankk> bankkOp = bankkDao.findById(account);
		
		if (bankkOp.isPresent() && depositAmount > 0) {
			Bankk bankk = bankkOp.get();
			int depositbox = depositAmount + bankk.getAmount();
			bankk.setAmount(depositbox);
			bankkDao.save(bankk);
			return bankk;
		}
		return null;
	}

	@Override
	public Bankk withdraw(String account, int withdrawAmount) {
		Optional<Bankk> bankkOp = bankkDao.findById(account);
		Bankk bankk = bankkOp.get();
		if (bankkOp.isPresent() && withdrawAmount <= bankk.getAmount() && withdrawAmount > 0) {
			int depositbox = bankk.getAmount() - withdrawAmount;
			bankk.setAmount(depositbox);
			bankkDao.save(bankk);
			return bankk;
		} else {
			return null;
		}
	}

	@Transactional //¨Æ°È©Ê
	@Override
	public Bankk deleteAccount(String account) throws RuntimeException {
		bankkDao.deleteById(account);
		System.out.println("Delete Account Success");
		return null;
	}

	@Override
	public void deleteByName(String name) throws RuntimeException {
		bankkDao.deleteByName(name);
	}

}
