package com.ecommerce.product.service;

import java.util.List;

import com.ecommerce.product.model.Product;

public interface ProductService {
	
	Product SaveProduct(Product product);
	
	List<Product> GetAllProduct();
	
	Product viewSingleProduct(String productName);
	
	Product viewSingleProductForSeller(String sellerID,String productName);
	
	List<Product> viewAllProductsFromSeller(String category, String sellerID);
	
	Void deleteProduct(String productName,String sellerID);
	
	List<Product> viewAllProductsOfCategory(String category);
	
	Product UpdateAProductOfSeller(String productName, String sellerID ,Product product);

}
