package com.example.demo_project.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo_project.service.ifs.Active;

@Service
public class ActiveImpl implements Active {
	@Override
	public void fly() {
	}

	@Override
	public void fly(String name, int age) {
		System.out.println(name + "���b��");
		System.out.println("���~" + age + "��");
	}

}
