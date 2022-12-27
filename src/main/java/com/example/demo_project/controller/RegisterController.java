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

    //紀錄訊息
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
		//新增驗證碼 add verify code into httpSession
		//四位數隨機碼(*10000內)
		double radom = Math.random()*10000;
		//double四捨五入(round)後轉型成int
		int verifyCode = (int)Math.round(radom);
		//產生驗證碼
		httpSession.setAttribute("verify_code", verifyCode);
		//驗證時效(預設為30min)
		httpSession.setMaxInactiveInterval(10000);
		httpSession.setAttribute("帳號", req.getAccount());
		httpSession.setMaxInactiveInterval(10000);
		return new RegisterResponse(RegisterRtnCode.SUCCESSFUL.getMessage(), verifyCode);
	}

	// ==========================================================
	//私有防呆方法
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
//			return new RegisterResponse("欄位不得空白!!");
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
		// 結果預設為false
//		if(result) {
//			return new RegisterResponse(null, RegisterRtnCode.SUCCESSFUL.getMessage());
//		}
//		//反之
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
	//登入
	@PostMapping(value = "/api/login")
	public RegisterResponse login(@RequestBody LoginInfo loginInfo, HttpSession httpSession) {
		if(!StringUtils.hasText(loginInfo.getAccount()) || !StringUtils.hasText(loginInfo.getPwd())){
			return new RegisterResponse("錯誤的帳號");
		}
		Register result = regiterService.findById(loginInfo.getAccount());
		if(result == null) {
			return new RegisterResponse("UserInfo not found!!");
		}
		//取得使用者帳號
		httpSession.setAttribute("user_account", result.getAccount());
		//限制驗證時效(預設為30min)
		httpSession.setMaxInactiveInterval(100);
		return new RegisterResponse(result, "Login success!!");
	}
	
	//取得帳號資訊(驗證用)
	@PostMapping(value = "/api/get_user_info")
	public RegisterResponse getUserInfo(HttpSession httpSession) {
		Object attValue = httpSession.getAttribute("user_account");
		if (attValue != null) {
			//物件轉型為字串 toString
			String account = httpSession.getAttribute("user_account").toString();
			Register result = regiterService.findById(account);
			return new RegisterResponse(result, "Get user info success!!");
		}
		//物件轉型為字串 toString
//		String account = httpSession.getAttribute("user_account").toString();
//		Register result = regiterService.findById(account);
		return new RegisterResponse(new Register(), "Get user info error!!");
	}
	
	//登出
	@PostMapping(value = "/api/logout")
	public RegisterResponse logout(HttpSession httpSession) {
		httpSession.removeAttribute("user_account");
		return new RegisterResponse("Logout success!!");
	}
	
	//確認驗證碼激活帳號
	@PostMapping(value = "/api/active_account2")
	public RegisterResponse activeAccount2(@RequestBody ActiveAccountReq req, HttpSession httpSession) {
		Object verifyCode = httpSession.getAttribute("verify_code");
		String account = httpSession.getAttribute("帳號").toString();
		if(verifyCode != null && account != null) {
			int verifyCode1 = (int)verifyCode;
			if(verifyCode1 == req.getVerifyCode()) {
				Register result = regiterService.findById(account);
				regiterService.activeAccount(result.getAccount());
				return new RegisterResponse(result, "驗證成功");
			}
		}
		return new RegisterResponse(new Register(), "驗證失敗");
	}
}
