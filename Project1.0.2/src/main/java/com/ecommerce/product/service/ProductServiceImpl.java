package com.ecommerce.product.service;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.product.entity.ProductEntity;
import com.ecommerce.product.mapper.MapStructMapper;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired 
	MapStructMapper mapper;
	 
	
	@Autowired
	ProductRepository repository;

	
	@Override
	public Product SaveProduct(Product product) {
		
		  ProductEntity entityProd = mapper.modelToEntity(product); 	  
		  ProductEntity savedProduct = repository.save(entityProd);
		  Product savedModel = mapper.entityToModel(savedProduct);
		  return savedModel;
	}
	
	@Override
	public List<Product> GetAllProduct() { 
		 List<ProductEntity> findAll = repository.findAll();
		 List<Product> allProductList = mapper.listentityToModel(findAll);
		return allProductList;
	}

	@Override
	public Product viewSingleProduct(String productName) {
		ProductEntity findByName = repository.findByName(productName);
		Product findModel = mapper.entityToModel(findByName);
		return findModel;
	}

	@Override
	public Product viewSingleProductForSeller(String sellerID, String productName) {
		UUID uuid = UUID.fromString(sellerID);
		ProductEntity findBySellerNumberAndName = repository.findBySellerNumberAndName(uuid, productName);
		Product prodModel = mapper.entityToModel(findBySellerNumberAndName);
		return prodModel;

	}

	@Override public List<Product> viewAllProductsFromSeller(String category,String sellerID) 
	{ 
		UUID uuid = UUID.fromString(sellerID); 
		List<ProductEntity> findBySellerNumberAndCategory = repository.findBySellerNumberAndCategory(uuid, category);
		List<Product> listProduct = mapper.listentityToModel(findBySellerNumberAndCategory);
	    return listProduct; 
	}

	@Override
	public Void deleteProduct(String productName, String sellerID) {

		UUID uuid = UUID.fromString(sellerID);
		repository.deleteBySellerNumberAndName(uuid, productName);
		return null;
	}

	@Override public List<Product> viewAllProductsOfCategory(String category) 
	{
		List<ProductEntity> findByCategory = repository.findByCategory(category);
		List<Product> listProduct = mapper.listentityToModel(findByCategory);
		return listProduct; 
	
	}

	@Override
	public Product UpdateAProductOfSeller(String productName, String sellerID, Product product) {

		UUID uuid = UUID.fromString(sellerID);
		ProductEntity entity = mapper.modelToEntity(product);

		ProductEntity updateproduct = repository.findBySellerNumberAndName(uuid, productName);
		if(updateproduct != null)
		{
	    updateproduct.setId(updateproduct.getId());
		updateproduct.setName(entity.getName());
		updateproduct.setSellerNumber(entity.getSellerNumber());
		updateproduct.setCategory(entity.getCategory());
		updateproduct.setDetails(entity.getDetails());
		updateproduct.setDiscount(entity.getDiscount());
		updateproduct.setQuantity(entity.getQuantity());
		updateproduct.setPrice(entity.getPrice()); 
		System.out.println(updateproduct);
		ProductEntity UpdatedEntity = repository.save(updateproduct);
		System.out.println(UpdatedEntity); 
		  Product UpdateModel = mapper.entityToModel(UpdatedEntity); 
		  return UpdateModel;
		 
		}
		 
		return null;
	}

}
