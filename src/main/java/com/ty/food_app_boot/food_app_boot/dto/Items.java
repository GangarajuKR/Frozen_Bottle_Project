package com.ty.food_app_boot.food_app_boot.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "item name should not be null")
	private String name;
	@NotNull(message = "item cost should not be null")
	private double cost;
	@NotNull(message = "item qty should not be null")
	private int qty;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private FoodOrder order;
	
	@JsonIgnore
	public FoodOrder getOrder() {
		return order;
	}

	public void setOrder(FoodOrder order) {
		this.order = order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
