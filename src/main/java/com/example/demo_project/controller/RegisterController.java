package com.example.demo_project.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.constants.RegisterRtnCode;
import com.example.demo_project.entity.Register;
import com.example.demo_project.ifs.RegisterService;
import com.example.demo_project.vo.ActiveAccountReq;
import com.example.demo_project.vo.AddRoleListReq;
import com.example.demo_project.vo.AddRoleSetReq;
import com.example.demo_project.vo.LoginInfo;
import com.example.demo_project.vo.RegisterRequest;
import com.example.demo_project.vo.RegisterResponse;

import io.swagger.v3.oas.annotations.Hidden;

@Hidden
@RestController
public class RegisterController {

    //�����T��
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private RegisterService regiterService;

	@PostMapping(value = "/api/regiter")
	public RegisterResponse regiter(@RequestBody RegisterRequest req, HttpSession httpSession) {

		RegisterResponse checkResult = checkParam(req);
		if (checkResult != null) {
			return checkResult;
		}

		Register register = regiterService.register(req.getAccount(), req.getPwd(), req.getName(), req.getAge(),
				req.getCity());

		if (register == null) {
			return new RegisterResponse(RegisterRtnCode.ACCOUNT_EXISTED.getMessage());
		}
		//�s�W���ҽX add verify code into httpSession
		//�|����H���X(*10000��)
		double radom = Math.random()*10000;
		//double�|�ˤ��J(round)���૬��int
		int verifyCode = (int)Math.round(radom);
		//�������ҽX
		httpSession.setAttribute("verify_code", verifyCode);
		//���Үɮ�(�w�]��30min)
		httpSession.setMaxInactiveInterval(10000);
		httpSession.setAttribute("�b��", req.getAccount());
		httpSession.setMaxInactiveInterval(10000);
		return new RegisterResponse(RegisterRtnCode.SUCCESSFUL.getMessage(), verifyCode);
	}

	// ==========================================================
	//�p�����b��k
	private RegisterResponse checkParam(RegisterRequest req) {
		if (!StringUtils.hasText(req.getAccount())) {
			return new RegisterResponse(RegisterRtnCode.ACCOUNT_REQUIRED.getMessage());
		} else if (!StringUtils.hasText(req.getPwd())) {
			return new RegisterResponse(RegisterRtnCode.PWD_REQUIRED.getMessage());
		} else if (!StringUtils.hasText(req.getName())) {
			return new RegisterResponse(RegisterRtnCode.NAME_REQUIRED.getMessage());
		}
		return null;
	}

	// ==========================================================
//	private RegisterResponse checkParamm(RegisterRequest req) {
//		if (!StringUtils.hasText(req.getAccount()) || !StringUtils.hasText(req.getPwd()) || !StringUtils.hasText(req.getName())) {
//			return new RegisterResponse("��줣�o�ť�!!");
//		}
//		return null;
//	}
	// ==========================================================
	@PostMapping(value = "/api/active_account")
	public RegisterResponse activeAccount(@RequestBody RegisterRequest req) {
		if (!StringUtils.hasText(req.getAccount())) {
			return new RegisterResponse(RegisterRtnCode.ACCOUNT_REQUIRED.getMessage());
		}

		return regiterService.activeAccount(req.getAccount());
		// ���G�w�]��false
//		if(result) {
//			return new RegisterResponse(null, RegisterRtnCode.SUCCESSFUL.getMessage());
//		}
//		//�Ϥ�
//		return new RegisterResponse(null, RegisterRtnCode.FAILURE.getMessage());
	}

	// ==================================================================================
	@PostMapping(value = "/api/add_role_list")
	public RegisterResponse addRole(@RequestBody AddRoleListReq req) {
		if (!StringUtils.hasText(req.getAccount())) {
			return new RegisterResponse(RegisterRtnCode.ACCOUNT_REQUIRED.getMessage());
		}
//		if (req.getRoleList().isEmpty()) {
		if (CollectionUtils.isEmpty(req.getRoleList())) {
			return new RegisterResponse(RegisterRtnCode.ROLE_LIST_IS_EMPTY.getMessage());
		}
		return regiterService.addRole(req.getAccount(), req.getRoleList());
	}

	// ==================================================================================
	@PostMapping(value = "/api/add_role_set")
	public RegisterResponse addRoleSet(@RequestBody AddRoleSetReq req) {
		if (!StringUtils.hasText(req.getAccount())) {
			return new RegisterResponse(RegisterRtnCode.ACCOUNT_REQUIRED.getMessage());
		}
//		if(req.getRoleSet() == null || req.getRoleSet().isEmpty()){
//		if (CollectionUtils.isEmpty(req.getRoleSet())) {
		if (CollectionUtils.isEmpty(req.getRoleSet())) {
			return new RegisterResponse(RegisterRtnCode.ROLE_LIST_IS_EMPTY.getMessage());
		}
		return regiterService.addRoleSet(req.getAccount(), req.getRoleSet());
	}
	// ==================================================================================
	//�n�J
	@PostMapping(value = "/api/login")
	public RegisterResponse login(@RequestBody LoginInfo loginInfo, HttpSession httpSession) {
		if(!StringUtils.hasText(loginInfo.getAccount()) || !StringUtils.hasText(loginInfo.getPwd())){
			return new RegisterResponse("���~���b��");
		}
		Register result = regiterService.findById(loginInfo.getAccount());
		if(result == null) {
			return new RegisterResponse("UserInfo not found!!");
		}
		//���o�ϥΪ̱b��
		httpSession.setAttribute("user_account", result.getAccount());
		//�������Үɮ�(�w�]��30min)
		httpSession.setMaxInactiveInterval(100);
		return new RegisterResponse(result, "Login success!!");
	}
	
	//���o�b����T(���ҥ�)
	@PostMapping(value = "/api/get_user_info")
	public RegisterResponse getUserInfo(HttpSession httpSession) {
		Object attValue = httpSession.getAttribute("user_account");
		if (attValue != null) {
			//�����૬���r�� toString
			String account = httpSession.getAttribute("user_account").toString();
			Register result = regiterService.findById(account);
			return new RegisterResponse(result, "Get user info success!!");
		}
		//�����૬���r�� toString
//		String account = httpSession.getAttribute("user_account").toString();
//		Register result = regiterService.findById(account);
		return new RegisterResponse(new Register(), "Get user info error!!");
	}
	
	//�n�X
	@PostMapping(value = "/api/logout")
	public RegisterResponse logout(HttpSession httpSession) {
		httpSession.removeAttribute("user_account");
		return new RegisterResponse("Logout success!!");
	}
	
	//�T�{���ҽX�E���b��
	@PostMapping(value = "/api/active_account2")
	public RegisterResponse activeAccount2(@RequestBody ActiveAccountReq req, HttpSession httpSession) {
		Object verifyCode = httpSession.getAttribute("verify_code");
		String account = httpSession.getAttribute("�b��").toString();
		if(verifyCode != null && account != null) {
			int verifyCode1 = (int)verifyCode;
			if(verifyCode1 == req.getVerifyCode()) {
				Register result = regiterService.findById(account);
				regiterService.activeAccount(result.getAccount());
				return new RegisterResponse(result, "���Ҧ��\");
			}
		}
		return new RegisterResponse(new Register(), "���ҥ���");
	}
}
