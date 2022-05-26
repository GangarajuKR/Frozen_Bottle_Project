package com.ty.food_app_boot.food_app_boot.controller;

//github.com/C-M-Vaibhav/Endless_event.gitpackage com.ty.food_app_boot.food_app_boot.controller;

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
import com.ty.food_app_boot.food_app_boot.dto.FoodOrder;
import com.ty.food_app_boot.food_app_boot.service.FoodOrderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class FoodController {

	@Autowired
	private FoodOrderService service;
	
	@ApiOperation(value = "save the details of FooOrder",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "FoodOrder saved"),
		@ApiResponse(code = 405,message = "Bad request, not proper User data or FoodOrder")
	})
	@PostMapping("person/{email}/{password}/order")
	public ResponseStruture<FoodOrder> saveFoodOrder(@PathVariable String email,@PathVariable String password,@RequestBody @Valid FoodOrder foodOrder) {
		return service.saveFoodOrder(email,password, foodOrder);
	}
	
	@GetMapping("/orderobj")
	public FoodOrder get() {
		return  new FoodOrder();
	}
	
	@ApiOperation(value = "Updated the details of FooOrder",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "FoodOrder updated"),
		@ApiResponse(code = 405,message = "Bad request, not proper User data or FoodOrder")
	})
	@PutMapping("/order")
	public ResponseStruture<FoodOrder> updateFoodOrder(@RequestParam int f_id,@RequestBody @Valid FoodOrder foodOrder) {
		return service.updateFoodOrderById(f_id, foodOrder);
	}
	
	@ApiOperation(value = "deleted the details of FooOrder",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "FoodOrder deleted"),
		@ApiResponse(code = 405,message = "Bad request, not proper FoodOrderId")
	})
	@DeleteMapping("/order")
	public ResponseStruture<Boolean> deleteFoodOrder(@RequestParam int id) {
			return service.deleteFoodOrderById(id);
	}
	
	@ApiOperation(value = "got the details of AllFooOrder",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "FoodOrder saved"),
		@ApiResponse(code = 405,message = "Bad request, not proper No FoodOrder Food")
	})
	@GetMapping("/orders")
	public ResponseStruture<List<FoodOrder>> getAllFoodOrders(){
		return service.getallOrders();
	}
	
	@ApiOperation(value = "Got the details of FooOrder",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "FoodOrder saved"),
		@ApiResponse(code = 405,message = "Bad request, not proper No FoodOrder id Found")
	})
	@GetMapping("/order")
	public ResponseStruture<FoodOrder> getFoodOrderById(@RequestParam int id) {
		return service.getFoodOrderById(id);
	}
	
}
