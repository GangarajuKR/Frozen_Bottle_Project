package com.ty.food_app_boot.food_app_boot.Exception;

public class EmailNotFoundException extends RuntimeException {
private String msg = "No Id Found";
	
	public EmailNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	public EmailNotFoundException(String msg) {
		this.msg=msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}


}
