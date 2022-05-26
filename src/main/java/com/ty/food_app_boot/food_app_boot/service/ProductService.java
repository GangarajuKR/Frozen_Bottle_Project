package com.ty.food_app_boot.food_app_boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.food_app_boot.food_app_boot.Exception.NoIdFoundException;
import com.ty.food_app_boot.food_app_boot.dao.ProductDao;
import com.ty.food_app_boot.food_app_boot.dao.ResponseStruture;
import com.ty.food_app_boot.food_app_boot.dto.Items;
import com.ty.food_app_boot.food_app_boot.dto.Product;

@Service
public class ProductService {
	
	@Autowired
	ProductDao dao;
	
	public ResponseStruture<Product> saveProduct(String email, String password, Product product) {
		Product pro = dao.saveProduct(email,password,product);
		if(pro==null) {
			throw new NoIdFoundException("product is not saved");
		}
		ResponseStruture<Product> struture = new  ResponseStruture<Product>();
		struture.setData(pro);
		struture.setMsg("Saved Product");
		struture.setStatus(HttpStatus.OK.value());
		return struture;
	}
	
	public ResponseStruture<Product> getProductById(int id) {
		Product product = dao.getProductById(id);
		if(product==null) {
			throw new NoIdFoundException("product is incorrect");
		}
		ResponseStruture<Product> struture = new  ResponseStruture<Product>();
		struture.setData(product);
		struture.setMsg("Got Product By id");
		struture.setStatus(HttpStatus.OK.value());
		return struture;
	}
	
	public ResponseStruture<Boolean> deleteProductById(int id) {
		boolean b = dao.deleteProductById(id);
		if(false==b) {
			throw new NoIdFoundException("product is id incorrect");
		}
		ResponseStruture<Boolean> struture = new  ResponseStruture<Boolean>();
		struture.setData(b);
		struture.setMsg("Saved Product");
		struture.setStatus(HttpStatus.OK.value());
		return struture;
	}
	
	public ResponseStruture<Product> updateProduct(String email,String password,int id,Product pro) {
		Product product = dao.updateProductById(email,password,id, pro);
		if(product==null) {
			throw new NoIdFoundException("product is id incorrect");
		}
		ResponseStruture<Product> struture = new  ResponseStruture<Product>();
		struture.setData(pro);
		struture.setMsg("updated Product");
		struture.setStatus(HttpStatus.OK.value());
		return struture;
	}
	
	public ResponseStruture<List<Product>> allProducts(){
		List<Product> list = dao.getallproducts();
		if(list.isEmpty()) {
			throw new NoIdFoundException("products are not found ");
		}
		ResponseStruture<List<Product>> struture = new  ResponseStruture<List<Product>>();
		struture.setData(list);
		struture.setMsg("all Products");
		struture.setStatus(HttpStatus.OK.value());
		return struture;
	}
	

}
