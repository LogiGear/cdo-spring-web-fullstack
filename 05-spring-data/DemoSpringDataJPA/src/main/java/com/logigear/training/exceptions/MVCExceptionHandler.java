package com.logigear.training.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class MVCExceptionHandler {
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> noSuchElementFoundException(EmployeeNotFoundException ex, WebRequest request){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee does not exits");
	}
	@ExceptionHandler(EmployeeAlreadyExistsException.class)
	public ResponseEntity<Object> employeeAlreadyExitsException(EmployeeAlreadyExistsException ex, WebRequest request){
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Employee already exits");
	}
}
