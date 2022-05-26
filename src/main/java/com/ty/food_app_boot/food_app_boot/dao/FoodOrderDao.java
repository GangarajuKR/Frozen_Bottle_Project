package com.ty.food_app_boot.food_app_boot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.food_app_boot.food_app_boot.dto.FoodOrder;
import com.ty.food_app_boot.food_app_boot.dto.Items;
import com.ty.food_app_boot.food_app_boot.dto.Person;
import com.ty.food_app_boot.food_app_boot.dto.User;
import com.ty.food_app_boot.food_app_boot.repostary.FoodOrderRespositary;

@Repository
public class FoodOrderDao {

	@Autowired
	PersonDao dao;

	@Autowired
	FoodOrderRespositary respositary;

	public FoodOrder saveFoodOrder(String email,String password, FoodOrder order) {
		Person person = dao.validateEmail(email, password);
		List<Items> items = order.getItems();
		
		if (person != null) {
			
			order.setPerson(person);
			for (Items i : items) {
				i.setOrder(order);
			}
			
			return respositary.save(order);
		}
		
		return null;
	}

	public FoodOrder getFoodOrderById(int f_id) {
		Optional<FoodOrder> optional = respositary.findById(f_id);
		return optional.get();
	}

	public FoodOrder updateFoodOrder(int f_id, FoodOrder foodOrder) {
		FoodOrder f = getFoodOrderById(f_id);
		if (f != null) {
			return respositary.save(f);
		}
		return f;
	}
	
	public List<FoodOrder> allFoodOrders(){
		return respositary.findAll();
	}
	
	public boolean deleteFoodOrder(int f_id) {
		FoodOrder f = getFoodOrderById(f_id);
		if (f != null) {
			respositary.delete(f);
			return true;
		}
		return false;
	}

}
