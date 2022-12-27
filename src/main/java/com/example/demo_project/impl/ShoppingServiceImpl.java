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
		if (nameList == null || nameList.isEmpty()) { // null┪フ
			System.out.println("琩高坝珇ぃ眔");
			return;
		}
		Map<String, Product> querMap = new HashMap<>(); //
		for (String nameItem : nameList) {
			for (Product productItem : productList) {
				if (nameItem.equalsIgnoreCase(productItem.getName())) {
					querMap.put(nameItem, productItem); //
					break;
//					System.out.println("珇: " + productItem.getName() + "基: " + productItem.getPrice() + "畐计秖: " + productItem.getStorage());
				} else {
					querMap.put(nameItem, null);
					System.out.println("琩高礚挡狦");
				}
			}
		}
		for (Entry<String, Product> mapItem : querMap.entrySet()) {
			if (mapItem.getValue() == null) {
				System.out.println(mapItem.getKey() + "琩高礚挡狦");
			} else {
				Product product = mapItem.getValue();
				System.out.println(
						"珇: " + product.getName() + "基: " + product.getPrice() + "畐计秖: " + product.getStorage());
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
