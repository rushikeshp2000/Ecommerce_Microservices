package com.ecommerce.order.Dto;

import java.util.List;

public class CartResponse   {
  private Integer statusCode;

  private String statusMessage;

  private List<Response> result = null;

public CartResponse() {
	super();
	// TODO Auto-generated constructor stub
}

public CartResponse(Integer statusCode, String statusMessage, List<Response> result) {
	super();
	this.statusCode = statusCode;
	this.statusMessage = statusMessage;
	this.result = result;
}

@Override
public String toString() {
	return "CartResponse [statusCode=" + statusCode + ", statusMessage=" + statusMessage + ", result=" + result + "]";
}

public Integer getStatusCode() {
	return statusCode;
}

public void setStatusCode(Integer statusCode) {
	this.statusCode = statusCode;
}

public String getStatusMessage() {
	return statusMessage;
}

public void setStatusMessage(String statusMessage) {
	this.statusMessage = statusMessage;
}

public List<Response> getResult() {
	return result;
}

public void setResult(List<Response> result) {
	this.result = result;
}

  
  
}

