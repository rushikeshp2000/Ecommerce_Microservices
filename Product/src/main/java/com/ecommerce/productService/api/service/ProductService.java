package com.ecommerce.productService.api.service;

import java.util.List;

import com.ecommerce.productService.api.entity.ProductEntity;

public interface ProductService {

	ProductEntity AddProduct(ProductEntity product);
	
	List<ProductEntity> getAllProduct();
}
