package com.ecommerce.user.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import com.ecommerce.user.exception.InputErrorClass;
import com.ecommerce.user.model.AdminResponse;
import com.ecommerce.user.model.AdminResponseResult;
import com.ecommerce.user.model.UserRequest;
import com.ecommerce.user.model.UserResponse;
import com.ecommerce.user.model.UserResponseResult;
import com.ecommerce.user.service.UserService;

import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-11T18:09:09.537264300+05:30[Asia/Calcutta]")

@Controller
@RequestMapping("${openapi.sellerMicroService.base-path:}")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class SellerApiController implements SellerApi {
	
	@Autowired
	UserService service;

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SellerApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }
	public ResponseEntity<UserResponse> createUser(
			@ApiParam(value = "Created user object", required = true) @Valid @RequestBody UserRequest userRequest) {
		if (userRequest.getName() == null || userRequest.getEmail() == null || userRequest.getPassword() == null
				|| userRequest.getAddress() == null || userRequest.getPhone() == null) {
			throw new InputErrorClass("Enter full details in the box");
		}

		UserResponseResult saveUser = service.saveUser(userRequest);
		UserResponse result = new UserResponse();
		result.setResult(saveUser);
		result.setStatusCode(HttpStatus.ACCEPTED.value());
		result.setStatusMessage("Saved successfully");
		return new ResponseEntity<UserResponse>(result, HttpStatus.OK);
	}

	public ResponseEntity<UserResponse> loginUser(
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "email", required = true) String email,
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "password", required = true) String password) {
		if (email == null || password == null) {
			throw new InputErrorClass("Email or password cannot be null");

		}
		UserResponseResult saveUser = service.LoginUser(email, password);
		UserResponse result = new UserResponse();
		result.setResult(saveUser);
		result.setStatusCode(HttpStatus.ACCEPTED.value());
		result.setStatusMessage("Saved successfully");
		return new ResponseEntity<UserResponse>(result, HttpStatus.OK);

	}

	public ResponseEntity<AdminResponse> singleseller(
			 @PathVariable("sellerId") String sellerId) {
		AdminResponseResult seller = service.getSeller(sellerId);
		AdminResponse adminResponse = new AdminResponse();
		adminResponse.addResultItem(seller);
		adminResponse.setStatusCode(HttpStatus.ACCEPTED.value());
		adminResponse.setStatusMessage("single seller information");
		return new ResponseEntity<AdminResponse>(adminResponse,HttpStatus.OK);
	}
	
	public ResponseEntity<AdminResponse> inActiveSeller(
			@ApiParam(value = "", required = true) @PathVariable("sellerId") String sellerId) 
	{
		AdminResponseResult deleteSeller = service.deleteSeller(sellerId);
		AdminResponse adminResponse = new AdminResponse();
		adminResponse.addResultItem(deleteSeller);
		adminResponse.setStatusCode(HttpStatus.ACCEPTED.value());
		adminResponse.setStatusMessage("single seller information");
		return new ResponseEntity<AdminResponse>(adminResponse,HttpStatus.OK);
	}
	
	public ResponseEntity<AdminResponse> adminUser() {
	       List<AdminResponseResult> allSeller = service.getAllSeller();
	       AdminResponse adminResponse = new AdminResponse();
	       adminResponse.setResult(allSeller);
		   adminResponse.setStatusCode(HttpStatus.ACCEPTED.value());
		   adminResponse.setStatusMessage("single seller information");
			return new ResponseEntity<AdminResponse>(adminResponse,HttpStatus.OK);	       
	}
	
	public ResponseEntity<AdminResponse> activeSeller(
			@PathVariable("sellerId") String sellerId) {
		AdminResponseResult updateseller = service.activeSeller(sellerId);
		AdminResponse adminResponse = new AdminResponse();
		adminResponse.addResultItem(updateseller);
		adminResponse.setStatusCode(HttpStatus.ACCEPTED.value());
		adminResponse.setStatusMessage("single seller information");
		return new ResponseEntity<AdminResponse>(adminResponse,HttpStatus.OK);
	}
}
