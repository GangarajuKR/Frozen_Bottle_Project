package com.ty.food_app_boot.food_app_boot.dao;

import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.food_app_boot.food_app_boot.FoodAppBootApplication;
import com.ty.food_app_boot.food_app_boot.Exception.EmailNotFoundException;
import com.ty.food_app_boot.food_app_boot.dto.Person;
import com.ty.food_app_boot.food_app_boot.repostary.PersonRepositary;

@Repository
public class PersonDao {

	@Autowired
	PersonRepositary repositary;
	
	@Autowired
	FoodAppBootApplication foodAppBootApplication;
	
	public Person savePerson(Person person) {
		Person p = validateEmail(person.getEmail(), person.getPassword());
		if(p==null) {
		try {
			FoodAppBootApplication.Email(person.getEmail(), "Hi costumer thank you for visting us Mr/Miss."+person.getName()+"your Orders"+person.getOrders());
			foodAppBootApplication.triggerMail();
			return repositary.save(person);
		} catch (MessagingException e) {
			throw new EmailNotFoundException("Email not found");
		}
		}
		return null;
	}

	public Person getPersonById(int id) {
		Optional<Person> optional = repositary.findById(id);
		if (optional != null) {
			return optional.get();
		}
		return null;
	}

	public Person updatePersonById(String email,String password, Person person) {
		Person p = validateEmail(email, password);
		if(p==null) {
			return null;
		}
		try {
			FoodAppBootApplication.Email(person.getEmail(), "Hi costumer thank you for visting us Mr/Miss."+person.getName()+"your Orders"+person.getOrders());
			foodAppBootApplication.triggerMail();
			return repositary.save(person);
		} catch (MessagingException e) {
			throw new EmailNotFoundException("Email not found");
		}
		
	}

	public boolean deletePersonById(int id) {
		Person person = getPersonById(id);
		if (person != null) {
			repositary.delete(person);
			return true;
		}
		return false;
	}

	public List<Person> allPersons() {
		return repositary.findAll();
	}
	
	public Person validateEmail(String email,String password) {
		Person person = repositary.validateEmail(email);
		if(person!=null) {
			if(person.getPassword().equals(password)) {
				return person;
			}
			throw new EmailNotFoundException("email found but password does not match");
		}
		return null;
	} 
}
