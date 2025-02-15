package com.ecommerce.user.controller;

import java.io.IOException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import com.ecommerce.user.exception.InputErrorClass;
import com.ecommerce.user.model.User;
import com.ecommerce.user.model.UserRequest;
import com.ecommerce.user.model.UserResponse;
import com.ecommerce.user.model.UserResponseResult;

import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
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
		/*
		 * public ResponseEntity<UserResponse> createUser(
		 * 
		 * @ApiParam(value = "Created user object", required = true) @Valid @RequestBody
		 * UserRequest userRequest) { if (userRequest.getName() == null ||
		 * userRequest.getEmail() == null || userRequest.getPassword() == null ||
		 * userRequest.getAddress() == null || userRequest.getPhone() == null) { throw
		 * new InputErrorClass("Enter full details in the box"); }
		 * 
		 * UserResponseResult saveUser = service.saveUser(userRequest); UserResponse
		 * result = new UserResponse(); result.setResult(saveUser);
		 * result.setStatusCode(HttpStatus.ACCEPTED.value());
		 * result.setStatusMessage("Saved successfully"); return new
		 * ResponseEntity<UserResponse>(result, HttpStatus.OK); }
		 * 
		 * public ResponseEntity<UserResponse> loginUser(
		 * 
		 * @NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value =
		 * "email", required = true) String email,
		 * 
		 * @NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value =
		 * "password", required = true) String password) { if (email == null || password
		 * == null) { throw new InputErrorClass("Email or password cannot be null");
		 * 
		 * } UserResponseResult saveUser = service.LoginUser(email, password);
		 * UserResponse result = new UserResponse(); result.setResult(saveUser);
		 * result.setStatusCode(HttpStatus.ACCEPTED.value());
		 * result.setStatusMessage("Saved successfully"); return new
		 * ResponseEntity<UserResponse>(result, HttpStatus.OK);
		 * 
		 * }
		 * 
		 * public ResponseEntity<User> getUser(@ApiParam(value =
		 * "",required=true) @PathVariable("UserId") String userId) { User user =
		 * service.getUser(userId); return new
		 * ResponseEntity<User>(user,HttpStatus.ACCEPTED); }
		 */
	 

}
