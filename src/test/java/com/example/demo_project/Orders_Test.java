package com.example.demo_project;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.demo_project.repository.OrdersDao;
import com.example.demo_project.vo.OrdersInfo;

@WebAppConfiguration
@SpringBootTest(classes = DemoProjectApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Orders_Test {
//	private static final String CONTENT_TYPE = "application/json;charset=UTF-8";
//
//	@Autowired
//	private WebApplicationContext wac;
//
//	private MockMvc mockMvc;
//	
//	@Autowired
//	private OrderService orderService;

	@Autowired
	private OrdersDao ordersDao;
	
	@Test
	public void findAllOrdersInfoDaoTest() {
		List<OrdersInfo> result = ordersDao.findAllOrdersInfo();
		for(OrdersInfo orderInfo : result) {
			System.out.println(orderInfo.getCustomerId());
			System.out.println(orderInfo.getProductName());
			System.out.println(orderInfo.getName());
			System.out.println(orderInfo.getQuantity());
		}
	}
	
	@Test
	public void findOrdersInfoByCustomersIdIn() {
		List<OrdersInfo> result = ordersDao.findOrdersInfoByCustomersIdIn(1);
		for(OrdersInfo orderInfo : result) {
			System.out.println(orderInfo.getCustomerId());
			System.out.println(orderInfo.getProductName());
			System.out.println(orderInfo.getName());
			System.out.println(orderInfo.getQuantity());
		}
	}
}
