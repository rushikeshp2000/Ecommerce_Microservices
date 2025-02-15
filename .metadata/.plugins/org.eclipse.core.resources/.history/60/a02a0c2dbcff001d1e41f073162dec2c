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
		return repository.save(entityProd);
	}

	@Override
	public List<Product> GetAllProduct() {
		return repository.findAll();
	}

	@Override
	public Product viewSingleProduct(String productName) {
		return repository.findByName(productName);
	}

	@Override
	public Product viewSingleProductForSeller(String sellerID, String productName) {
		UUID uuid = UUID.fromString(sellerID);
		Product findBySellerNumberAndName = repository.findBySellerNumberAndName(uuid, productName);
		
		System.out.println(findBySellerNumberAndName);
		return findBySellerNumberAndName;
	}

	@Override
	public List<Product> viewAllProductsFromSeller(String category, String sellerID) {
		UUID uuid = UUID.fromString(sellerID);
		List<Product> findBySellerNumberAndCategory = repository.findBySellerNumberAndCategory(uuid, category);
		return findBySellerNumberAndCategory;
	}

	@Override
	public Void deleteProduct(String productName, String sellerID) {
		UUID uuid = UUID.fromString(sellerID);
		repository.deleteBySellerNumberAndName(uuid, productName);
		return null;
	}

	@Override
	public List<Product> viewAllProductsOfCategory(String category) {
		return repository.findByCategory(category);
	}

	@Override
	public Product UpdateAProductOfSeller(String productName, String sellerID, Product product) {
		UUID uuid = UUID.fromString(sellerID);
		Product findBySellerNumberAndName = repository.findBySellerNumberAndName(uuid, productName);
		if(findBySellerNumberAndName != null)
		{
			Product updateproduct = new Product();
			updateproduct.setName(product.getName());
			updateproduct.sellerNumber(product.getSellerNumber());
			updateproduct.setCategory(product.getCategory());
			updateproduct.setDetails(product.getDetails());
			updateproduct.setDiscount(product.getDiscount());
			updateproduct.setQuantity(product.getQuantity());
			updateproduct.setPrice(product.getPrice());
			return repository.save(updateproduct);
		}
		return null;
	}

}
