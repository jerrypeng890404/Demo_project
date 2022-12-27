package com.example.demo_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_project.entity.Customers;

@Repository
public interface CustomersDao extends JpaRepository<Customers, Integer>{

}
