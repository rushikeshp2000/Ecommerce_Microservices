package com.ecommerce.product.service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.product.entity.ProductEntity;
import com.ecommerce.product.model.InlineResponse200;
import com.ecommerce.product.model.Product;

public interface ProductService {
	
	  Product SaveProduct(String name,Double price,String details,Integer quantity,String sellerNumber,String category,Integer discount,List<MultipartFile> images) throws IOException;
	
	  List<Product> GetAllProduct(Integer pageNumber, Integer pageSize);
	  
	  Product viewSingleProduct(String productName);
	  
	  Product viewSingleProductForSeller(String sellerID,String productName);
	  
	  Void deleteProduct(String productName,String sellerID);
	  
	  Product UpdateAProductOfSeller(String name,Double price,String details,Integer quantity,String sellerNumber,String category,Integer discount,String status,List<MultipartFile> images) throws IOException, Exception;
	  
	 
	 List<Product> viewAllProductsFromSeller(String category, String sellerID, Integer pageNumber, Integer pageSize);

	List<Product> viewAllProductsOfCategory(String category, Integer pageNumber, Integer pageSize);

	List<Product> viewProductsDiscount(Integer discount, Integer pageNumber, Integer pageSize);

	List<Product> viewProductPrice(Double price, Integer pageNumber, Integer pageSize);
	
	public ProductEntity getSingleProductCart(String name); 
	
	List<Product> getBysellerId(String sellerNumber);
	
	List<Product> getBySellerIdAndStatus(String sellerID,String status);
	
	List<Product> getBySellerIdAndStatusCategory(String sellerID,String status,String category);
	
	Product updateQuantity(String ProductName, Integer quantity); 
}
