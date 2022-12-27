package com.example.demo_project.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_project.entity.NewTable;
import com.example.demo_project.ifs.NewTableService;
import com.example.demo_project.repository.NewTableDao;
import com.example.demo_project.vo.NewTableReq;

@Service
public class NewTableServiceImpl implements NewTableService {

	@Autowired
	private NewTableDao newTableDao;

	@Override
	public List<NewTable> getNewTableList() throws Exception {
		List<NewTable> newTableList = newTableDao.findAll();
		if (newTableList == null || newTableList.isEmpty())
			return null;
		// 根據新增時間排序
//		newTableList.sort(Comparator.comparing(NewTable::getCreateDate).reversed());
		return newTableList;
	}

	@Override
	public List<NewTable> getNewTableList(NewTableReq req) throws Exception {
		List<NewTable> newTableList = newTableDao.findByGroupNameContaining(req.getGroupName());
		if (newTableList == null || newTableList.isEmpty())
			return null;
//		newTableList.sort(Comparator.comparing(NewTable::getCreateDate).reversed());
		return newTableList;
	}

	// 利用 groupId 找到 label
	@Override
	public List<NewTable> getLabelList(NewTableReq req) {
		List<NewTable> labelList = newTableDao.findLabelByGroupId(req.getGroupId());
		if (labelList == null || labelList.isEmpty()) {
			return null;
		}
		return labelList;
	}

	@Override
	public void createNewTable(NewTableReq req) throws Exception {
		NewTable toCreateNewTable = new NewTable(req.getGroupId(), req.getGroupName(), req.getLabelId(), req.getLabel(),
				false, req.getCreator(), LocalDateTime.now());
		newTableDao.save(toCreateNewTable);
	}

	@Override
	public void activeNewTable(NewTableReq req) throws Exception {
		Optional<NewTable> newTableOp = newTableDao.findById(req.getId());
		if (!newTableOp.isPresent())
			throw new Exception("To set status of NewTable is null");

		NewTable toUpdatenewTable = newTableOp.get();
		toUpdatenewTable.setStatus(req.isStatus());
		newTableDao.save(toUpdatenewTable);
	}

	@Override
	public void updateNewTable(NewTableReq req) throws Exception {
		Optional<NewTable> newTableOp = newTableDao.findById(req.getId());
		if (!newTableOp.isPresent())
			throw new Exception("To update NewTable is null");

		NewTable toUpdateNewTable = newTableOp.get();
		toUpdateNewTable.setGroupId(req.getGroupId());
		toUpdateNewTable.setGroupName(req.getGroupName());
		toUpdateNewTable.setLabelId(req.getLabelId());
		toUpdateNewTable.setLabel(req.getLabel());
		toUpdateNewTable.setModifier(req.getModifier());
		toUpdateNewTable.setModifyDate(LocalDateTime.now());
		newTableDao.save(toUpdateNewTable);
	}
}
