package com.example.demo_project.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Product;
import com.example.demo_project.ifs.ShopppingService;

@Service
public class ShoppingServiceImpl implements ShopppingService {

	@Override
	public void queryProdects(List<String> nameList, List<Product> productList) {
		if (nameList == null || nameList.isEmpty()) { // null�Ϊť�
			System.out.println("�d�߰ӫ~���o����");
			return;
		}
		Map<String, Product> querMap = new HashMap<>(); //
		for (String nameItem : nameList) {
			for (Product productItem : productList) {
				if (nameItem.equalsIgnoreCase(productItem.getName())) {
					querMap.put(nameItem, productItem); //
					break;
//					System.out.println("�~�W: " + productItem.getName() + "����: " + productItem.getPrice() + "�w�s�ƶq: " + productItem.getStorage());
				} else {
					querMap.put(nameItem, null);
					System.out.println("�d�ߵL���G");
				}
			}
		}
		for (Entry<String, Product> mapItem : querMap.entrySet()) {
			if (mapItem.getValue() == null) {
				System.out.println(mapItem.getKey() + "�d�ߵL���G");
			} else {
				Product product = mapItem.getValue();
				System.out.println(
						"�~�W: " + product.getName() + "����: " + product.getPrice() + "�w�s�ƶq: " + product.getStorage());
			}
		}

	}

	@Override
	public Product checkout(List<Product> productList) {
//		List<String> list = List.of("", "", "");
//		list.add(null);
//		list.add(null);
//		list.add(null);
		return null;
	}

}
