package com.template.mongodb.service;

import java.util.List;

import com.template.mongodb.model.Product;

public interface ProductService {

	
	Product saveProduct(Product prodOne);
	List<Product> getProduct(); 
}
