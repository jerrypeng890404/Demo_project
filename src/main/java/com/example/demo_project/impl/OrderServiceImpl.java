package com.example.demo_project.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Menu;
import com.example.demo_project.ifs.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public List<Menu> one() { // get name & price
		// init
		Menu beef = new Menu("beef", 100);
		Menu pork = new Menu("pork", 90);
		Menu chicken = new Menu("chicken", 80);

		// =================================
		// find all menus from DB(¸ê®Æ®w)
		List<Menu> list = new ArrayList<>();
		list.add(beef);
		list.add(pork);
		list.add(chicken);
		// =================================
		return list;
	}

	@Override
	public Menu two(String name) { // order
		// init
		Menu beef = new Menu("beef", 100);
		Menu pork = new Menu("pork", 90);
		Menu chicken = new Menu("chicken", 80);
		// =================================
		// find menu by name
		if (name.equalsIgnoreCase(beef.getName())) {
			return beef;
		} else if (name.equalsIgnoreCase(pork.getName())) {
			return pork;
		} else if (name.equalsIgnoreCase(chicken.getName())) {
			return chicken;
		} else {
			return new Menu();
		}
	}

}
