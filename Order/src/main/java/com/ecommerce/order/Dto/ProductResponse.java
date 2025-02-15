package com.ecommerce.order.Dto;

import java.util.List;


public class ProductResponse {
	
	private List<Product> result = null;

	  private Integer statusCode;

	  private String statusMessage;

	  private ProductResponsePageDate pageDate;

	public ProductResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductResponse(List<Product> result, Integer statusCode, String statusMessage,
			ProductResponsePageDate pageDate) {
		super();
		this.result = result;
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
		this.pageDate = pageDate;
	}

	public List<Product> getResult() {
		return result;
	}

	public void setResult(List<Product> result) {
		this.result = result;
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

	public ProductResponsePageDate getPageDate() {
		return pageDate;
	}

	public void setPageDate(ProductResponsePageDate pageDate) {
		this.pageDate = pageDate;
	}

	@Override
	public String toString() {
		return "ProductResponse [result=" + result + ", statusCode=" + statusCode + ", statusMessage=" + statusMessage
				+ ", pageDate=" + pageDate + "]";
	}


}
