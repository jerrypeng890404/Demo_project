package com.example.demo_project.constants;

//enum(�C�|)
public enum RegisterRtnCode {
	//==============================================
              //code  message
	SUCCESSFUL("200", "Successful"),
	
	ACCOUNT_REQUIRED("400", "Account is required!!"),
	
	PWD_REQUIRED("400", "Pwd is required!!"),
	
	NAME_REQUIRED("400", "Name is required!!"),
	//��ܦ��A�����M�����\�ѪR�ШD�A���O�Ȥ�ݨS���s���귽���v��
	ACCOUNT_EXISTED("403", "Account existed!!"),
	
	FAILURE("400", "Account active fail!!"),
	
	ADD_ROLE_FAILURE("400", "Add role fail!!"),
	
	ROLE_LIST_IS_EMPTY("400", "RoleList is empty");
	//==============================================
	private String code;

	private String message;

	// enum���u���\�p����k
	private RegisterRtnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}
	//�u��get,set�Τ���
	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
