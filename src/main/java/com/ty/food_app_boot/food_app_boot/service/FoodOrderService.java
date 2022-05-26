package com.ty.food_app_boot.food_app_boot.service;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.food_app_boot.food_app_boot.Exception.NoIdFoundException;
import com.ty.food_app_boot.food_app_boot.dao.FoodOrderDao;
import com.ty.food_app_boot.food_app_boot.dao.ResponseStruture;
import com.ty.food_app_boot.food_app_boot.dto.FoodOrder;
import com.ty.food_app_boot.food_app_boot.dto.Items;

@Service 
public class FoodOrderService {
	
	@Autowired
	FoodOrderDao dao;
	
	public ResponseStruture<FoodOrder> saveFoodOrder(String email,String password,FoodOrder foodOrder) {
		double total = 0;
		FoodOrder food = dao.saveFoodOrder(email,password, foodOrder);
		List<Items> items = foodOrder.getItems();
		for(Items i : items) {
			total += i.getCost();
		}
		total = 1.8 *total;
		foodOrder.setTotal(total);
		if(food==null) {
			throw  new NoIdFoundException();
		}
		ResponseStruture<FoodOrder> responseStruture = new ResponseStruture<FoodOrder>();
		responseStruture.setStatus(HttpStatus.OK.value());
		responseStruture.setMsg("Food Order Saved");
		responseStruture.setData(food);
		return responseStruture;
	}
	
	public ResponseStruture<List<FoodOrder>> getallOrders(){
	    List<FoodOrder> foodOrders = dao.allFoodOrders();
	    if(foodOrders.isEmpty()) {
	    	throw new NoIdFoundException();
	    }
	    ResponseStruture<List<FoodOrder>> struture = new ResponseStruture<List<FoodOrder>>();
	    struture.setData(foodOrders);
	    struture.setMsg("All Orders Found");
	    struture.setStatus(HttpStatus.OK.value());
	    return struture;
	}
	
	public ResponseStruture<FoodOrder> updateFoodOrderById(int id,FoodOrder foodOrder) {
		double total = 0;
		FoodOrder f = dao.updateFoodOrder(id, foodOrder);
		List<Items> items = foodOrder.getItems();
		for(Items i : items) {
			total += i.getCost();
		}
		total = 1.8 *total;
		foodOrder.setTotal(total);
		
		if(f==null){
			throw new NoIdFoundException();
		}
		ResponseStruture<FoodOrder> struture = new ResponseStruture<FoodOrder>();
		struture.setData(f);
		struture.setMsg("FoodOrder is Updated");
		struture.setStatus(HttpStatus.OK.value());
		return struture;
	}
	
	public ResponseStruture<Boolean> deleteFoodOrderById(int id) {
		boolean b = dao.deleteFoodOrder(id);
		if(b==false) {
			throw new NoIdFoundException();
		}
		ResponseStruture<Boolean> struture = new ResponseStruture<Boolean>();
		struture.setData(b);
		struture.setMsg("deleted foodorder By Id");
		struture.setStatus(HttpStatus.OK.value());
		return struture;
	}
	
	public ResponseStruture<FoodOrder> getFoodOrderById(int id) {
		FoodOrder order = dao.getFoodOrderById(id);
		if(order==null) {
			throw new NoIdFoundException();
		}
		ResponseStruture<FoodOrder> str = new ResponseStruture<FoodOrder>();
		str.setData(order);
		str.setMsg("Got Order By Id");
		str.setStatus(HttpStatus.OK.value());
		return str;
	}

}
