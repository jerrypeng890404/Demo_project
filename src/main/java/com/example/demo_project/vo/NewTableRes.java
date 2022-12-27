package com.example.demo_project.vo;

import java.util.List;

import com.example.demo_project.entity.NewTable;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NewTableRes {

	private String statusCode;

	private String message;

	private List<NewTable> newTableList;
	
	public NewTableRes() {
	}
	
	public NewTableRes (String statusCode, String message, List<NewTable> newTableList) {
		this.statusCode = statusCode;
		this.message = message;
		this.newTableList = newTableList;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<NewTable> getNewTableList() {
		return newTableList;
	}

	public void setNewTableList(List<NewTable> newTableList) {
		this.newTableList = newTableList;
	}

}
