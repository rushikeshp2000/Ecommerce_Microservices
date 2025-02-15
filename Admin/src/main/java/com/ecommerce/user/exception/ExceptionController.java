package com.ecommerce.user.exception;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecommerce.user.model.ErrorApiResponse;


@RestControllerAdvice 
public class ExceptionController {

	
	@ExceptionHandler(InvalidUser.class)
	public ResponseEntity<ErrorApiResponse> noSuchProduct(InvalidUser message) 
	{
		ErrorApiResponse error = new ErrorApiResponse();
		error.addErrorMessagesItem(message.getMessage());
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setStatusMessage(message.getMessage());
		return new ResponseEntity<ErrorApiResponse>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InputErrorClass.class)
	public ResponseEntity<ErrorApiResponse> NullvaluesSubmitted(InputErrorClass message) 
	{
		ErrorApiResponse error = new ErrorApiResponse();
		error.addErrorMessagesItem(message.getMessage());
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setStatusMessage(message.getMessage());
		return new ResponseEntity<ErrorApiResponse>(error,HttpStatus.NOT_FOUND);
	}
}
