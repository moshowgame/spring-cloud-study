package com.softdev.system.demo.entity;

import java.io.Serializable;


/**
 * The persistent class for the UserRole database table.
 * 
 */
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String userId;

	private String roleId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}


}