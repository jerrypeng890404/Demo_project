package com.example.demo_project.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Company;
import com.example.demo_project.entity.Org_Company_Id;
import com.example.demo_project.ifs.CompanyService;
import com.example.demo_project.repository.CompanyDao;

@Service
public class CompanyService_Impl implements CompanyService {

	@Autowired
	private CompanyDao companydao;

	@Override
	public List<Company> findAll() {
		return companydao.findAll();
	}

	@Override
	public Company findById(String orgId, String companyId) {

		Org_Company_Id orgcompanyid = new Org_Company_Id(orgId, companyId);

		Optional<Company> companyOp = companydao.findById(orgcompanyid);

		return companyOp.orElse(new Company()); // ("orElse"�����H�ǤJ���Ѽư����^�ǭ�)

//		if (companyOp.isPresent()) { // 32~36�浥���38��
//			return companyOp.get();
//		}
//
//		return new Company();

	}

	@Override
	public Company updateById(String orgId, String companyId) { //��鷺�e
		Org_Company_Id orgcompanyid = new Org_Company_Id(orgId, companyId);
		Optional<Company> companyOp = companydao.findById(orgcompanyid);
		
		//update name
		if(companyOp.isPresent()) {
			Company com = companyOp.get();
			com.setCompanyName("A02");
			Company newcom = companydao.save(com);
			return newcom;
		}
		return new Company();
		
	}

	@Override
	public Company saveCompany(){ //�s�W���e
		Company com = new Company("AAA", "BBB", "CCC");
		
		return companydao.save(com);
	}
	
}
