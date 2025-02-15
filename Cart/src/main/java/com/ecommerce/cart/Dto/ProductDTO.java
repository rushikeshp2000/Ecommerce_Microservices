package com.ecommerce.cart.Dto;

import java.util.List;
import java.util.UUID;


public class ProductDTO {
	
	  private String name;

	  private Double price;

	  private String details;

	  private Integer quantity;

	  private String sellerNumber;

	  private String category;

	  private Integer discount;

	  private List<ImageDTO> images = null;

	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(String name, Double price, String details, Integer quantity, String sellerNumber, String category,
			Integer discount, List<ImageDTO> images) {
		super();
		this.name = name;
		this.price = price;
		this.details = details;
		this.quantity = quantity;
		this.sellerNumber = sellerNumber;
		this.category = category;
		this.discount = discount;
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

	public List<ImageDTO> getImages() {
		return images;
	}

	public void setImages(List<ImageDTO> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "ProductDTO [name=" + name + ", price=" + price + ", details=" + details + ", quantity=" + quantity
				+ ", sellerNumber=" + sellerNumber + ", category=" + category + ", discount=" + discount + ", images="
				+ images + "]";
	}

	
	  
	  

}
