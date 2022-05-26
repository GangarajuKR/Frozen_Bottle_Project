package com.ty.food_app_boot.food_app_boot.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionIdHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NoIdFoundException.class)
	public ResponseEntity<String> handleNoIdFoundException(NoIdFoundException idFoundException){
		String message = idFoundException.getMessage();
		ResponseEntity<String> entity = new ResponseEntity<String>(message,HttpStatus.NOT_FOUND);
		return entity;
	}
}
