package com.example.demo_project.impl;

import org.springframework.stereotype.Service;

import com.example.demo_project.ifs.Active;

@Service("A1")
public class ActiveImpl implements Active {
	@Override
	public void fly() {
	}

	@Override
	public void fly(String name, int age) {
		System.out.println(name + "正在飛");
		System.out.println("今年" + age + "歲");
	}

}
