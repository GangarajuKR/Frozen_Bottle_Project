package com.ty.food_app_boot.food_app_boot.service;

import java.util.List;

import org.aspectj.lang.NoAspectBoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.food_app_boot.food_app_boot.Exception.NoIdFoundException;
import com.ty.food_app_boot.food_app_boot.dao.PersonDao;
import com.ty.food_app_boot.food_app_boot.dao.ResponseStruture;
import com.ty.food_app_boot.food_app_boot.dto.Person;

@Service
public class PersonService {
	
	@Autowired
	private PersonDao dao;
	
	public ResponseStruture<Person> savePerson(Person person){
		Person p = dao.savePerson(person);
		if(p==null) {
			throw new NoAspectBoundException();
		}
		ResponseStruture<Person> struture = new ResponseStruture<Person>();
		struture .setData(p);
		struture.setMsg("Saved Person");
		struture.setStatus(HttpStatus.OK.value());
		return struture;
	}
	
	public ResponseStruture<Person> updatePerson(String email,String password, Person person){
		Person p = dao.updatePersonById(email,password, person);
		if(p==null) {
			throw new NoIdFoundException();
		}
		ResponseStruture<Person> struture = new ResponseStruture<Person>();
		struture .setData(p);
		struture.setMsg("Updated Person");
		struture.setStatus(HttpStatus.OK.value());
		return struture;
	}
	
	public ResponseStruture<Boolean> deletePerson(int id){
		boolean b = dao.deletePersonById(id);
		if(b==false) {
			throw new NoIdFoundException();
		}
		ResponseStruture<Boolean> struture = new ResponseStruture<Boolean>();
		struture .setData(b);
		struture.setMsg("Person Deleted");
		struture.setStatus(HttpStatus.OK.value());
		return struture;
	}
	
	public ResponseStruture<List<Person>> allPersons(){
		List<Person> persons = dao.allPersons();
		if(persons.isEmpty()) {
			throw new NoIdFoundException();
		}
		ResponseStruture<List<Person>> struture = new ResponseStruture<List<Person>>();
		struture .setData(persons);
		struture.setMsg("Saved Person");
		struture.setStatus(HttpStatus.OK.value());
		return struture;
	}
	
	public ResponseStruture<Person> getPersonById(int id){
		Person person = dao.getPersonById(id);
		if(person==null) {
			throw new NoIdFoundException();
		}
		ResponseStruture<Person> struture = new ResponseStruture<Person>();
		struture .setData(person);
		struture.setMsg("Got Person");
		struture.setStatus(HttpStatus.OK.value());
		return struture;
	}
}
