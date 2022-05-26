package com.ty.food_app_boot.food_app_boot.service;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.food_app_boot.food_app_boot.FoodAppBootApplication;
import com.ty.food_app_boot.food_app_boot.Exception.EmailNotFoundException;
import com.ty.food_app_boot.food_app_boot.Exception.NoIdFoundException;
import com.ty.food_app_boot.food_app_boot.dao.ResponseStruture;
import com.ty.food_app_boot.food_app_boot.dao.UserDao;
import com.ty.food_app_boot.food_app_boot.dto.User;

@Service
public class UserService {
	
	@Autowired
	UserDao dao;
	
	@Autowired
	FoodAppBootApplication foodAppBootApplication;
	
	
	public ResponseStruture<User> saveUser(User user) {
		User u = dao.saveUser(user);
		ResponseStruture<User> struture = new  ResponseStruture<User>();
		if(u==null) {
			throw new NoIdFoundException("User is not saved");
		}
		FoodAppBootApplication.Email(user.getEmail(), "welcome Admin you account is Created And ur Id is : "+user.getId() );
		try {
			struture.setData(u);
			struture.setMsg("Saved User");
			struture.setStatus(HttpStatus.OK.value());
			foodAppBootApplication.triggerMail();
			return struture;
			
		} catch (MessagingException e) {
			throw new EmailNotFoundException("Admin check Your email and save");
		}
	}
	
	public ResponseStruture<User> updateUser(int id,User user) {
		User u =dao.update(id, user);
		if(u==null) {
			throw new NoIdFoundException("User Id is wrong");
		}
		ResponseStruture<User> struture = new  ResponseStruture<User>();
		struture.setData(u);
		struture.setMsg("Updated User");
		struture.setStatus(HttpStatus.OK.value());
		return struture;
	}
	
	public ResponseStruture<Boolean> deleteUser(int id) {
		boolean b = dao.deletebyId(id);
		if(b==false) {
			throw new NoIdFoundException("User Id id wrong");
		}
		ResponseStruture<Boolean> struture = new  ResponseStruture<Boolean>();
		struture.setData(b);
		struture.setMsg("deleted User");
		struture.setStatus(HttpStatus.OK.value());
		return struture;
	}
	
	public ResponseStruture<List<User>> allUsers(){
		List<User> list = dao.getalluser();
		if(list.isEmpty()) {
			throw new NoIdFoundException("users are empty");
		}
		ResponseStruture<List<User>> struture = new  ResponseStruture<List<User>>();
		struture.setData(list);
		struture.setMsg("got all Users");
		struture.setStatus(HttpStatus.OK.value());
		return struture;
	}
	
	public ResponseStruture<User> getUserById(int id) {
		User user = dao.getUserById(id);
		ResponseStruture<User> struture = new  ResponseStruture<User>();
		if(user == null) {
			throw new NoIdFoundException();
		}
		FoodAppBootApplication.Email(user.getEmail(), "Admin your details are opened by your Id is : "+user.getId() );
		try {
			struture.setData(user);
			struture.setMsg("got Users");
			struture.setStatus(HttpStatus.OK.value());
			foodAppBootApplication.triggerMail();
			return struture;
			
		} catch (MessagingException e) {
			throw new EmailNotFoundException("Admin Your email is not correct");
		}
		
	}

}
