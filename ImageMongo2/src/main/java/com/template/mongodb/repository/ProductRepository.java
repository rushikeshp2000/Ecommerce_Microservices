package com.template.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.template.mongodb.enitty.ProductEntity;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity,String>{

	
	ProductEntity findByName(String name);
}
