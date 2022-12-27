package com.example.demo_project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.constants.NewTableRtnCode;
import com.example.demo_project.entity.NewTable;
import com.example.demo_project.ifs.NewTableService;
import com.example.demo_project.vo.NewTableReq;
import com.example.demo_project.vo.NewTableRes;

//跨網域用
@CrossOrigin
@RestController
public class NewTableController {

	@Autowired
	private NewTableService newTableService ;
	
	//查詢
	@PostMapping("api/getNewTableList")
	public NewTableRes getNewTableList(@RequestBody NewTableReq req) {
		List<NewTable> newTableListRes = new ArrayList<>();
		try {
			newTableListRes = StringUtils.hasText(req.getGroupName())
					? newTableService.getNewTableList(req)
					: newTableService.getNewTableList();
		} catch (Exception e) {
			return new NewTableRes(
					NewTableRtnCode.FAILED.getCode(),
					NewTableRtnCode.FAILED.getMessage(),
					null
					);
		}
		return new NewTableRes(
				NewTableRtnCode.SUCCESSFUL.getCode(),
				NewTableRtnCode.SUCCESSFUL.getMessage(),
				newTableListRes
				);
	}
	
	//查詢(groupId)
	@PostMapping("api/getLabelList")
	public NewTableRes getLabelList(@RequestBody NewTableReq req) {
		List<NewTable> labelListRes = new ArrayList<>();
		try {
			labelListRes = newTableService.getLabelList(req);
		} catch (Exception e) {
			return new NewTableRes(
					NewTableRtnCode.FAILED.getCode(),
					NewTableRtnCode.FAILED.getMessage(),
					null
					);
		}
		return new NewTableRes(
				NewTableRtnCode.SUCCESSFUL.getCode(),
				NewTableRtnCode.SUCCESSFUL.getMessage(),
				labelListRes
				);
	}
	
	//新增
	@PostMapping("api/createNewTable")
	public NewTableRes createNewTable(@RequestBody NewTableReq req) {
		List<NewTable> NewTableResListRes = new ArrayList<>();
		try {
			if(!StringUtils.hasText(req.getLabel())) {
				return new NewTableRes(
						NewTableRtnCode.DATA_REQUIRED.getCode(),
						NewTableRtnCode.DATA_REQUIRED.getMessage(),
						null
						);
			}
			
			newTableService.createNewTable(req);
			NewTableResListRes = newTableService.getNewTableList();
		} catch (Exception e) {
			return new NewTableRes(
					NewTableRtnCode.FAILED.getCode(),
					NewTableRtnCode.FAILED.getMessage(),
					null
					);
		}
		return new NewTableRes(
				NewTableRtnCode.SUCCESSFUL.getCode(),
				NewTableRtnCode.SUCCESSFUL.getMessage(),
				NewTableResListRes
				);
	}
	
	@PostMapping("api/activeNewTable")
	public NewTableRes activeNewTable(@RequestBody NewTableReq req) {
		List<NewTable> newTableRes = new ArrayList<>();
		try {
			if(req.getId() == null) {
				return new NewTableRes(
						NewTableRtnCode.DATA_REQUIRED.getCode(),
						NewTableRtnCode.DATA_REQUIRED.getMessage(),
						null
						);
			}
			
			newTableService.activeNewTable(req);
			newTableRes = newTableService.getNewTableList();
		} catch (Exception e) {
			return new NewTableRes(
					NewTableRtnCode.FAILED.getCode(),
					NewTableRtnCode.FAILED.getMessage(),
					null
					);
		}
		return new NewTableRes(
				NewTableRtnCode.SUCCESSFUL.getCode(),
				NewTableRtnCode.SUCCESSFUL.getMessage(),
				newTableRes
				);
	}
	
	@PostMapping("api/updateNewTable")
	public NewTableRes updateNewTable(@RequestBody NewTableReq req) {
		List<NewTable> newTableListRes = new ArrayList<>();
		try {
			if(req == null) {
				return new NewTableRes(
						NewTableRtnCode.DATA_REQUIRED.getCode(),
						NewTableRtnCode.DATA_REQUIRED.getMessage(),
						null
						);
			}
			
			newTableService.updateNewTable(req);
			newTableListRes = newTableService.getNewTableList();
		} catch (Exception e) {
			return new NewTableRes(
					NewTableRtnCode.FAILED.getCode(),
					NewTableRtnCode.FAILED.getMessage(),
					null
					);
		}
		return new NewTableRes(
				NewTableRtnCode.SUCCESSFUL.getCode(),
				NewTableRtnCode.SUCCESSFUL.getMessage(),
				newTableListRes
				);
	}
}
