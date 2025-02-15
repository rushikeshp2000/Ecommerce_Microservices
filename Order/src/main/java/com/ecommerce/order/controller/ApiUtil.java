package com.ecommerce.order.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.NativeWebRequest;

import com.ecommerce.order.model.Order;
import com.ecommerce.order.model.OrderResponse;
import com.ecommerce.order.model.OrderResults;

import io.swagger.annotations.ApiParam;
import jakarta.servlet.http.HttpServletResponse;

public class ApiUtil {
	public static void setExampleResponse(NativeWebRequest req, String contentType, String example) {
		try {
		jakarta.servlet.http.HttpServletResponse res = req.getNativeResponse(HttpServletResponse.class);
		res.setCharacterEncoding("UTF-8");
		res.addHeader("Content-Type", contentType);
		res.getWriter().print(example);
		} catch (IOException e) {
		throw new RuntimeException(e);
		}
}
}

/*
 * 
 * public ResponseEntity<Order> createOrder(@ApiParam(value =
 * "",required=true) @PathVariable("UserId") String userId,@ApiParam(value =
 * "",required=true) @PathVariable("ProductName") String productName) {
 * 
 * OrderResults saveOrder = service.saveOrder(userId, productName); Order order
 * = new Order(); order.addResultsItem(saveOrder);
 * order.setStatusCode(HttpStatus.ACCEPTED.value());
 * order.setStatusMessage("Order Has Been Created");
 * 
 * return new ResponseEntity<Order>(order,HttpStatus.OK); }
 * 
 * public ResponseEntity<Order> createALLCartOrder(@ApiParam(value =
 * "",required=true) @PathVariable("UserId") String userId) {
 * 
 * List<OrderResults> saveALLOrder = service.saveALLOrder(userId); Order order =
 * new Order(); order.setResults(saveALLOrder);
 * order.setStatusCode(HttpStatus.ACCEPTED.value());
 * order.setStatusMessage("Order Has Been Created");
 * 
 * return new ResponseEntity<Order>(order,HttpStatus.OK);
 * 
 * }
 * 
 * public ResponseEntity<Order> getOrder() {
 * 
 * List<OrderResults> orderlist = service.getOrder(); Order order = new Order();
 * order.setResults(orderlist);
 * order.setStatusCode(HttpStatus.ACCEPTED.value());
 * order.setStatusMessage("Order Has Been Created");
 * 
 * return new ResponseEntity<Order>(order,HttpStatus.OK); }
 */