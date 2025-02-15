package com.ecommerce.product.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.product.entity.ProductEntity;
import com.ecommerce.product.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String>{

	ProductEntity findByName(String name);
	
	ProductEntity findBySellerNumberAndName(UUID sellerID,String productName);
	
	Page<ProductEntity> findBySellerNumberAndCategory(UUID sellerID,String category,Pageable pageable);
	
	Page<ProductEntity> findByCategory(String category,Pageable pageable);
	
	void deleteBySellerNumberAndName(UUID sellerNumber, String name);
	
	Page<ProductEntity> findByPrice(Double price,Pageable pageable);
	
	List<ProductEntity> findByDiscount(Integer discount);
	
	Page<ProductEntity> findByCategoryAndDiscount(String category, Integer discount,Pageable pageable);
	
	Page<ProductEntity> findByCategoryAndPrice(String category, Double price,Pageable pageable);
	

	
}
