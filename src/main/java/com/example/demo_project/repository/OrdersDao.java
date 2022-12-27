package com.example.demo_project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo_project.entity.Orders;
import com.example.demo_project.vo.OrdersInfo;

@Transactional
@Repository
public interface OrdersDao extends JpaRepository<Orders, Integer> {

	@Modifying
	// ∏Ú¿HEntity¶W∫Ÿ
	@Query(" SELECT NEW com.example.demo_project.vo.OrdersInfo(c.name, o.productName, o.quantity, o.customerId) "
			+ " FROM Customers c JOIN Orders o ON c.id = o.customerId ")
	public List<OrdersInfo> findAllOrdersInfo();

	@Modifying
	@Query(" SELECT NEW com.example.demo_project.vo.OrdersInfo(c.name, o.productName, o.quantity, o.customerId) "
			+ " FROM Customers c JOIN Orders o ON c.id = o.customerId where c.id = :id ")
	public List<OrdersInfo> findOrdersInfoByCustomersIdIn(@Param("id") int customerId);
}
