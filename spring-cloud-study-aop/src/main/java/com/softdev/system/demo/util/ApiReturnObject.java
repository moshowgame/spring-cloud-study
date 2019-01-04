package com.softdev.system.demo.util;

import java.io.Serializable;

public class ApiReturnObject implements Serializable{

	private static final long serialVersionUID = 1L;

	String errorCode="00";
	Object errorMessage;
	Object returnObject;
	
	
	public ApiReturnObject(String errorCode, Object errorMessage, Object returnObject) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.returnObject = returnObject;
	}
	public ApiReturnObject(Object errorMessage, Object returnObject) {
		super();
		this.errorMessage = errorMessage;
		this.returnObject = returnObject;
	}
	public ApiReturnObject(Object returnObject) {
		super();
		this.returnObject = returnObject;
	}
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public Object getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(Object errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Object getReturnObject() {
		return returnObject;
	}

	public void setReturnObject(Object returnObject) {
		this.returnObject = returnObject;
	}

}
