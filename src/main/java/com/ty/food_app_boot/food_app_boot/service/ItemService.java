package com.ty.food_app_boot.food_app_boot.service;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.food_app_boot.food_app_boot.Exception.NoIdFoundException;
import com.ty.food_app_boot.food_app_boot.dao.ItemDao;
import com.ty.food_app_boot.food_app_boot.dao.ResponseStruture;
import com.ty.food_app_boot.food_app_boot.dto.Items;

@Service
public class ItemService {
	
	@Autowired
	ItemDao dao;
	
	public ResponseStruture<Items> saveItems(int f_id,Items items) {
		Items i = dao.saveItems(f_id, items);
		if(i==null) {
			throw new NoIdFoundException();
		}
		ResponseStruture<Items> struture = new  ResponseStruture<Items>();
		struture.setData(i);
		struture.setMsg("Saved Item");
		struture.setStatus(HttpStatus.OK.value());
		return struture;
	}
	
	public ResponseStruture<Items> updateItems(int id, Items items) {
		Items i = dao.updateItems(id, items);
		if(i==null) {
			throw new NoIdFoundException();
		}
		ResponseStruture<Items> struture = new  ResponseStruture<Items>();
		struture.setData(i);
		struture.setMsg("Saved Item");
		struture.setStatus(HttpStatus.OK.value());
		return struture;
	}
	
	public ResponseStruture<Boolean> deleteItemById(int id) {
		boolean b = dao.deleteItemsById(id);
		if(b==false) {
			throw new NoIdFoundException();
		}
		ResponseStruture<Boolean> struture = new  ResponseStruture<Boolean>();
		struture.setData(b);
		struture.setMsg("Saved Item");
		struture.setStatus(HttpStatus.OK.value());
		return struture;
	}
	
	public ResponseStruture<Items> getItemById(int id) {
		Items items = dao.getItemById(id);
		if(items == null) {
			throw new NoIdFoundException();
		}
		ResponseStruture<Items> struture = new  ResponseStruture<Items>();
		struture.setData(items);
		struture.setMsg("Saved Item");
		struture.setStatus(HttpStatus.OK.value());
		return struture;
	}
	
	public ResponseStruture<List<Items>> getItemsByUserId(int f_id){
		List<Items> items = dao.getitemsByUserId(f_id);
		if(items.isEmpty()) {
			throw new NoIdFoundException("No items are there for this user");
		}
		ResponseStruture<List<Items>> struture = new  ResponseStruture<List<Items>>();
		struture.setData(items);
		struture.setMsg("allItems by food order it");
		struture.setStatus(HttpStatus.OK.value());
		return struture;
	}
	

}
