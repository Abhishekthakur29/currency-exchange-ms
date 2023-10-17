package com.abhiTech.userService.exception;

public class UserNotFoundGlobalException{
	private String message;
	private String code;

	public UserNotFoundGlobalException(String message, String code) {
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
