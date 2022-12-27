package com.example.demo_project.ifs;

import java.util.List;

import com.example.demo_project.entity.NewTable;
import com.example.demo_project.vo.NewTableReq;

public interface NewTableService {

	//検索機能（パラメータなし）
	public List<NewTable> getNewTableList() throws Exception;
	
	//検索機能（パラメータあり）
	public List<NewTable> getNewTableList(NewTableReq req) throws Exception;
	
	//検索機能(groupIdで)
	public List<NewTable> getLabelList(NewTableReq req) throws Exception;
	
	//増加機能
	public void createNewTable(NewTableReq req) throws Exception;
	
	//状態の変更機能
	public void activeNewTable(NewTableReq req) throws Exception;
	
	//編集機能
	public void updateNewTable(NewTableReq req) throws Exception;
}
