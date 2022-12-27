package com.example.demo_project.constants;

public enum ToDoRtnCode {

	SUCCESSFUL("200", "���\!"),
	
	PARAMETER_REQUIRED("400","���n�ѼƯʥ��A�ЦA����!"),
	
	FAILED("500", "�o�Ϳ��~�A�ЦA����!"),
	
	DATA_REQUIRED("417","�ж�g������!");
	
	private String code;
	
	private String message;

	private ToDoRtnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
}
