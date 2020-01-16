package com.rpcl.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = SsnNotFoundException.class)
	public ResponseEntity<ResponseExceptionDetails> handleSSNNotFoundException(){
		ResponseExceptionDetails responseExDetails=new ResponseExceptionDetails();
		responseExDetails.setErrorCode("SSA003");
		responseExDetails.setErrorDesc("Invalid SSN");
		return new ResponseEntity<ResponseExceptionDetails>(responseExDetails,HttpStatus.BAD_REQUEST);
	}
} 
