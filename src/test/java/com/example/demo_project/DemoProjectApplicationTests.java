package com.example.demo_project;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo_project.controller.BankController;
import com.example.demo_project.entity.Users;
import com.example.demo_project.ifs.Active;
import com.example.demo_project.ifs.BankService;
import com.example.demo_project.impl.ActiveImpl;
import com.example.demo_project.repository.UsersDao;
import com.example.demo_project.vo.BankRequest;
import com.example.demo_project.vo.BankResponse;

@SpringBootTest
class DemoProjectApplicationTests {
	@Autowired
	private Active activeImpl; // 權限 型態 變數

	@Autowired
	private BankService bankservice;

	@Autowired
	private BankController bankController;

	@Autowired
	private UsersDao usersDao;

	public static void main(String[] args) {
		ActiveImpl act = new ActiveImpl();
		act.fly("GG", 5);
	}

//	@Test
//	public void contextLoads() {
//		activeImpl.fly("AAA", 0);
//	}

	@Test
	public void banktest() {
		BankRequest req = new BankRequest();
		req.setAccount(" ");
		BankResponse res = bankController.getAmount(req);
		System.out.println(res.getAccount());
		System.out.println(res.getAmount());
		System.out.println(res.getMessage());

	}

	@Test
	public void addUsersInfo() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Users u1 = new Users("AAA", encoder.encode("AA123"), "admin", true);
		Users u2 = new Users("BBB", encoder.encode("BB123"), "user", true);
		Users u3 = new Users("CCC", encoder.encode("CC123"), "user", true);
		Users u4 = new Users("DDD", encoder.encode("DD123"), "user", false);
		List<Users> list = Arrays.asList(u1, u2, u3, u4);
		usersDao.saveAll(list);
	}
}
