package com.ecommerce.productService.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.productService.api.entity.ProductEntity;
import com.ecommerce.productService.api.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	ProductRepository productRepo;
	
	@Override
	public ProductEntity AddProduct(ProductEntity product) {
		return productRepo.save(product);
	}

	@Override
	public List<ProductEntity> getAllProduct() {
		return productRepo.findAll();
	}
	

}
