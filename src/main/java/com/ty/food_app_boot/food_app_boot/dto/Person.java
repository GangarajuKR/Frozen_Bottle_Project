package com.ty.food_app_boot.food_app_boot.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Email(message = "Email is not be vaild")
	private String email;
	private String password;
	@NotNull(message = "name should not be null")
	private String name;
	
	@OneToMany(mappedBy = "person")
	private List<FoodOrder> orders;
	
	
	public List<FoodOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<FoodOrder> orders) {
		this.orders = orders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
