package com.ty.food_app_boot.food_app_boot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.food_app_boot.food_app_boot.dao.ResponseStruture;
import com.ty.food_app_boot.food_app_boot.dto.User;
import com.ty.food_app_boot.food_app_boot.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
public class UserController {

	@Autowired
	UserService service;

	@ApiOperation(value = "saved the details of User",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "saved User Details"),
		@ApiResponse(code = 405,message = "Bad request, not proper User data")
	})
	@PostMapping("/user")
	public ResponseStruture<User> saveUser(@RequestBody @Valid User user) {
		return service.saveUser(user);
	}

	@PostMapping("/userobj")
	public User getUser() {
		return new User();
	}

	@ApiOperation(value = "Got the details of AllUser",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Got AllUser Details"),
		@ApiResponse(code = 405,message = "Bad request, not proper User data")
	})
	@PostMapping("/alluser")
	public ResponseStruture<List<User>> getall(){
		return service.allUsers();
	}

	@ApiOperation(value = "Got the details of User",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Got User Details"),
		@ApiResponse(code = 405,message = "Bad request, not proper User data")
	})
	@GetMapping("/user")
	public ResponseStruture<User> geUserById(@RequestParam int id) {
		return service.getUserById(id);
	}

	@ApiOperation(value = "Deleted the details of User",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Deleted User Details"),
		@ApiResponse(code = 405,message = "Bad request, not proper User data")
	})
	@DeleteMapping("/user")
	public ResponseStruture<Boolean> deleteUser(@RequestParam int id) {
		return service.deleteUser(id);
	}
	
	@ApiOperation(value = "Update the details of User",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Updated User Details"),
		@ApiResponse(code = 405,message = "Bad request, not proper User data")
	})
	@PutMapping("/user")
	public ResponseStruture<User> updateProduct(@RequestParam int id,@RequestBody @Valid User user) {
		return service.updateUser(id, user);
	}

}
