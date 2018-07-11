package com.softdev.system.demo.entity;

import java.io.Serializable;

public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String roleId;

	private String roleName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


}