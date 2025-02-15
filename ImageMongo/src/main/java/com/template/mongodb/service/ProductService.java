package com.template.mongodb.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.template.mongodb.enitty.ProductEntity;
import com.template.mongodb.model.ImageModel;
import com.template.mongodb.model.Product;
import com.template.mongodb.model.ProductByte;
import com.template.mongodb.model.ProductPost;

public interface ProductService {

	/*
	 * Product saveProduct(String name,String category, List<MultipartFile> image)
	 * throws IOException;
	 */
	
	Product imageString( String name, String category, List<ImageModel> image);
	
	ProductByte imageByte(ProductByte byteModel);
	
	ProductPost imageResource(ProductEntity entity);
	
}
