package com.example.demo_project.vo;

import com.example.demo_project.entity.Register;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterResponse {
	
	@JsonProperty("registr_info")
	private Register register;
	
	private String message;
	
	@JsonProperty("verify_code")
	private int verifyCode;
	
	public RegisterResponse() {
	}
	
	public RegisterResponse(Register register, String message) {
		this.register = register;
		this.message = message;
	}
	
	public RegisterResponse(String message, int verifyCode) {
		this.message = message;
		this.verifyCode = verifyCode;
	}

	public RegisterResponse(String message) {
		this.message = message;
	}
	
	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(int verifyCode) {
		this.verifyCode = verifyCode;
	}
	
}
