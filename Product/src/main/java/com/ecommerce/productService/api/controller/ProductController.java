package com.ecommerce.productService.api.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.productService.api.entity.ProductEntity;
import com.ecommerce.productService.api.mapper.MapStructMapper;
import com.ecommerce.productService.api.model.Product;
import com.ecommerce.productService.api.model.ProductResponse;
import com.ecommerce.productService.api.service.ProductServiceImpl;

import io.swagger.annotations.ApiParam;

@RestController
public class ProductController implements ProductApi,ProductsApi{

	/*
	 * @Autowired MapStructMapper Mapper;
	 */
	@Autowired
	ProductServiceImpl prodService;
	
	@Override
	public Optional<NativeWebRequest> getRequest() {
		// TODO Auto-generated method stub
		return ProductApi.super.getRequest();
	}
	
	
	public ResponseEntity<List<ProductResponse>> saveProduct(@ApiParam(value = "") @RequestPart(value="name", required=false)  String name,@ApiParam(value = "") @Valid @RequestPart(value = "imagefile1") MultipartFile imagefile1,@ApiParam(value = "") @Valid @RequestPart(value = "imagefile2") MultipartFile imagefile2,@ApiParam(value = "") @Valid @RequestPart(value = "imagefile3") MultipartFile imagefile3,@ApiParam(value = "") @RequestPart(value="price", required=false)  BigDecimal price,@ApiParam(value = "") @RequestPart(value="details", required=false)  String details,@ApiParam(value = "") @RequestPart(value="quantity", required=false)  Integer quantity,@ApiParam(value = "") @RequestPart(value="sellerNumber", required=false)  UUID sellerNumber,@ApiParam(value = "") @RequestPart(value="category", required=false)  String category,@ApiParam(value = "") @RequestPart(value="discount", required=false)  Integer discount)
	{
		ProductEntity product = new ProductEntity();
		product.setName(name);
		product.setImagefile1(imagefile1);
		product.setImagefile2(imagefile2);
		product.setImagefile3(imagefile3);
		product.setPrice(price);
		product.setDetails(details);
		product.setQuantity(quantity);
		product.setSellerNumber(sellerNumber);
		product.setCategory(category);
		product.setDiscount(discount);
		ProductEntity SavedProduct = prodService.AddProduct(product);
		System.out.println(SavedProduct);
		//Product entityToModel = Mapper.EntityToModel(SavedProduct);
		/*
		 * ProductResponse productResponse = new ProductResponse(); List<Product>
		 * resultlist = new ArrayList<>(); resultlist.add(entityToModel);
		 * productResponse.setResult(resultlist);
		 * productResponse.setStatusCode(org.springframework.http.HttpStatus.ACCEPTED.
		 * value()); productResponse.setStatusMessage("accepted");
		 */
		return null;
	}
	
	public  ResponseEntity<List<ProductResponse>> getAllProducts(@ApiParam(value = "") @Valid @RequestParam(value = "name", required = false) String name,@ApiParam(value = "", defaultValue = "0") @Valid @RequestParam(value = "pageNumber", required = false, defaultValue="0") Integer pageNumber,@ApiParam(value = "", defaultValue = "15") @Valid @RequestParam(value = "pageSize", required = false, defaultValue="15") Integer pageSize) 
	{
		return null;
	}
	
}
