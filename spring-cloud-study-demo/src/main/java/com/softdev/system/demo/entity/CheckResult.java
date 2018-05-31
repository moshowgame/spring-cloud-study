package com.softdev.system.demo.entity;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * The persistent class for the CheckResult database table.
 * 
 */
public class CheckResult implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String checkid;
	private String facilityid;
	private String checkresult;
	private Timestamp examtime;
	private Timestamp createtime;
	private Timestamp lastuptime;
	private String remark;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCheckid() {
		return checkid;
	}
	public void setCheckid(String checkid) {
		this.checkid = checkid;
	}
	public String getFacilityid() {
		return facilityid;
	}
	public void setFacilityid(String facilityid) {
		this.facilityid = facilityid;
	}
	public String getCheckresult() {
		return checkresult;
	}
	public void setCheckresult(String checkresult) {
		this.checkresult = checkresult;
	}
	public Timestamp getExamtime() {
		return examtime;
	}
	public void setExamtime(Timestamp examtime) {
		this.examtime = examtime;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public Timestamp getLastuptime() {
		return lastuptime;
	}
	public void setLastuptime(Timestamp lastuptime) {
		this.lastuptime = lastuptime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}