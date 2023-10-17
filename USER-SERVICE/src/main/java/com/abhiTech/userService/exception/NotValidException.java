package com.abhiTech.userService.exception;

import java.util.List;

public class NotValidException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
    private String errors;

    public NotValidException(String message, String errors) {
        this.message = message;
        this.errors = errors;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}

}
