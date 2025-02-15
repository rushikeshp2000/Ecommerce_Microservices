package com.ecommerce.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.ecommerce.order.Dto.ProductResponse;


@FeignClient(name = "PRODUCTSERVICE")
public interface FeignProduct {
	
	@PutMapping("/product/quantity/{productName}/{quantity}")
	public ResponseEntity<ProductResponse> updateQuantityProduct(
			 @PathVariable("productName") String productName,
			 @PathVariable("quantity") String quantity);

}
