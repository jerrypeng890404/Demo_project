package com.example.demo_project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.service.ifs.Active;
import com.example.demo_project.service.impl.ActiveImpl;

@SpringBootTest
class DemoProjectApplicationTests {
	@Autowired
	private Active activeImpl; //權限 型態 變數

	public static void main(String[] args) {
		ActiveImpl act = new ActiveImpl();
		act.fly("GG", 5);
	}

	@Test
	public void contextLoads() {
		activeImpl.fly("AAA", 0);
	}
}
