package com.abhiTech.userService.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<UserNotFoundGlobalException> handleUserNotFoundExp(UserNotFoundException ex){
		UserNotFoundGlobalException globalException = new UserNotFoundGlobalException(ex.getMessage(), ex.getCode());
		return new ResponseEntity<>(globalException, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<UserNotFoundGlobalException> handleValidationException(MethodArgumentNotValidException ex) {

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getDefaultMessage())
                .collect(Collectors.toList());

        String errorMessage = String.join(", ", errors);
        UserNotFoundGlobalException response = new UserNotFoundGlobalException(errorMessage, "400");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }
}
