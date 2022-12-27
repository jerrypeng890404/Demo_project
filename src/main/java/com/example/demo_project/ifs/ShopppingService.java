package com.example.demo_project.ifs;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Product;

@Service
public interface ShopppingService {
	public void queryProdects(List<String> nameList, List<Product> productList);

	public Product checkout(List<Product> productList);
}
