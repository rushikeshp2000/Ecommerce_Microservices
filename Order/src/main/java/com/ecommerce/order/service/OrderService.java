package com.ecommerce.order.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ecommerce.order.model.Order;
import com.ecommerce.order.model.OrderResults;

public interface OrderService {
	
	OrderResults saveOrder( String userId,String productName);
	
	List<OrderResults> saveALLOrder(String userId);

	List<OrderResults>  getOrder();
	       
}
