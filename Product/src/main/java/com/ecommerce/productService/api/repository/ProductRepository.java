package com.ecommerce.productService.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.productService.api.entity.ProductEntity;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String>{

}
