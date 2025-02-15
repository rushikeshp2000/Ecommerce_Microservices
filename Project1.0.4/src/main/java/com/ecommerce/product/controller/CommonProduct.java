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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.product.model.Product;
import com.ecommerce.product.model.ProductResponse;
import com.ecommerce.product.service.ProductService;

import io.swagger.annotations.ApiParam;

public class CommonProduct {

	//***************************ProductAPIController ****************************************************

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
	 * public ResponseEntity<Void> deleteProduct(
	 * 
	 * @ApiParam(value = "The name that needs to be deleted", required =
	 * true) @PathVariable("ProductName") String productName,
	 * 
	 * @ApiParam(value = "", required = true) @PathVariable("sellerID") String
	 * sellerID) { service.deleteProduct(productName, sellerID); return new
	 * ResponseEntity<Void>(HttpStatus.OK); }
	 * 
	 * public ResponseEntity<ProductResponse> getAllCategoryProducts(
	 * 
	 * @ApiParam(value = "", required = true) @PathVariable("category") String
	 * category,
	 * 
	 * @ApiParam(value = "") @Valid @RequestParam(value = "productname", required =
	 * false) String productname,
	 * 
	 * @ApiParam(value = "", defaultValue = "0") @Valid @RequestParam(value =
	 * "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
	 * 
	 * @ApiParam(value = "", defaultValue = "15") @Valid @RequestParam(value =
	 * "pageSize", required = false, defaultValue = "15") Integer pageSize) {
	 * List<Product> viewAllProductsOfCategory =
	 * service.viewAllProductsOfCategory(category, pageNumber, pageSize);
	 * ProductResponse productRes = new ProductResponse();
	 * productRes.setResult(viewAllProductsOfCategory);
	 * productRes.setStatusCode(HttpStatus.ACCEPTED.value());
	 * productRes.setStatusMessage("ALL list of products for user"); return new
	 * ResponseEntity<ProductResponse>(productRes, HttpStatus.OK); }
	 * 
	 * public ResponseEntity<ProductResponse> getAllSellerProducts(
	 * 
	 * @ApiParam(value = "", required = true) @PathVariable("category") String
	 * category,
	 * 
	 * @ApiParam(value = "", required = true) @PathVariable("sellerID") String
	 * sellerID,
	 * 
	 * @ApiParam(value = "", defaultValue = "0") @Valid @RequestParam(value =
	 * "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
	 * 
	 * @ApiParam(value = "", defaultValue = "15") @Valid @RequestParam(value =
	 * "pageSize", required = false, defaultValue = "15") Integer pageSize) {
	 * List<Product> viewAllProductsFromSeller =
	 * service.viewAllProductsFromSeller(category, sellerID, pageNumber, pageSize);
	 * ProductResponse productRes = new ProductResponse();
	 * productRes.setResult(viewAllProductsFromSeller);
	 * productRes.setStatusCode(HttpStatus.ACCEPTED.value()); productRes.
	 * setStatusMessage("ALL list of products according to category of specific seller"
	 * ); return new ResponseEntity<ProductResponse>(productRes, HttpStatus.OK); }
	 * 
	 * public ResponseEntity<ProductResponse> getSingleProductBySeller(
	 * 
	 * @ApiParam(value = "", required = true) @PathVariable("ProductName") String
	 * productName,
	 * 
	 * @ApiParam(value = "", required = true) @PathVariable("sellerID") String
	 * sellerID) { Product viewSingleProductForSeller =
	 * service.viewSingleProductForSeller(sellerID, productName); ProductResponse
	 * resultObject = new ProductResponse();
	 * resultObject.addResultItem(viewSingleProductForSeller);
	 * resultObject.setStatusCode(HttpStatus.ACCEPTED.value());
	 * resultObject.setStatusMessage("A single product from the Seller "); return
	 * new ResponseEntity<ProductResponse>(resultObject, HttpStatus.OK); }
	 * 
	 * public ResponseEntity<ProductResponse> getSingleProducts(
	 * 
	 * @ApiParam(value = "", required = true) @PathVariable("ProductName") String
	 * productName) { Product viewSingleProduct =
	 * service.viewSingleProduct(productName); ProductResponse resultObject = new
	 * ProductResponse(); resultObject.addResultItem(viewSingleProduct);
	 * resultObject.setStatusCode(HttpStatus.ACCEPTED.value());
	 * resultObject.setStatusMessage("A single product according to the ProductName"
	 * ); return new ResponseEntity<ProductResponse>(resultObject, HttpStatus.OK); }
	 * 
	 * public ResponseEntity<ProductResponse> updateSingleProducts(
	 * 
	 * @ApiParam(value = "", required = true) @PathVariable("ProductName") String
	 * productName,
	 * 
	 * @ApiParam(value = "", required = true) @PathVariable("sellerID") String
	 * sellerID,
	 * 
	 * @ApiParam(value = "") @RequestPart(value = "name", required = false) String
	 * name,
	 * 
	 * @ApiParam(value = "") @RequestPart(value = "price", required = false) String
	 * price,
	 * 
	 * @ApiParam(value = "") @RequestPart(value = "details", required = false)
	 * String details,
	 * 
	 * @ApiParam(value = "") @RequestPart(value = "quantity", required = false)
	 * String quantity,
	 * 
	 * @ApiParam(value = "") @RequestPart(value = "sellerNumber", required = false)
	 * String sellerNumber,
	 * 
	 * @ApiParam(value = "") @RequestPart(value = "category", required = false)
	 * String category,
	 * 
	 * @ApiParam(value = "") @RequestPart(value = "discount", required = false)
	 * String discount,
	 * 
	 * @ApiParam(value = "") @Valid @RequestPart(value = "images")
	 * List<MultipartFile> images) { Product updateAProductOfSeller = null; try {
	 * updateAProductOfSeller = service.UpdateAProductOfSeller(name,
	 * Double.parseDouble(price), details, Integer.parseInt(quantity), sellerNumber,
	 * category, Integer.parseInt(discount), images); } catch (Exception e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } ProductResponse
	 * resultObject = new ProductResponse();
	 * resultObject.addResultItem(updateAProductOfSeller);
	 * resultObject.setStatusCode(HttpStatus.ACCEPTED.value());
	 * resultObject.setStatusMessage("Updated the product inside the database");
	 * return new ResponseEntity<ProductResponse>(resultObject, HttpStatus.OK); }
	 */


	//*********************************************Products API controller *****************************************************
	/*
	 * /*	if (discount != null && category != null) {
			List<Product> viewProductCategoryDiscount = service.viewProductCategoryDiscount(discount, category, pageNumber, pageSize);
			ProductResponse productRes = new ProductResponse();
			productRes.setResult(viewProductCategoryDiscount);
			productRes.setStatusCode(HttpStatus.ACCEPTED.value());
			productRes.setStatusMessage("ALL list of products for user");
			return new ResponseEntity<ProductResponse>(productRes, HttpStatus.OK);
		} else if (price != null && category != null) {
			List<Product> viewProductCategoryPrice = service.viewProductCategoryPrice(category, price, pageNumber, pageSize);
			ProductResponse productRes = new ProductResponse();
			productRes.setResult(viewProductCategoryPrice);
			productRes.setStatusCode(HttpStatus.ACCEPTED.value());
			productRes.setStatusMessage("ALL list of products for user");
			return new ResponseEntity<ProductResponse>(productRes, HttpStatus.OK);
		} else if (name != null) {
			Product viewSingleProduct = service.viewSingleProduct(name);
			ProductResponse resultObject = new ProductResponse();
			resultObject.addResultItem(viewSingleProduct);
			resultObject.setStatusCode(HttpStatus.ACCEPTED.value());
			resultObject.setStatusMessage("A single product according to the ProductName");
			return new ResponseEntity<ProductResponse>(resultObject, HttpStatus.OK);
		} else if (category != null) {
			List<Product> viewAllProductsOfCategory = service.viewAllProductsOfCategory(category, pageNumber, pageSize);
			ProductResponse productRes = new ProductResponse();
			productRes.setResult(viewAllProductsOfCategory);
			productRes.setStatusCode(HttpStatus.ACCEPTED.value());
			productRes.setStatusMessage("ALL list of products for user");
			return new ResponseEntity<ProductResponse>(productRes, HttpStatus.OK);

		} else if (price != null) {
			List<Product> viewAllProductPrice = service.viewProductPrice(price, pageNumber, pageSize);
			ProductResponse resultObject = new ProductResponse();
			resultObject.setResult(viewAllProductPrice);
			resultObject.setStatusCode(HttpStatus.ACCEPTED.value());
			resultObject.setStatusMessage("List of products according to the price");
			return new ResponseEntity<ProductResponse>(resultObject, HttpStatus.OK);
		} else 
		 if (discount != null) {
			List<Product> viewAllProductDiscount = service.viewProductsDiscount(discount, pageNumber, pageSize);
			ProductResponse resultObject = new ProductResponse();
			resultObject.setResult(viewAllProductDiscount);
			resultObject.setStatusCode(HttpStatus.ACCEPTED.value());
			resultObject.setStatusMessage("List of products according to the price");
			return new ResponseEntity<ProductResponse>(resultObject, HttpStatus.OK);
		} else {*/
}
