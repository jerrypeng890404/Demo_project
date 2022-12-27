package com.example.demo_project.repository;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.util.CollectionUtils;

public class BaseDao {

	@PersistenceContext // JPA專有註解
	private EntityManager entityManager;

	@SuppressWarnings({"unchecked", "rawtypes"})
	protected <EntityType> List<EntityType> doQuery(String sql, Map<String, Object> params, Class<EntityType> clazz) { // 無分頁筆數
		Query query = entityManager.createQuery(sql, clazz);
		if (!CollectionUtils.isEmpty(params)) {
			//原本使用entrySet遍歷取值
			for (Entry<String, Object> item : params.entrySet()) {
				query.setParameter(item.getKey(), item.getValue());
			}
//			for(Parameter p : query.getParameters()) {
//				query.setParameter(p, params.get(p.getName()));
//			}
		}
		return query.getResultList();
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	protected <EntityType> List<EntityType> doQuery(String sql, Map<String, Object> params, Class<EntityType> clazz, int pageSize) { // 無分頁筆數
		Query query = entityManager.createQuery(sql, clazz);
		if (!CollectionUtils.isEmpty(params)) {
			//原本使用entrySet遍歷取值
//			for (Entry<String, Object> item : params.entrySet()) {
//				query.setParameter(item.getKey(), item.getValue());
//			}
			for(Parameter p : query.getParameters()) {
				query.setParameter(p, params.get(p.getName()));
			}
		}
		if(pageSize > 0) {
			query.setMaxResults(pageSize);
		}
		return query.getResultList();
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	protected <EntityType> List<EntityType> doQuery(String sql, Map<String, Object> params, Class<EntityType> clazz, int pageSize, int startPosition) { // 無分頁筆數
		Query query = entityManager.createQuery(sql, clazz);
		if (!CollectionUtils.isEmpty(params)) {
			//原本使用entrySet遍歷取值
//			for (Entry<String, Object> item : params.entrySet()) {
//				query.setParameter(item.getKey(), item.getValue());
//			}
			for(Parameter p : query.getParameters()) {
				query.setParameter(p, params.get(p.getName()));
			}
		}
		if(pageSize > 0) {
			query.setMaxResults(pageSize);
		}
		if(startPosition >= 0) {
			query.setFirstResult(startPosition);
		}
		return query.getResultList();
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	protected <EntityType> List<EntityType> doNativeQuery(String nativeSql, Map<String, Object> params, Class<EntityType> clazz, int pageSize, int startPosition) { // 無分頁筆數
		Query query = null;
		if(clazz == null) {
			query = entityManager.createNativeQuery(nativeSql);
		}else {
			query = entityManager.createNativeQuery(nativeSql, clazz);
		}
		if (!CollectionUtils.isEmpty(params)) {
			//原本使用entrySet遍歷取值
//			for (Entry<String, Object> item : params.entrySet()) {
//				query.setParameter(item.getKey(), item.getValue());
//			}
			for(Parameter p : query.getParameters()) {
				query.setParameter(p, params.get(p.getName()));
			}
		}
		if(pageSize > 0) {
			query.setMaxResults(pageSize);
		}
		if(startPosition >= 0) {
			query.setFirstResult(startPosition);
		}
		return query.getResultList();
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	protected int doUpdate(String sql, Map<String, Object> params) { // 無分頁筆數
		Query query = entityManager.createQuery(sql);
		if (!CollectionUtils.isEmpty(params)) {
			//原本使用entrySet遍歷取值
//			for (Entry<String, Object> item : params.entrySet()) {
//				query.setParameter(item.getKey(), item.getValue());
//			}
			for(Parameter p : query.getParameters()) {
				query.setParameter(p, params.get(p.getName()));
			}
		}
		return query.executeUpdate();
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	protected int doNativeUpdate(String nativeSql, Map<String, Object> params) { // 無分頁筆數
		Query query = entityManager.createNativeQuery(nativeSql);
		if (!CollectionUtils.isEmpty(params)) {
			//原本使用entrySet遍歷取值
//			for (Entry<String, Object> item : params.entrySet()) {
//				query.setParameter(item.getKey(), item.getValue());
//			}
			for(Parameter p : query.getParameters()) {
				query.setParameter(p, params.get(p.getName()));
			}
		}
		return query.executeUpdate();
	}
}
