package com.example.demo_project;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.entity.Product;
import com.example.demo_project.ifs.ShopppingService;

@SpringBootTest
public class Shopping_UnitTest {
	@Autowired
	private ShopppingService shoppingservice;

	@Test
	public void queryProdects() {
		Product p1 = new Product("A", 50, 1, 10);
		Product p2 = new Product("B", 60, 2, 10);
		Product p3 = new Product("C", 70, 3, 10);
		System.out.println("=================");
		List<Product> productList = new ArrayList<>();
		productList.add(p1);
		productList.add(p2);
		productList.add(p3);
		List<String> querNameList = new ArrayList<>();
		querNameList.add("A");
		querNameList.add("B");
		querNameList.add("C");
		shoppingservice.queryProdects(querNameList, productList);
	}
}
