package com.example.demo_project.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo_project.entity.Register;

public class RegisterDaoImpl extends BaseDao {

	public List<Register> doQueryByExpiredRegTime(Date date) {
		// StringBuffer﹃
		StringBuffer sb = new StringBuffer();
		sb.append(" select R from Register R").append(" where R.regTime > :expiredDate");
		Map<String, Object> params = new HashMap<>();
		params.put("expiredDate", date);
		// ﹃ Map Class
		return doQuery(sb.toString(), params, Register.class);
	}

	public List<Register> doQueryByExpiredRegTime(Date date, int pageSize) {
		// StringBuffer﹃
		StringBuffer sb = new StringBuffer();
		sb.append(" select R from Register R").append(" where R.regTime > :expiredDate");
		Map<String, Object> params = new HashMap<>();
		params.put("expiredDate", date);
		// ﹃ Map Class
		return doQuery(sb.toString(), params, Register.class, pageSize);
	}

	public List<Register> doQueryByExpiredRegTime(Date date, int pageSize, int startPosition) {
		// StringBuffer﹃
		StringBuffer sb = new StringBuffer();
		sb.append(" select R from Register R").append(" where R.regTime > :expiredDate");
		Map<String, Object> params = new HashMap<>();
		params.put("expiredDate", date);
		// ﹃ Map Class
		return doQuery(sb.toString(), params, Register.class, pageSize, startPosition);
	}

	public List<Register> doNativeQueryByExpiredRegTime(Date date, int pageSize, int startPosition) {
		// StringBuffer﹃
		StringBuffer sb = new StringBuffer();
		// эネSQL粂猭
		sb.append(" select * from register r").append(" where r.reg_time > :expiredDate");
		Map<String, Object> params = new HashMap<>();
		params.put("expiredDate", date);
		// ﹃ Map Class
		return doNativeQuery(sb.toString(), params, Register.class, pageSize, startPosition);
	}

	// update
	public int updateAgeByName(String name, int newAge) {
		// StringBuffer﹃
		StringBuffer sb = new StringBuffer();
		sb.append(" update Register set age = :age");
		sb.append(" where name = :newName");
		Map<String, Object> params = new HashMap<>();
		params.put("age", newAge);
		params.put("newName", name);
		// ﹃ Map Class
		return doUpdate(sb.toString(), params);
	}

	public int updateAgeByAccount(String account, int newAge) {
		// StringBuffer﹃
		StringBuffer sb = new StringBuffer();
		sb.append(" update Register set age = :age");
		sb.append(" where account = :account");
		Map<String, Object> params = new HashMap<>();
		params.put("age", newAge);
		params.put("account", account);
		// ﹃ Map Class
		return doUpdate(sb.toString(), params);
	}

	// update
	public int nativeUpdateAgeByName(String name, int newAge) {
		// StringBuffer﹃
		StringBuffer sb = new StringBuffer();
		sb.append(" update register set age = :age");
		sb.append(" where name = :newName");
		Map<String, Object> params = new HashMap<>();
		params.put("age", newAge);
		params.put("newName", name);
		// ﹃ Map Class
		return doNativeUpdate(sb.toString(), params);
	}

	// native蛤繦嘿
	public int nativeUpdateAgeByAccount(String account, int newAge) {
		// StringBuffer﹃
		StringBuffer sb = new StringBuffer();
		sb.append(" update register set age = :age");
		sb.append(" where account = :account");
		Map<String, Object> params = new HashMap<>();
		params.put("age", newAge);
		params.put("account", account);
		// ﹃ Map Class
		return doNativeUpdate(sb.toString(), params);
	}

	/*
	 * final sql: select * from register r where role like %General% or role like %SA% or role like %SD%
	 * ====================================================================================================== 
	 * Map: key ㄤ癸莱穦籠玡 
	 * params = {role0=%General%, role1=%SA%, role2=%SD%} 
	 * StringBuffer sql: select * from register r where role like role0 or role like role1 or role like role2 
	 * params  key の StringBuffer sql 0, 1, 2 把计 roleList  index 
	 * 璶耞把计琌程穦∕﹚ StringBuffer sql 琌璶 or
	 */
	public List<Register> doQueryRoleContains(List<String> roleList) {
		StringBuffer sb = new StringBuffer();
		Map<String, Object> params = new HashMap<>();
		sb.append(" select * from register r where ");
		for(int i = 0; i < roleList.size(); i++) {
			String item = roleList.get(i);
			
			if(i < roleList.size() - 1) {
				sb.append(" role like :role" + i + " or ");
			}else {
				sb.append(" role like :role" + i);
			}
			params.put("role" + i, "%" + item + "%");
		}
		System.out.println(sb.toString());
		return doNativeQuery(sb.toString(), params, Register.class, -1, 0);
	}
}
