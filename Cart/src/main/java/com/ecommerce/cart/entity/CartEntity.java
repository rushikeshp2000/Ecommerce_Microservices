package com.ecommerce.cart.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ecommerce.cart.Dto.ImageDTO;


@Document("CartSaved")
public class CartEntity {
 
	  @Id
	  private String id;
	  
	  private String userId;
	  
	  private String name; //product  Name

	  private Double price;

	  private String sellerNumber;
	  
	  private String category;
	  
	  private Integer quantity;
	  
	  private Double totalPrice;

	  private List<ImageDTO> images = null;

	public CartEntity(String id, String userId, String name, Double price, String sellerNumber, String category,
			Integer quantity, Double totalPrice, List<ImageDTO> images) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.price = price;
		this.sellerNumber = sellerNumber;
		this.category = category;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.images = images;
	}

	public CartEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<ImageDTO> getImages() {
		return images;
	}

	public void setImages(List<ImageDTO> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "CartEntity [id=" + id + ", userId=" + userId + ", name=" + name + ", price=" + price + ", sellerNumber="
				+ sellerNumber + ", category=" + category + ", quantity=" + quantity + ", totalPrice=" + totalPrice
				+ ", images=" + images + "]";
	}
	  
	  

}
