package com.template.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.template.mongodb.model.Product;
import com.template.mongodb.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository repo;
	
	@Override
	public Product saveProduct(Product prodOne) {
		return repo.save(prodOne);
	}

	@Override
	public List<Product> getProduct() {
		return repo.findAll();
	}

}
