package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompanyRequest {
	
	@JsonProperty("orgId")
	private String orgId;
	
	@JsonProperty("companyId")
	private String companyId;
	
	public CompanyRequest() {
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
