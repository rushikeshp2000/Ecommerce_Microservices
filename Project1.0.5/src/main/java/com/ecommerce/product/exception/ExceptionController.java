package com.ecommerce.product.exception;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecommerce.product.model.ErrorResponse;

@RestControllerAdvice
public class ExceptionController {

	
	@ExceptionHandler(ProductNotFoundClass.class)
	public ResponseEntity<ErrorResponse> noSuchProduct(ProductNotFoundClass message) 
	{
		ErrorResponse error = new ErrorResponse();
		error.setResult(new ArrayList<>());;
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setStatusMessage(message.getMessage());
		return new ResponseEntity<ErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(QuantityNotAvailable.class)
	public ResponseEntity<ErrorResponse> NotAvailable(QuantityNotAvailable message) 
	{
		ErrorResponse error = new ErrorResponse();
		error.setResult(new ArrayList<>());;
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setStatusMessage(message.getMessage());
		return new ResponseEntity<ErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
}
