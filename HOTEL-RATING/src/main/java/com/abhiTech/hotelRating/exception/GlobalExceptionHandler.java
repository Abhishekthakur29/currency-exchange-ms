package com.abhiTech.hotelRating.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<GlobalErrorResponse> handleDataNotFoundException(DataNotFoundException ex) {
		System.out.println("Exception code :: "+ ex);
		GlobalErrorResponse errorResponse = new GlobalErrorResponse(ex.getStatusCode(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
