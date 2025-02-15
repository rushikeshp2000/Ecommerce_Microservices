package com.ecommerce.product.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.product.entity.ProductEntity;
import com.ecommerce.product.entity.ProductStatus;
import com.ecommerce.product.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String>{

	ProductEntity findByName(String name);
	
	ProductEntity findBySellerNumberAndName(String sellerID,String productName);
	
	Page<ProductEntity> findBySellerNumberAndCategory(String sellerID,String category,Pageable pageable);
	
	Page<ProductEntity> findByCategoryAndProdStatus(String category, ProductStatus prodStatus,Pageable pageable);
	
	void deleteBySellerNumberAndName(String sellerNumber, String name);
	
	Page<ProductEntity> findByPrice(Double price,Pageable pageable);
	
	List<ProductEntity> findByDiscount(Integer discount);
	
	List<ProductEntity> findBySellerNumber(String sellerNumber);
	
	Page<ProductEntity> findByProdStatus(ProductStatus prodStatus,Pageable pageable);
	
	List<ProductEntity> findBySellerNumberAndProdStatus(String sellerNumber, ProductStatus prodStatus);
	
	 List<ProductEntity> findBySellerNumberAndCategory(String sellerNumber, String category);
}
