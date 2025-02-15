package com.ecommerce.order.Dto;

import java.util.List;

import javax.validation.Valid;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

	  private String name;

	  private Double price;

	  private String details;

	  private Integer quantity;

	  private String sellerNumber;

	  private String category;

	  private Integer discount;

	  private String status;

	  private List<ImageModel> images = null;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String name, Double price, String details, Integer quantity, String sellerNumber, String category,
			Integer discount, String status, List<ImageModel> images) {
		super();
		this.name = name;
		this.price = price;
		this.details = details;
		this.quantity = quantity;
		this.sellerNumber = sellerNumber;
		this.category = category;
		this.discount = discount;
		this.status = status;
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

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
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

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ImageModel> getImages() {
		return images;
	}

	public void setImages(List<ImageModel> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", details=" + details + ", quantity=" + quantity
				+ ", sellerNumber=" + sellerNumber + ", category=" + category + ", discount=" + discount + ", status="
				+ status + ", images=" + images + "]";
	}
	  
	  

}
