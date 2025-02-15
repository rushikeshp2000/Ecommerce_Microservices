package com.ecommerce.cart.service;

import java.util.List;

import com.ecommerce.cart.entity.CartEntity;
import com.ecommerce.cart.model.Response;

public interface CartService {
	
	Response deleteCart(String userId,String productName);
	
	List<Response> viewAll(String userId);
	
	Response saveToCart(String userId,String productName, Integer quantity);
	
	Response singleCart(String userId,String productName); 
	
	List<Response> deleteAllCart(String userId);
}
