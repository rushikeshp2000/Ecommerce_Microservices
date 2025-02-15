package com.ecommerce.cart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import com.ecommerce.cart.model.CartResponse;
import com.ecommerce.cart.model.Response;
import com.ecommerce.cart.service.CartService;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-15T01:03:00.414249800+05:30[Asia/Calcutta]")

@Controller
@RequestMapping("${openapi.userMicroService.base-path:}")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CartApiController implements CartApi {

	@Autowired
	CartService service;

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CartApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

	public ResponseEntity<CartResponse> deleteAllProduct(
			@ApiParam(value = "", required = true) @PathVariable("UserId") String userId) {
		
		List<Response> deleteAllCart = service.deleteAllCart(userId);
		CartResponse cartlist = new CartResponse();
		cartlist.setResult(deleteAllCart);
		cartlist.setStatusCode(HttpStatus.ACCEPTED.value());
		cartlist.setStatusMessage("deleted all cart products");
		return new ResponseEntity<CartResponse>(cartlist,HttpStatus.OK);
	}
	
	public ResponseEntity<CartResponse> deleteProduct(
			@ApiParam(value = "", required = true) @PathVariable("ProductName") String productName,
			@ApiParam(value = "", required = true) @PathVariable("UserId") String userId) {
		
		Response deleteCart = service.deleteCart(userId, productName);
		CartResponse cartlist = new CartResponse();
		cartlist.addResultItem(deleteCart);
		cartlist.setStatusCode(HttpStatus.ACCEPTED.value());
		cartlist.setStatusMessage("delete cart product");
		return new ResponseEntity<CartResponse>(cartlist,HttpStatus.OK);
	}
	
	public ResponseEntity<CartResponse> getAllUser(
			@ApiParam(value = "", required = true) @PathVariable("UserId") String userId) {
		List<Response> viewAll = service.viewAll(userId);
		CartResponse cartlist = new CartResponse();
		cartlist.setResult(viewAll);
		cartlist.setStatusCode(HttpStatus.ACCEPTED.value());
		cartlist.setStatusMessage("view all cart products");
		return new ResponseEntity<CartResponse>(cartlist,HttpStatus.OK);
	}
	
	public ResponseEntity<CartResponse> getSingleCart(
			@ApiParam(value = "", required = true) @PathVariable("UserId") String userId,
			@ApiParam(value = "", required = true) @PathVariable("ProductName") String productName) {
		Response singleCart = service.singleCart(userId, productName);
		CartResponse cartlist = new CartResponse();
		cartlist.addResultItem(singleCart);
		cartlist.setStatusCode(HttpStatus.ACCEPTED.value());
		cartlist.setStatusMessage("get single cart product");
		return new ResponseEntity<CartResponse>(cartlist,HttpStatus.OK);
	}
	
	public ResponseEntity<CartResponse> updateSingleProducts(
			@ApiParam(value = "", required = true) @PathVariable("ProductName") String productName,
			@ApiParam(value = "", required = true) @PathVariable("UserId") String userId,
			@ApiParam(value = "", required = true) @PathVariable("quantity") String quantity) {
		
		Response saveToCart = service.saveToCart(userId, productName, Integer.parseInt(quantity));
		CartResponse cartlist = new CartResponse();
		cartlist.addResultItem(saveToCart);
		cartlist.setStatusCode(HttpStatus.ACCEPTED.value());
		cartlist.setStatusMessage("add cart product");
		return new ResponseEntity<CartResponse>(cartlist,HttpStatus.OK);
	}

}
