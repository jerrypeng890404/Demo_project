package com.example.demo_project.ifs;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Menu;

@Service
public interface OrderService {
	
	public List<Menu> one(); //取Menu中所有菜單

	public Menu two(String name);

}
