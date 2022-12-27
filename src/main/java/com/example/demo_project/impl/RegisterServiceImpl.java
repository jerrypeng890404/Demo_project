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

//�D��(���|����)
@Primary
//@ConditionalOnA
@EnableScheduling
@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDao registerDao;

	@Override
	public Register register(String account, String pwd, String name, int age, String city) {
		// ������U�w�s�b�b��
		if (registerDao.existsById(account)) {
			return null;
		}

//		int hashPwd = "123456789".hashCode(); //�����(���i�f�ýX)
		Register register = new Register(account, pwd, name, age, city);

		register.setRegTime(new Date()); // new Date() -> �t�η�e�ɶ�
//		register.setActive(false); //boolean�w�]��false�i���g
		register.setRole("General"); // �s�W�}��
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
		// �P�_�s�b����X
		if (regOp.isPresent()) {
			Set<String> roleset = new HashSet<>();
			// �h�� rolelist ���ƪ��Ѽ�
			for (String str : rolelist) {
				roleset.add(str);
			}
			// �h��DB���w�s�b"��"�M"�Ѽƭ�"��̭��Ƴ���
			Register reg = regOp.get();
			String role = reg.getRole(); // �i�঳�h��,��","�Ϲj EX:General, SA, PM
			String[] roleArray = role.split(","); // �H�r���Ӥ��Φh�ӭ�
			// foreach
			for (String item : roleArray) {
				String str = item.trim(); // trim() --> �h���e��ť�
				roleset.add(str);
			}

			// �}�C�ন�r�� //substring --> �Q�ί��ޭȨ��o�r�ꤤ���e
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
		// �P�_�s�b����X
		if (regOp.isPresent()) {
			for (String str : roleset) {
				roleset.add(str);
			}
			// �h��DB���w�s�b"��"�M"�Ѽƭ�"��̭��Ƴ���
			Register reg = regOp.get();
			String role = reg.getRole(); // �i�঳�h��,��","�Ϲj EX:General, SA, PM
			String[] roleArray = role.split(","); // �H�r���Ӥ��Φh�ӭ�
			// foreach
			for (String item : roleArray) {
				String str = item.trim();
				roleset.add(str);
			}

//			for(int i = 0; i < roleArray.length; i++) {
//				String item = roleArray[i].trim(); //trim() --> �h���e��ť�
//				roleSet.add(item);
//			}
			String newStr = roleset.toString().substring(1, roleset.toString().length() - 1);
			reg.setRole(newStr);
			registerDao.save(reg);
			return new RegisterResponse(reg, RegisterRtnCode.SUCCESSFUL.getMessage());
		}
		return new RegisterResponse(null, RegisterRtnCode.ADD_ROLE_FAILURE.getMessage());

	}

//	//�Ƶ{�q��
//	//application properties ���]�w
//	@Scheduled(fixedRateString = "${heartbeat.ms}")
//	public void schedulePrintDate() {
//		System.out.println("AAA");
//		System.out.println(new Date());
//	}

//	// �Ƶ{�q��
//	                //�� �� �� �� �� �g �~
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
