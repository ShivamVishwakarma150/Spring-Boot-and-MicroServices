package com.shivam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Global Exception Handler
@RestControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(value=ArithmeticException.class)
	public ResponseEntity<ExceptionInfo> handleAE(ArithmeticException ae) {
		ExceptionInfo exception = new ExceptionInfo();

		exception.setMsg(ae.getMessage());
		exception.setCode("SBI0004");

		return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value=NoDataFoundException.class)
	public ResponseEntity<ExceptionInfo> handleNdfe(NoDataFoundException ndfe){
		ExceptionInfo exception = new ExceptionInfo();

		exception.setMsg(ndfe.getMessage());
		exception.setCode("NDFE0001");	
		
		return new ResponseEntity<>(exception,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
