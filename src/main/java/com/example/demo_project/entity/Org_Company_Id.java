package com.example.demo_project.entity;

import java.io.Serializable;

@SuppressWarnings("serial") //����ĵ�i
public class Org_Company_Id implements Serializable {

	//��9�B11�欰�ƦX�D��
	private String orgId;

	private String companyId;

	public Org_Company_Id() {
	}
	
	public Org_Company_Id(String orgId, String companyId) {
		this.orgId = orgId;
		this.companyId = companyId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

}
