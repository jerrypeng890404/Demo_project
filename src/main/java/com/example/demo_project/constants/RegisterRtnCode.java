package com.example.demo_project.constants;

//enum(列舉)
public enum RegisterRtnCode {
	//==============================================
              //code  message
	SUCCESSFUL("200", "Successful"),
	
	ACCOUNT_REQUIRED("400", "Account is required!!"),
	
	PWD_REQUIRED("400", "Pwd is required!!"),
	
	NAME_REQUIRED("400", "Name is required!!"),
	//表示伺服器雖然有成功解析請求，但是客戶端沒有存取資源的權限
	ACCOUNT_EXISTED("403", "Account existed!!"),
	
	FAILURE("400", "Account active fail!!"),
	
	ADD_ROLE_FAILURE("400", "Add role fail!!"),
	
	ROLE_LIST_IS_EMPTY("400", "RoleList is empty");
	//==============================================
	private String code;

	private String message;

	// enum中只允許私有方法
	private RegisterRtnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}
	//只有get,set用不到
	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
