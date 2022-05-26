package com.ty.food_app_boot.food_app_boot.Exception;

public class NoIdFoundException extends RuntimeException{
	
	private String msg = "No Id Found";
	
	public NoIdFoundException() {
	}
	
	public NoIdFoundException(String msg) {
		this.msg=msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}

}
