package com.ecommerce.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.order.Dto.CartResponse;
import com.ecommerce.order.Dto.Product;
import com.ecommerce.order.Dto.ProductResponse;
import com.ecommerce.order.Dto.Response;
import com.ecommerce.order.entity.OrderEntity;
import com.ecommerce.order.feign.FeignProduct;
import com.ecommerce.order.feign.FeignService;
import com.ecommerce.order.feign.FeignUser;
import com.ecommerce.order.feign.User;
import com.ecommerce.order.model.Order;
import com.ecommerce.order.model.OrderResults;
import com.ecommerce.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	FeignService getdata;
	
	@Autowired
	FeignUser getuser;
	
	@Autowired
	FeignProduct productdata;
	
	@Autowired
	OrderRepository repository;
	
	@Override
	public OrderResults saveOrder(String userId, String productName) {
		
		System.out.println("service");
		ResponseEntity<CartResponse> singleCart = getdata.deleteProduct(productName, userId);
		CartResponse body = singleCart.getBody();
		ResponseEntity<User> user = getuser.getUser(userId);
		User body2 = user.getBody();
		System.out.println(body2);
		List<Response> result = body.getResult();
		Response response = result.get(0);
	
		OrderEntity orderSave = new OrderEntity();
		orderSave.setPrice(response.getPrice());
		orderSave.setProductName(response.getName());
		orderSave.setQuantity(response.getQuantity());
		orderSave.setSellerId(response.getSellerNumber());
		orderSave.setTotalprice(response.getPrice() * response.getQuantity());
		System.out.println(response.getTotalPrice());
		orderSave.setUserAddress(body2.getAddress());
		orderSave.setUserEmail(body2.getEmail());
		orderSave.setUserId(userId);
		orderSave.setUserName(body2.getName());
		orderSave.setUserPhone(body2.getPhone().toPlainString());
		orderSave.setCreatedBy(userId);
		
		
		ResponseEntity<ProductResponse> updateQuantityProduct = productdata.updateQuantityProduct(orderSave.getProductName(), orderSave.getQuantity().toString());
		
		ProductResponse prodResponse = updateQuantityProduct.getBody();
		
		List<Product> ProdFinal = prodResponse.getResult();
	
		Product prodSingle = ProdFinal.get(0);
		
		OrderEntity save = repository.save(orderSave);
		
		
		OrderResults results = new OrderResults();
		results.setCreatedBy(save.getUserId());
		results.setCreatedDate(save.getCreatedDate().toString());
		results.setOrderId(save.getOrderId());
		results.setPrice(save.getPrice());
		results.setProductName(save.getProductName());
		results.setQuantity(save.getQuantity());
		results.setSellerId(save.getSellerId());
		results.setTotalprice(save.getTotalprice());
		results.setUpdateDate(save.getLastmodifiedDate().toString());
		results.setUserAddress(save.getUserAddress());
		results.setUserEmail(save.getUserEmail());
		results.setUserId(save.getUserId());
		results.setUserName(save.getUserName());
		results.setUserPhone(save.getUserPhone());
		
		
		System.out.println("service3");
		return results;
	}

	@Override
	public List<OrderResults> getOrder() {
		
		List<OrderEntity> findAll = repository.findAll();
		List<OrderResults> resultlist = new ArrayList<>();
	    for(OrderEntity save : findAll )
	    {
	    	OrderResults results = new OrderResults();
			results.setCreatedBy(save.getCreatedBy());
			results.setCreatedDate(save.getCreatedDate().toString());
			results.setOrderId(save.getOrderId());
			results.setPrice(save.getPrice());
			results.setProductName(save.getProductName());
			results.setQuantity(save.getQuantity());
			results.setSellerId(save.getSellerId());
			results.setTotalprice(save.getPrice() * save.getQuantity());
			results.setUpdateDate(save.getLastmodifiedDate().toString());
			results.setUserAddress(save.getUserAddress());
			results.setUserEmail(save.getUserEmail());
			results.setUserId(save.getUserId());
			results.setUserName(save.getUserName());
			results.setUserPhone(save.getUserPhone());			
			resultlist.add(results);
	    }
		return resultlist;
	}

	@Override
	public List<OrderResults> saveALLOrder(String userId) {
		
		ResponseEntity<CartResponse> deleteAllProduct = getdata.deleteAllProduct(userId);
		
		CartResponse cartResponse = deleteAllProduct.getBody();
		
		List<Response> Listresponse = cartResponse.getResult();
		
		List<OrderResults> orderResult = new ArrayList<>();
		
		ResponseEntity<User> user = getuser.getUser(userId);
		User body2 = user.getBody();
		
		for(Response response : Listresponse )
		{

			OrderEntity orderSave = new OrderEntity();
			orderSave.setPrice(response.getPrice());
			orderSave.setProductName(response.getName());
			orderSave.setQuantity(response.getQuantity());
			orderSave.setSellerId(response.getSellerNumber());
			orderSave.setTotalprice(response.getTotalPrice());
			orderSave.setUserAddress(body2.getAddress());
			orderSave.setUserEmail(body2.getEmail());
			orderSave.setUserId(userId);
			orderSave.setUserName(body2.getName());
			orderSave.setUserPhone(body2.getPhone().toPlainString());
			
			
			ResponseEntity<ProductResponse> updateQuantityProduct = productdata.updateQuantityProduct(orderSave.getProductName(), orderSave.getQuantity().toString());
			
			ProductResponse prodResponse = updateQuantityProduct.getBody();
			
			List<Product> ProdFinal = prodResponse.getResult();
		
			Product prodSingle = ProdFinal.get(0);
			
			OrderEntity save = repository.save(orderSave);
			
			
			OrderResults results = new OrderResults();
			results.setCreatedBy(save.getUserId());
			results.setCreatedDate(save.getCreatedDate().toString());
			results.setOrderId(save.getOrderId());
			results.setPrice(save.getPrice());
			results.setProductName(save.getProductName());
			results.setQuantity(save.getQuantity());
			results.setSellerId(save.getSellerId());
			results.setTotalprice(save.getTotalprice());
			results.setUpdateDate(save.getLastmodifiedDate().toString());
			results.setUserAddress(save.getUserAddress());
			results.setUserEmail(save.getUserEmail());
			results.setUserId(save.getUserId());
			results.setUserName(save.getUserName());
			results.setUserPhone(save.getUserPhone());
			
			orderResult.add(results);
		}
		
		return orderResult;
	}

}
