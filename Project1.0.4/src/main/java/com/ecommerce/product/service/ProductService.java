package com.ecommerce.product.service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.product.model.Product;

public interface ProductService {
	
	  Product SaveProduct(String name,Double price,String details,Integer quantity,UUID sellerNumber,String category,Integer discount,List<MultipartFile> images) throws IOException;
	
	  List<Product> GetAllProduct(Integer pageNumber, Integer pageSize);
	  
	  Product viewSingleProduct(String productName);
	  
	  Product viewSingleProductForSeller(String sellerID,String productName);
	  
	  Void deleteProduct(String productName,String sellerID);
	  
	  Product UpdateAProductOfSeller(String name,Double price,String details,Integer quantity,String sellerNumber,String category,Integer discount,List<MultipartFile> images) throws IOException, Exception;
	  
	 
	 List<Product> viewAllProductsFromSeller(String category, String sellerID, Integer pageNumber, Integer pageSize);

	List<Product> viewAllProductsOfCategory(String category, Integer pageNumber, Integer pageSize);

	List<Product> viewProductCategoryPrice(String category, Double price, Integer pageNumber, Integer pageSize);

	List<Product> viewProductsDiscount(Integer discount, Integer pageNumber, Integer pageSize);

	List<Product> viewProductPrice(Double price, Integer pageNumber, Integer pageSize);

	List<Product> viewProductCategoryDiscount(Integer discount, String category, Integer pageNumber, Integer pageSize);
	
}
