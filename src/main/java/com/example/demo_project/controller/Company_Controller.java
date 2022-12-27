package com.example.demo_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Company;
import com.example.demo_project.ifs.CompanyService;
import com.example.demo_project.vo.CompanyRequest;

@RestController
public class Company_Controller {

	@Autowired
	private CompanyService companyservice;

	@PostMapping(value = "/api/getcompany")
	public List<Company> findAll() {
		return companyservice.findAll();
	}
	
	@PostMapping(value = "/api/getcompanyById")
	public Company findById(@RequestBody CompanyRequest request) {
		return companyservice.findById(request.getOrgId(), request.getCompanyId());
	}
	
	@PostMapping(value = "/api/updateCompanyById")
	public Company updateById(@RequestBody CompanyRequest request) {
		return companyservice.updateById(request.getOrgId(), request.getCompanyId());
	}
	
	@PostMapping(value = "/api/saveCompany")
	public Company saveCompany(@RequestBody CompanyRequest request) {
		return companyservice.saveCompany();
	}
	
}
