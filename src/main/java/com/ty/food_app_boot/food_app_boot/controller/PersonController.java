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
import com.ty.food_app_boot.food_app_boot.dto.Person;
import com.ty.food_app_boot.food_app_boot.service.PersonService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PersonController {
	
	@Autowired
	PersonService service;
	
	@ApiOperation(value = "saved the details of Person",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Person is saved"),
		@ApiResponse(code = 405,message = "Bad request, not proper Person data")
	})
	@PostMapping("/person")
	public ResponseStruture<Person> savePerson(@RequestBody @Valid Person person){
		return service.savePerson(person);
	}
	
	@PostMapping("/heelo")
	public Person get() {
		return new Person();
	}
	@ApiOperation(value = "Got the details of Person",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Got Person Details"),
		@ApiResponse(code = 405,message = "Bad request, not proper Person data")
	})
	@GetMapping("/person")
	public ResponseStruture<Person> getPersonById(@RequestParam int id){
		return service.getPersonById(id);
	}

	@ApiOperation(value = "Updated the details of Person",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Updated the Person Details"),
		@ApiResponse(code = 405,message = "Bad request, not proper Person data")
	})
	@PutMapping("/person")
	public ResponseStruture<Person> updatePerson(@RequestParam String email,@RequestParam String password,@RequestBody @Valid Person person){
		return service.updatePerson(email,password, person);
	}
	
	@ApiOperation(value = "Got the details of AllPersons",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Got Person Details"),
		@ApiResponse(code = 405,message = "Bad request, not proper Person data")
	})
	@GetMapping("/allperson")
	public ResponseStruture<List<Person>> getAllPersons(){
		return service.allPersons();
	}
	
	@ApiOperation(value = "Deleted the details of Person",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Deleted Person Details"),
		@ApiResponse(code = 405,message = "Bad request, not proper Person data")
	})
	@DeleteMapping("/person")
	public ResponseStruture<Boolean> deletePerson(@RequestParam int id){
		return service.deletePerson(id);
	}
}
