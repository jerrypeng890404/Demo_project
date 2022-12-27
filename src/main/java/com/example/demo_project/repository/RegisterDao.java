package com.example.demo_project.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo_project.entity.Register;

@Repository
public interface RegisterDao extends JpaRepository<Register, String>{
	@Transactional
	@Modifying
                  //∏Ú¿HEntity¶W∫Ÿ
	@Query(" update Register reg set reg.name = :newName, reg.age = :newAge, reg.city = :newCity, reg.regTime = :newRegTime "
			+ " where account = :account ")
	public int updateRegisterInfo(
			@Param("newName") String newName,
			@Param("newAge") int newAge,
			@Param("newCity") String newCity,
			@Param("newRegTime") Date newRegTime,
			@Param("account") String account);
	
	public List<Register> doQueryByExpiredRegTime(Date date);
	
	public List<Register> doQueryByExpiredRegTime(Date date, int pageSize);
	
	public List<Register> doQueryByExpiredRegTime(Date date, int pageSize, int startPosition);
	
	public List<Register> doNativeQueryByExpiredRegTime(Date date, int pageSize, int startPosition);
	
	@Transactional
	public int updateAgeByName(String name, int newAge);
	
	@Transactional
	public int updateAgeByAccount(String account, int newAge);
	
	@Transactional
	public int nativeUpdateAgeByName(String name, int newAge);
	
	@Transactional
	public int nativeUpdateAgeByAccount(String account, int newAge);
	
	//dynamic params
	public List<Register> doQueryRoleContains(List<String> roleList);
}
