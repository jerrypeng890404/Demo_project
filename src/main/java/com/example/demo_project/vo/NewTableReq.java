package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewTableReq {

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("group_id")
	private String groupId;

	@JsonProperty("group_name")
	private String groupName;

	@JsonProperty("label_id")
	private String labelId;

	@JsonProperty("label")
	private String label;

	@JsonProperty("status")
	private boolean status;

	@JsonProperty("creator")
	private String creator;

	@JsonProperty("modifier")
	private String modifier;

	public NewTableReq() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getLabelId() {
		return labelId;
	}

	public void setLabelId(String labelId) {
		this.labelId = labelId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

}
