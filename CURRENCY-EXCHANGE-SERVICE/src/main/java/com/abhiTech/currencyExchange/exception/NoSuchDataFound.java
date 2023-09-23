package com.abhiTech.currencyExchange.exception;

public class NoSuchDataFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3800391285146536673L;

	private String message;
	private String code;

	public NoSuchDataFound(String message, String code) {
		super();
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public NoSuchDataFound() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoSuchDataFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NoSuchDataFound(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NoSuchDataFound(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NoSuchDataFound(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
