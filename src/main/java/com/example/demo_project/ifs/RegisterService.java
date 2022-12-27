package com.example.demo_project.ifs;

import java.util.List;
import java.util.Set;

import com.example.demo_project.entity.Register;
import com.example.demo_project.vo.RegisterResponse;

public interface RegisterService {
	
	public Register register(String account, String pwd, String name, int age, String city);

	public RegisterResponse activeAccount(String account);
	
	public RegisterResponse addRole(String account, List<String> rolelist);
	
	public RegisterResponse addRoleSet(String account, Set<String> roleset);
	
	public Register findById(String id);
	
	public List<Register> findAll();
}
