package com.ecommerce.product.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.product.entity.PaginationCreater;
import com.ecommerce.product.entity.ProductEntity;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.model.ProductResponse;
import com.ecommerce.product.model.ProductResponsePageDate;
import com.ecommerce.product.service.ProductService;

import io.swagger.annotations.ApiParam;

public class CommonProduct {
	/*
	 * @Autowired ProductService service;
	 * 
	 * @Autowired PaginationCreater createPage;
	 * 
	 * private final NativeWebRequest request;
	 * 
	 * @org.springframework.beans.factory.annotation.Autowired public
	 * ProductsApiController(NativeWebRequest request) { this.request = request; }
	 * 
	 * @Override public Optional<NativeWebRequest> getRequest() { return
	 * Optional.ofNullable(request); }
	 * 
	 * public ResponseEntity<ProductResponse> saveProduct(
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
	 * List<MultipartFile> images) { Product saveProduct = null; try { saveProduct =
	 * service.SaveProduct(name, Double.parseDouble(price), details,
	 * Integer.parseInt(quantity), sellerNumber, category,
	 * Integer.parseInt(discount), images); } catch (NumberFormatException e) { //
	 * e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
	 * ProductResponse resultObject = new ProductResponse();
	 * resultObject.addResultItem(saveProduct);
	 * resultObject.setStatusCode(HttpStatus.CREATED.value());
	 * resultObject.setStatusMessage("Saved Product"); return new
	 * ResponseEntity<ProductResponse>(resultObject, HttpStatus.OK); }
	 * 
	 * public ResponseEntity<ProductResponse> getAllProducts(
	 * 
	 * @ApiParam(value = "") @Valid @RequestParam(value = "name", required = false)
	 * String name,
	 * 
	 * @ApiParam(value = "") @Valid @RequestParam(value = "price", required = false)
	 * Double price,
	 * 
	 * @ApiParam(value = "") @Valid @RequestParam(value = "category", required =
	 * false) String category,
	 * 
	 * @ApiParam(value = "") @Valid @RequestParam(value = "discount", required =
	 * false) Integer discount,
	 * 
	 * @ApiParam(value = "", defaultValue = "0") @Valid @RequestParam(value =
	 * "offset", required = false, defaultValue = "0") Integer offset,
	 * 
	 * @ApiParam(value = "", defaultValue = "15") @Valid @RequestParam(value =
	 * "limit", required = false, defaultValue = "15") Integer limit) {
	 * List<Product> getAllProduct = service.GetAllProduct(offset, limit);
	 * ProductResponse resObject = new ProductResponse();
	 * resObject.setResult(getAllProduct);
	 * resObject.setStatusCode(HttpStatus.ACCEPTED.value());
	 * resObject.setStatusMessage("List of Products "); ProductResponsePageDate
	 * pageData = new ProductResponsePageDate();
	 * pageData.setLimit(createPage.getNumberOfElements());
	 * pageData.setOffset(createPage.getNumber());
	 * pageData.setTotalItems(createPage.getTotalElements());
	 * pageData.setTotalPages(createPage.getTotalPages());
	 * resObject.setPageDate(pageData); return new
	 * ResponseEntity<ProductResponse>(resObject, HttpStatus.OK); }
	 */

	// ******************************************************************************************************\\

	/*
	 * @Autowired ProductService service;
	 * 
	 * @Autowired PaginationCreater createPage;
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
	 * 
	 * public ProductEntity getProductCart(String name) { ProductEntity
	 * singleproduct = service.getSingleProductCart(name); return singleproduct; }
	 * 
	 * @RequestMapping(value = "/product/Feign/{name}", method = RequestMethod.GET)
	 * public ProductEntity getProductCart(@PathVariable("name") String name);
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
	 * "offset", required = false, defaultValue = "0") Integer offset,
	 * 
	 * @ApiParam(value = "", defaultValue = "15") @Valid @RequestParam(value =
	 * "limit", required = false, defaultValue = "15") Integer limit) {
	 * List<Product> viewAllProductsOfCategory =
	 * service.viewAllProductsOfCategory(category, offset, limit); ProductResponse
	 * productRes = new ProductResponse();
	 * productRes.setResult(viewAllProductsOfCategory);
	 * productRes.setStatusCode(HttpStatus.ACCEPTED.value());
	 * productRes.setStatusMessage("ALL list of products for user");
	 * ProductResponsePageDate pageData = new ProductResponsePageDate();
	 * pageData.setLimit(createPage.getNumberOfElements());
	 * pageData.setOffset(createPage.getNumber());
	 * pageData.setTotalItems(createPage.getTotalElements());
	 * pageData.setTotalPages(createPage.getTotalPages());
	 * productRes.setPageDate(pageData); return new
	 * ResponseEntity<ProductResponse>(productRes, HttpStatus.OK); }
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
	 * public ResponseEntity<ProductResponse> allProductsBySellerId(
	 * 
	 * @ApiParam(value = "", required = true) @PathVariable("sellerID") String
	 * sellerID) { List<Product> bysellerId = service.getBysellerId(sellerID);
	 * ProductResponse resultObject = new ProductResponse();
	 * resultObject.setResult(bysellerId);
	 * resultObject.setStatusCode(HttpStatus.ACCEPTED.value());
	 * resultObject.setStatusMessage("Updated the product inside the database");
	 * return new ResponseEntity<ProductResponse>(resultObject, HttpStatus.OK); }
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
	 * "offset", required = false, defaultValue = "0") Integer offset,
	 * 
	 * @ApiParam(value = "", defaultValue = "15") @Valid @RequestParam(value =
	 * "limit", required = false, defaultValue = "15") Integer limit) {
	 * List<Product> viewAllProductsFromSeller =
	 * service.viewAllProductsFromSeller(category, sellerID, offset, limit);
	 * ProductResponse productRes = new ProductResponse();
	 * productRes.setResult(viewAllProductsFromSeller);
	 * productRes.setStatusCode(HttpStatus.ACCEPTED.value()); productRes.
	 * setStatusMessage("ALL list of products according to category of specific seller"
	 * ); ProductResponsePageDate pageData = new ProductResponsePageDate();
	 * pageData.setLimit(createPage.getNumberOfElements());
	 * pageData.setOffset(createPage.getNumber());
	 * pageData.setTotalItems(createPage.getTotalElements());
	 * pageData.setTotalPages(createPage.getTotalPages());
	 * productRes.setPageDate(pageData); return new
	 * ResponseEntity<ProductResponse>(productRes, HttpStatus.OK); }
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
	 * public ResponseEntity<ProductResponse> getStatusProducts(
	 * 
	 * @ApiParam(value = "", required = true) @PathVariable("sellerID") String
	 * sellerID,
	 * 
	 * @ApiParam(value = "", required = true) @PathVariable("statusId") String
	 * statusId) {
	 * 
	 * List<Product> bySellerIdAndStatus = service.getBySellerIdAndStatus(sellerID,
	 * statusId); ProductResponse resultObject = new ProductResponse();
	 * resultObject.setResult(bySellerIdAndStatus);
	 * resultObject.setStatusCode(HttpStatus.ACCEPTED.value());
	 * resultObject.setStatusMessage("A single product according to the ProductName"
	 * ); return new ResponseEntity<ProductResponse>(resultObject, HttpStatus.OK); }
	 * 
	 * 
	 * public ResponseEntity<ProductResponse>
	 * productStatusSellerIDStatusIdCategoryPut(
	 * 
	 * @ApiParam(value = "", required = true) @PathVariable("sellerID") String
	 * sellerID,
	 * 
	 * @ApiParam(value = "", required = true) @PathVariable("statusId") String
	 * statusId,
	 * 
	 * @ApiParam(value = "", required = true) @PathVariable("category") String
	 * category) {
	 * 
	 * List<Product> bySellerIdAndStatusCategory =
	 * service.getBySellerIdAndStatusCategory(sellerID, statusId, category);
	 * ProductResponse resultObject = new ProductResponse();
	 * resultObject.setResult(bySellerIdAndStatusCategory);
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
	 * @ApiParam(value = "") @RequestPart(value = "status", required = false) String
	 * status,
	 * 
	 * @ApiParam(value = "") @Valid @RequestPart(value = "",required = false)
	 * List<MultipartFile> images) {
	 * 
	 * Product updateAProductOfSeller = null; try { updateAProductOfSeller =
	 * service.UpdateAProductOfSeller(name, Double.parseDouble(price), details,
	 * Integer.parseInt(quantity), sellerNumber, category,
	 * Integer.parseInt(discount), status, images); } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * 
	 * ProductResponse resultObject = new ProductResponse();
	 * resultObject.addResultItem(updateAProductOfSeller);
	 * resultObject.setStatusCode(HttpStatus.ACCEPTED.value());
	 * resultObject.setStatusMessage("A single product according to the ProductName"
	 * ); System.out.println(updateAProductOfSeller + "here"); return new
	 * ResponseEntity<ProductResponse>(resultObject, HttpStatus.OK); }
	 */

}