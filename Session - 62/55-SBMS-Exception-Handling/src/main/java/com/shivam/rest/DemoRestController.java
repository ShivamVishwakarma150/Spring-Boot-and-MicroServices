package com.shivam.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

	private Logger logger = LoggerFactory.getLogger(DemoRestController.class);

	@GetMapping("/")
	public String doAction() {
		String msg = "Action in progress";
		try {
			int i = 10 / 0;
		} catch (Exception e) {
			logger.error("Exception Occured ::" + e, e);
			throw new ArithmeticException(e.getMessage());
		}
		return msg;
	}

	@ExceptionHandler(value=ArithmeticException.class)
	public ResponseEntity<ExceptionInfo> handleAE(ArithmeticException ae) {
		ExceptionInfo exception = new ExceptionInfo();

		exception.setMsg(ae.getMessage());
		exception.setCode("SBI0004");

		return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}