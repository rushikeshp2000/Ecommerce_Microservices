package com.ecommerce.product.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.product.entity.ProductEntity;
import com.ecommerce.product.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String>{

	ProductEntity findByName(String name);
	
	ProductEntity findBySellerNumberAndName(UUID sellerID,String productName);
	
	List<ProductEntity> findBySellerNumberAndCategory(UUID sellerID,String category);
	
	List<ProductEntity> findByCategory(String category);
	
	void deleteBySellerNumberAndName(UUID sellerNumber, String name);

	
}
