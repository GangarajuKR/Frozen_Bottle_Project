package com.ty.food_app_boot.food_app_boot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.food_app_boot.food_app_boot.dao.ResponseStruture;
import com.ty.food_app_boot.food_app_boot.dto.Product;
import com.ty.food_app_boot.food_app_boot.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@ApiOperation(value = "saved the details of Product",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "saved Product Details"),
		@ApiResponse(code = 405,message = "Bad request, not proper Product data")
	})
	@PostMapping("/product")
	public ResponseStruture<Product> saveProduct(@RequestParam String email,@RequestParam String password,@RequestBody @Valid Product product){
		return service.saveProduct(email,password,product);
	}
	
	@PostMapping("/getproduct")
	public Product get() {
		return new Product();
	}
	
	@ApiOperation(value = "Got the details of Person",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Got Person Details"),
		@ApiResponse(code = 405,message = "Bad request, not proper Person data")
	})
	@GetMapping("/product")
	public ResponseStruture<Product> getProductById(@RequestParam int id) {
		return service.getProductById(id);
	}
	
	@ApiOperation(value = "Got the details of AllPersons",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Got Person Details"),
		@ApiResponse(code = 405,message = "Bad request, not proper Person data")
	})
	@GetMapping("/allproduct")
	public ResponseStruture<List<Product>> getAll(){
		return service.allProducts();
	}
	
	@ApiOperation(value = "Updated the details of Person",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Updated Person Details"),
		@ApiResponse(code = 405,message = "Bad request, not proper Person data")
	})
	@PutMapping("/product")
	public ResponseStruture<Product> updateProduct(@RequestParam String email,@RequestParam String password,@RequestParam int id,@RequestBody @Valid Product product) {
		return service.updateProduct(email,password,id, product);
	}
	
	@ApiOperation(value = "Deleted the details of Person",produces = "application/json",consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Deleted Person Details"),
		@ApiResponse(code = 405,message = "Bad request, not proper Person data")
	})
	@DeleteMapping("/product")
	public ResponseStruture<Boolean> delete(@RequestParam int id) {
		return service.deleteProductById(id);
	}

}
