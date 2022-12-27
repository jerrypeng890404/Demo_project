package com.example.demo_project.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo_project.annotation.ConditionalOnA;
import com.example.demo_project.constants.RegisterRtnCode;
import com.example.demo_project.entity.Register;
import com.example.demo_project.ifs.RegisterService;
import com.example.demo_project.repository.RegisterDao;
import com.example.demo_project.vo.RegisterRequest;
import com.example.demo_project.vo.RegisterResponse;
import com.mysql.cj.xdevapi.Result;

//主鍵(都會執行)
@Primary
//@ConditionalOnA
@EnableScheduling
@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDao registerDao;

	@Override
	public Register register(String account, String pwd, String name, int age, String city) {
		// 不能註冊已存在帳號
		if (registerDao.existsById(account)) {
			return null;
		}

//		int hashPwd = "123456789".hashCode(); //雜湊值(不可逆亂碼)
		Register register = new Register(account, pwd, name, age, city);

		register.setRegTime(new Date()); // new Date() -> 系統當前時間
//		register.setActive(false); //boolean預設為false可不寫
		register.setRole("General"); // 新增腳色
		return registerDao.save(register);
	}

	@Override
	public RegisterResponse activeAccount(String account) {
		Optional<Register> regOp = registerDao.findById(account);
		if (regOp.isPresent()) {
			Register reg = regOp.get();
			reg.setActive(true);
			registerDao.save(reg);
			return new RegisterResponse(null, RegisterRtnCode.SUCCESSFUL.getMessage());
		}
		return new RegisterResponse(null, RegisterRtnCode.FAILURE.getMessage());
	}

	@Override
	public RegisterResponse addRole(String account, List<String> rolelist) {
		Optional<Register> regOp = registerDao.findById(account);
		// 判斷存在後取出
		if (regOp.isPresent()) {
			Set<String> roleset = new HashSet<>();
			// 去除 rolelist 重複的參數
			for (String str : rolelist) {
				roleset.add(str);
			}
			// 去除DB中已存在"值"和"參數值"兩者重複部分
			Register reg = regOp.get();
			String role = reg.getRole(); // 可能有多個,用","區隔 EX:General, SA, PM
			String[] roleArray = role.split(","); // 以逗號來分割多個值
			// foreach
			for (String item : roleArray) {
				String str = item.trim(); // trim() --> 去除前後空白
				roleset.add(str);
			}

			// 陣列轉成字串 //substring --> 利用索引值取得字串中內容
			String newStr = rolelist.toString().substring(1, rolelist.toString().length() - 1);
			reg.setRole(newStr);
			registerDao.save(reg);
			return new RegisterResponse(reg, RegisterRtnCode.SUCCESSFUL.getMessage());
		}
		return new RegisterResponse(null, RegisterRtnCode.ADD_ROLE_FAILURE.getMessage());
	}

	@Override
	public RegisterResponse addRoleSet(String account, Set<String> roleset) {
		Optional<Register> regOp = registerDao.findById(account);
		// 判斷存在後取出
		if (regOp.isPresent()) {
			for (String str : roleset) {
				roleset.add(str);
			}
			// 去除DB中已存在"值"和"參數值"兩者重複部分
			Register reg = regOp.get();
			String role = reg.getRole(); // 可能有多個,用","區隔 EX:General, SA, PM
			String[] roleArray = role.split(","); // 以逗號來分割多個值
			// foreach
			for (String item : roleArray) {
				String str = item.trim();
				roleset.add(str);
			}

//			for(int i = 0; i < roleArray.length; i++) {
//				String item = roleArray[i].trim(); //trim() --> 去除前後空白
//				roleSet.add(item);
//			}
			String newStr = roleset.toString().substring(1, roleset.toString().length() - 1);
			reg.setRole(newStr);
			registerDao.save(reg);
			return new RegisterResponse(reg, RegisterRtnCode.SUCCESSFUL.getMessage());
		}
		return new RegisterResponse(null, RegisterRtnCode.ADD_ROLE_FAILURE.getMessage());

	}

//	//排程通知
//	//application properties 中設定
//	@Scheduled(fixedRateString = "${heartbeat.ms}")
//	public void schedulePrintDate() {
//		System.out.println("AAA");
//		System.out.println(new Date());
//	}

//	// 排程通知
//	                //秒 分 時 日 月 週 年
//	@Scheduled(cron = "0 0 10 ? * *")
//	public void schedulePrintDate() {
//		System.out.println(new Date());
//	}
	
//	@Scheduled(cron = "1/2 * 12-13 * * ?")
//	public void schedulePrintDate() {
//		System.out.println(new Date());
//	}
	
	@Override
	public Register findById(String id) {
		Optional<Register> op = registerDao.findById(id);
		if(op.isPresent()) {
			System.out.println("text");
			return op.get();
		}
		return null;
//		return op.orElse(null);
	}
	
	@Override
	public List<Register> findAll() {
//		int a = 5/0;
		return registerDao.findAll();
	}
}
