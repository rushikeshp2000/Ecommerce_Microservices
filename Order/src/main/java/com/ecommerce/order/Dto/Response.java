package com.ecommerce.order.Dto;

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response   {
	
	 private String name;

	  private Double price;

	  private Integer quantity;

	  private String sellerNumber;

	  private String category;

	  private Double totalPrice;

	  private List<ImageModel> images = null;

	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Response(String name, Double price, Integer quantity, String sellerNumber, String category,
			Double totalPrice, List<ImageModel> images) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.sellerNumber = sellerNumber;
		this.category = category;
		this.totalPrice = totalPrice;
		this.images = images;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getSellerNumber() {
		return sellerNumber;
	}

	public void setSellerNumber(String sellerNumber) {
		this.sellerNumber = sellerNumber;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<ImageModel> getImages() {
		return images;
	}

	public void setImages(List<ImageModel> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Response [name=" + name + ", price=" + price + ", quantity=" + quantity + ", sellerNumber="
				+ sellerNumber + ", category=" + category + ", totalPrice=" + totalPrice + ", images=" + images + "]";
	}

  
}

