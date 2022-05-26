package com.ty.food_app_boot.food_app_boot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.food_app_boot.food_app_boot.dto.FoodOrder;
import com.ty.food_app_boot.food_app_boot.dto.Items;
import com.ty.food_app_boot.food_app_boot.repostary.ItemRepositary;

@Repository
public class  ItemDao{
	
	@Autowired
	ItemRepositary  repositary;
	
	@Autowired
	FoodOrderDao dao;

	public Items saveItems(int f_id,Items item) {
		FoodOrder foodOrder = dao.getFoodOrderById(f_id);
		if(foodOrder !=null) {
			return repositary.save(item);
		}
		return null;
	}
	
	public List<Items> getitemsByUserId(int id) {
		return repositary.getItemsByUserId(id);
	}
	
	public Items getItemById(int id) {
		return repositary.getById(id);
	}
	public Items updateItems(int id,Items items) {
		Items i = getItemById(id);
		if(i!=null) {
			return repositary.save(items);
		}
		return null;
	} 
	
	public boolean deleteItemsById(int id) {
		Items i = getItemById(id);
		if(i!=null) {
			repositary.delete(i);
			return true;
		}
		return false;
	}
	
	
}
