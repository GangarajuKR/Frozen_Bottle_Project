package com.ty.food_app_boot.food_app_boot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.food_app_boot.food_app_boot.dao.ResponseStruture;
import com.ty.food_app_boot.food_app_boot.dto.Items;
import com.ty.food_app_boot.food_app_boot.service.ItemService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ItemController {
	
	@Autowired
	ItemService service;
	
	@ApiOperation(value = "saved the details of Item",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Item is saved"),
		@ApiResponse(code = 405,message = "Bad request, not proper FoodOrder data or Item data")
	})
	@PostMapping("/foodorder/{f_id}/items")
	public ResponseStruture<Items> saveItems(@PathVariable int f_id,@RequestBody @Valid Items items) {
		return service.saveItems(f_id, items);
	}
	
	@GetMapping("/getitem")
	public Items get() {
		return new Items();
	}
	
	@ApiOperation(value = "Updated the details of Item",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Item is Updated"),
		@ApiResponse(code = 405,message = "Bad request, not proper FoodOrder data or Item data")
	})
	@PutMapping("/items")
	public ResponseStruture<Items> updateItems(@RequestParam int id,@RequestBody @Valid Items items) {
		return service.updateItems(id, items);
	}
	
	@ApiOperation(value = "deleted the details of Item",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Item is deleted"),
		@ApiResponse(code = 405,message = "Bad request, not proper Item data")
	})
	@DeleteMapping("/items")
	public ResponseStruture<Boolean> deleteItems(@RequestParam int id) {
		return service.deleteItemById(id);
	}
	
	@ApiOperation(value = "all the details of All Items By foodOrderId",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "got all Items"),
		@ApiResponse(code = 405,message = "Bad request, not proper FoodOrder data")
	})
	@GetMapping("foodorder/items")
	public ResponseStruture<List<Items>> allItemsByfoodOrderId(@RequestParam int f_id){
		return service.getItemsByUserId(f_id);
	}
	
	@ApiOperation(value = "got the details of Item",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Got the Details of Item"),
		@ApiResponse(code = 405,message = "Bad request, not proper Item data")
	})
	@GetMapping("/items")
	public ResponseStruture<Items> getItemByItemId(@RequestParam int id) {
		return service.getItemById(id);
	}
}
