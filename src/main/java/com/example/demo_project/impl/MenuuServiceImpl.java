package com.example.demo_project.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo_project.entity.Menuu;
import com.example.demo_project.ifs.MenuuService;
import com.example.demo_project.repository.MenuuDao;
import com.example.demo_project.vo.OrderrRequest;

@Service
public class MenuuServiceImpl implements MenuuService {

	@Autowired
	private MenuuDao menuuDao;

	@Override
	public Menuu createMeals(String name, int price) {
		Menuu menuu = new Menuu();
		Optional<Menuu> menuuOp = menuuDao.findById(name);
		// 判斷資料庫內容
		if (menuuOp.isPresent() || !StringUtils.hasText(name)) {
			return null;
		} else {
			menuu.setName(name);
			menuu.setPrice(price);
			menuuDao.save(menuu);
		}
		return menuu;
	}

	@Override
	public List<Menuu> getAllMeals() {
		List<Menuu> menuulist = menuuDao.findAll();
		return menuulist;
	}

	@Override
	public Menuu findMealByName(String name) {
		Optional<Menuu> list = menuuDao.findById(name);
		if (!list.isPresent()) {
			return null;
		}
		return list.orElse(null);
	}

	@Override
	public Integer order(List<OrderrRequest> order) {
		int totalPrice = 0; // 設定宣告之總價格初始值為零
		for (OrderrRequest orderr : order) {
			
			if (orderr.getName() == null || orderr.getName().isEmpty() || orderr.getQuantity() < 0) {
				continue;
			}

			Optional<Menuu> menuuOp = menuuDao.findById(orderr.getName());
			if (menuuOp.isPresent()) {
				Menuu menuu = menuuOp.get();
				totalPrice += menuu.getPrice() * orderr.getQuantity();
			}
		}
		return (totalPrice > 500) ? Double.valueOf(totalPrice * 0.9).intValue() : totalPrice;
	}

}
