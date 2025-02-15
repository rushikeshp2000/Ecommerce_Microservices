package com.ecommerce.order.feign;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.order.Dto.CartResponse;

import io.swagger.annotations.ApiParam;


@org.springframework.cloud.openfeign.FeignClient(name = "CARTSERVICE")
public interface FeignService {
	
	
	@GetMapping("/cart/{UserId}")
	public ResponseEntity<CartResponse> getAllUser(
		   @PathVariable("UserId") String userId);	
	
	@DeleteMapping("cart/{UserId}/{ProductName}")
	public ResponseEntity<CartResponse> deleteProduct(
			@PathVariable("ProductName") String productName,
			@PathVariable("UserId") String userId);
	
	@DeleteMapping("/cart/{UserId}")
	public ResponseEntity<CartResponse> deleteAllProduct(
			@PathVariable("UserId") String userId);
}
