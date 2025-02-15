package com.ecommerce.cart.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.cart.Dto.ProductDTO;
import com.ecommerce.cart.Dto.ProductResponse;

import io.swagger.annotations.ApiParam;

@FeignClient(name = "PRODUCTSERVICE")
public interface ProductFeign {
	
	
	@GetMapping("/product/productView/{ProductName}")
	public ResponseEntity<ProductResponse> getSingleProducts(@ApiParam(value = "",required=true) @PathVariable("ProductName") String productName);
        

}
