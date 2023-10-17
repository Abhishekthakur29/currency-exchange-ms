package com.abhiTech.hotelRating.exception;

public class GlobalErrorResponse {
	private String statusCode;
	private String message;

	public GlobalErrorResponse(String statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public String getMessage() {
		return message;
	}
}
