package com.ecommerce.product.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import com.ecommerce.product.model.Product;
import com.ecommerce.product.model.ProductResponse;
import com.ecommerce.product.service.ProductService;

import io.swagger.annotations.ApiParam;

public class CommonProduct {

	/*
	 * @Autowired ProductService service;
	 * 
	 * private final NativeWebRequest request;
	 * 
	 * @org.springframework.beans.factory.annotation.Autowired public
	 * ProductApiController(NativeWebRequest request) { this.request = request; }
	 * 
	 * @Override public Optional<NativeWebRequest> getRequest() { return
	 * Optional.ofNullable(request); }
	 * 
	 * 
	 * public ResponseEntity<Void> deleteProduct(@ApiParam(value =
	 * "The name that needs to be deleted",required=true) @PathVariable(
	 * "ProductName") String productName,@ApiParam(value =
	 * "",required=true) @PathVariable("sellerID") String sellerID) {
	 * service.deleteProduct(productName, sellerID); return new
	 * ResponseEntity<Void>(HttpStatus.OK); }
	 * 
	 * public ResponseEntity<ProductResponse> getAllCategoryProducts(@ApiParam(value
	 * = "",required=true) @PathVariable("category") String category,@ApiParam(value
	 * = "") @Valid @RequestParam(value = "productname", required = false) String
	 * productname,@ApiParam(value = "", defaultValue =
	 * "0") @Valid @RequestParam(value = "pageNumber", required = false,
	 * defaultValue="0") Integer pageNumber,@ApiParam(value = "", defaultValue =
	 * "15") @Valid @RequestParam(value = "pageSize", required = false,
	 * defaultValue="15") Integer pageSize) { List<Product>
	 * viewAllProductsOfCategory = service.viewAllProductsOfCategory(category);
	 * ProductResponse productRes = new ProductResponse();
	 * productRes.setResult(viewAllProductsOfCategory);
	 * productRes.setStatusCode(HttpStatus.ACCEPTED.value());
	 * productRes.setStatusMessage("ALL list of products for user"); return new
	 * ResponseEntity<ProductResponse>(productRes, HttpStatus.OK); }
	 * 
	 * public ResponseEntity<ProductResponse> getAllSellerProducts(@ApiParam(value =
	 * "",required=true) @PathVariable("category") String category,@ApiParam(value =
	 * "",required=true) @PathVariable("sellerID") String sellerID,@ApiParam(value =
	 * "", defaultValue = "0") @Valid @RequestParam(value = "pageNumber", required =
	 * false, defaultValue="0") Integer pageNumber,@ApiParam(value = "",
	 * defaultValue = "15") @Valid @RequestParam(value = "pageSize", required =
	 * false, defaultValue="15") Integer pageSize) {
	 * 
	 * List<Product> viewAllProductsFromSeller =
	 * service.viewAllProductsFromSeller(category, sellerID); ProductResponse
	 * productRes = new ProductResponse();
	 * productRes.setResult(viewAllProductsFromSeller);
	 * productRes.setStatusCode(HttpStatus.ACCEPTED.value()); productRes.
	 * setStatusMessage("ALL list of products according to category of specific seller"
	 * ); return new ResponseEntity<ProductResponse>(productRes, HttpStatus.OK); }
	 * 
	 * public ResponseEntity<ProductResponse>
	 * getSingleProductBySeller(@ApiParam(value =
	 * "",required=true) @PathVariable("ProductName") String
	 * productName,@ApiParam(value = "",required=true) @PathVariable("sellerID")
	 * String sellerID) {
	 * 
	 * Product viewSingleProductForSeller =
	 * service.viewSingleProductForSeller(sellerID, productName); ProductResponse
	 * resultObject = new ProductResponse();
	 * resultObject.addResultItem(viewSingleProductForSeller);
	 * resultObject.setStatusCode(HttpStatus.ACCEPTED.value());
	 * resultObject.setStatusMessage("A single product from the Seller "); return
	 * new ResponseEntity<ProductResponse>(resultObject,HttpStatus.OK); }
	 * 
	 * public ResponseEntity<ProductResponse> getSingleProducts(@ApiParam(value =
	 * "",required=true) @PathVariable("ProductName") String productName) { Product
	 * viewSingleProduct = service.viewSingleProduct(productName); ProductResponse
	 * resultObject = new ProductResponse();
	 * resultObject.addResultItem(viewSingleProduct);
	 * resultObject.setStatusCode(HttpStatus.ACCEPTED.value());
	 * resultObject.setStatusMessage("A single product according to the ProductName"
	 * ); return new ResponseEntity<ProductResponse>(resultObject,HttpStatus.OK); }
	 * 
	 * public ResponseEntity<ProductResponse> updateSingleProducts(@ApiParam(value =
	 * "",required=true) @PathVariable("ProductName") String
	 * productName,@ApiParam(value = "",required=true) @PathVariable("sellerID")
	 * String sellerID,@ApiParam(value = "" ,required=true ) @Valid @RequestBody
	 * Product product) {
	 * 
	 * Product updateAProductOfSeller = service.UpdateAProductOfSeller(productName,
	 * sellerID, product); ProductResponse resultObject = new ProductResponse();
	 * resultObject.addResultItem(updateAProductOfSeller);
	 * resultObject.setStatusCode(HttpStatus.ACCEPTED.value());
	 * resultObject.setStatusMessage("Updated the product inside the database");
	 * return new ResponseEntity<ProductResponse>(resultObject,HttpStatus.OK); }
	 * 
	 */


	/*
	 * private final NativeWebRequest request;
	 * 
	 * @Autowired ProductService service;
	 * 
	 * @org.springframework.beans.factory.annotation.Autowired public
	 * ProductsApiController(NativeWebRequest request) { this.request = request; }
	 * 
	 * @Override public Optional<NativeWebRequest> getRequest() { return
	 * Optional.ofNullable(request); }
	 * 
	 * public ResponseEntity<ProductResponse> saveProduct(@ApiParam(value = ""
	 * ,required=true ) @Valid @RequestBody Product product) { Product saveProduct =
	 * service.SaveProduct(product); ProductResponse resultObject = new
	 * ProductResponse(); resultObject.addResultItem(saveProduct);
	 * resultObject.setStatusCode(HttpStatus.CREATED.value());
	 * resultObject.setStatusMessage("Saved Product"); return new
	 * ResponseEntity<ProductResponse>(resultObject,HttpStatus.OK);
	 * 
	 * }
	 * 
	 * public ResponseEntity<ProductResponse> getAllProducts(@ApiParam(value =
	 * "") @Valid @RequestParam(value = "name", required = false) String
	 * name,@ApiParam(value = "", defaultValue = "0") @Valid @RequestParam(value =
	 * "pageNumber", required = false, defaultValue="0") Integer
	 * pageNumber,@ApiParam(value = "", defaultValue =
	 * "15") @Valid @RequestParam(value = "pageSize", required = false,
	 * defaultValue="15") Integer pageSize) { List<Product> getAllProduct =
	 * service.GetAllProduct(); ProductResponse resObject = new ProductResponse();
	 * resObject.setResult(getAllProduct);
	 * resObject.setStatusCode(HttpStatus.ACCEPTED.value());
	 * resObject.setStatusMessage("List of Products "); return new
	 * ResponseEntity<ProductResponse>(resObject, HttpStatus.OK); }
	 */


}
