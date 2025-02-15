package com.ecommerce.cart.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.cart.entity.CartEntity;

@Repository
public interface CartRepository extends MongoRepository<CartEntity, String>{

	
	List<CartEntity> findByNameAndUserId(String name, String userId);
	
	List<CartEntity> findByUserId(String userId);
	
	void deleteByUserId(String userId);
}
