package com.ecommerce.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import com.ecommerce.order.model.Order;
import com.ecommerce.order.model.OrderResults;
import com.ecommerce.order.service.OrderService;

import io.swagger.annotations.ApiParam;

import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-15T02:17:57.182843300+05:30[Asia/Calcutta]")

@Controller
@RequestMapping("${openapi.userMicroService.base-path:}")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class OrderApiController implements OrderApi {

	@Autowired
	OrderService service;
	
    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public OrderApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }
    
    public ResponseEntity<Order> createOrder(@ApiParam(value = "",required=true) @PathVariable("UserId") String userId,@ApiParam(value = "",required=true) @PathVariable("ProductName") String productName) {
    	
    	OrderResults saveOrder = service.saveOrder(userId, productName);
    	Order order = new Order();
    	order.addResultsItem(saveOrder);
    	order.setStatusCode(HttpStatus.ACCEPTED.value());
    	order.setStatusMessage("Order Has Been Created");
    	
    	return new ResponseEntity<Order>(order,HttpStatus.OK);
    }
    
    public ResponseEntity<Order> createALLCartOrder(@ApiParam(value = "",required=true) @PathVariable("UserId") String userId) {
    	
    	List<OrderResults> saveALLOrder = service.saveALLOrder(userId);
    	Order order = new Order();
    	order.setResults(saveALLOrder);
    	order.setStatusCode(HttpStatus.ACCEPTED.value());
    	order.setStatusMessage("Order Has Been Created");
    	
    	return new ResponseEntity<Order>(order,HttpStatus.OK);
    	
    }
    
    public  ResponseEntity<Order> getOrder() {
    
    	List<OrderResults> orderlist = service.getOrder();
    	Order order = new Order();
    	order.setResults(orderlist);
    	order.setStatusCode(HttpStatus.ACCEPTED.value());
    	order.setStatusMessage("Order Has Been Created");
    	
    	return new ResponseEntity<Order>(order,HttpStatus.OK);
    }

}
