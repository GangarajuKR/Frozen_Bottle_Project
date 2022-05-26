package com.ty.food_app_boot.food_app_boot.dao;

public class ResponseStruture <T> {
	
	private int status;
	private String msg;
	private T data;
	public String getMsg() {
		return msg;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	


}
