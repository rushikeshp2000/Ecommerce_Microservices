package com.ecommerce.cart.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.NativeWebRequest;

import com.ecommerce.cart.model.CartResponse;
import com.ecommerce.cart.model.Response;
import com.ecommerce.cart.service.CartService;

import io.swagger.annotations.ApiParam;
import jakarta.servlet.http.HttpServletResponse;

public class ApiUtil {

	public static void setExampleResponse(NativeWebRequest req, String contentType, String example) {
		try {
		jakarta.servlet.http.HttpServletResponse res = req.getNativeResponse(HttpServletResponse.class);
		res.setCharacterEncoding("UTF-8");
		res.addHeader("Content-Type", contentType);
		res.getWriter().print(example);
		} catch (IOException e) {
		throw new RuntimeException(e);
		}
}
}
/*
 * @Autowired CartService service;
 * 
 * private final NativeWebRequest request;
 * 
 * @org.springframework.beans.factory.annotation.Autowired public
 * CartApiController(NativeWebRequest request) { this.request = request; }
 * 
 * @Override public Optional<NativeWebRequest> getRequest() { return
 * Optional.ofNullable(request); }
 * 
 * public ResponseEntity<CartResponse> createCart(
 * 
 * @ApiParam(value = "", required = true) @PathVariable("UserId") String userId,
 * 
 * @ApiParam(value = "", required = true) @PathVariable("ProductName") String
 * productName) {
 * 
 * System.out.println("contorller"); Response saveToCart =
 * service.saveToCart(userId, productName); CartResponse response = new
 * CartResponse(); response.addResultItem(saveToCart);
 * response.setStatusCode(HttpStatus.ACCEPTED.value());
 * response.setStatusMessage("Saved to cart"); return new
 * ResponseEntity<CartResponse>(response, HttpStatus.OK); }
 * 
 * public ResponseEntity<Void> deleteProduct(
 * 
 * @ApiParam(value = "", required = true) @PathVariable("ProductName") String
 * productName,
 * 
 * @ApiParam(value = "", required = true) @PathVariable("UserId") String userId)
 * {
 * 
 * service.deleteCart(userId, productName); return null; }
 * 
 * public ResponseEntity<CartResponse> loginUser(
 * 
 * @ApiParam(value = "", required = true) @PathVariable("UserId") String userId)
 * { List<Response> viewAll = service.viewAll(userId); CartResponse response =
 * new CartResponse(); response.setResult(viewAll);
 * response.setStatusCode(HttpStatus.ACCEPTED.value());
 * response.setStatusMessage("get All users"); return new
 * ResponseEntity<CartResponse>(response, HttpStatus.OK); }
 * 
 * public ResponseEntity<CartResponse> updateSingleProducts(
 * 
 * @ApiParam(value = "", required = true) @PathVariable("ProductName") String
 * productName,
 * 
 * @ApiParam(value = "", required = true) @PathVariable("UserId") String userId,
 * 
 * @ApiParam(value = "", required = true) @PathVariable("quantity") String
 * quantity) { Response updateQuantity = service.updateQuantity(userId,
 * productName, Integer.parseInt(quantity)); CartResponse response = new
 * CartResponse(); response.addResultItem(updateQuantity);
 * response.setStatusCode(HttpStatus.ACCEPTED.value());
 * response.setStatusMessage("Saved to cart"); return new
 * ResponseEntity<CartResponse>(response, HttpStatus.OK); }
 * 
 * public ResponseEntity<CartResponse> getSingleCart(
 * 
 * @ApiParam(value = "", required = true) @PathVariable("UserId") String userId,
 * 
 * @ApiParam(value = "", required = true) @PathVariable("ProductName") String
 * productName) { Response singleCart = service.singleCart(userId, productName);
 * CartResponse response = new CartResponse();
 * response.addResultItem(singleCart);
 * response.setStatusCode(HttpStatus.ACCEPTED.value());
 * response.setStatusMessage("Saved to cart"); return new
 * ResponseEntity<CartResponse>(response, HttpStatus.OK); }
 * 
 * public ResponseEntity<CartResponse> getAllUser(
 * 
 * @ApiParam(value = "", required = true) @PathVariable("UserId") String userId)
 * { List<Response> viewAll = service.viewAll(userId); CartResponse response =
 * new CartResponse(); response.setResult(viewAll);
 * response.setStatusCode(HttpStatus.ACCEPTED.value());
 * response.setStatusMessage("get All users"); return new
 * ResponseEntity<CartResponse>(response, HttpStatus.OK); }
 * 
 * public ResponseEntity<Void> deleteAllProduct(
 * 
 * @ApiParam(value = "", required = true) @PathVariable("UserId") String userId)
 * {
 * 
 * service.deleteAllCart(userId); return new
 * ResponseEntity<Void>(HttpStatus.ACCEPTED); }
 */