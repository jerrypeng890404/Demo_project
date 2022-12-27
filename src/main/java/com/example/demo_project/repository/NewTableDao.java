package com.example.demo_project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_project.entity.NewTable;

@Transactional
@Repository
public interface NewTableDao extends JpaRepository<NewTable, Integer>{

	public List<NewTable> findLabelByGroupId(String groupId);
	
	public List<NewTable> findByGroupNameContaining(String groupName);
}
