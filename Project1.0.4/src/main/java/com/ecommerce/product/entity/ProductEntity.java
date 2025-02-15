package com.ecommerce.product.entity;

import java.util.List;
import java.util.UUID;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;


@Document("ProductData")
public class ProductEntity {
	 
	  @Id
	  private String id; 
	  
	  private String name;

	  private Double price;

	  private String details;

	  private Integer quantity;

	  private UUID sellerNumber;

	  private String category;

	  private Integer discount;
	  
	  private List<ImageEntity> image;

	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductEntity(String id, String name, Double price, String details, Integer quantity, UUID sellerNumber,
			String category, Integer discount, List<com.ecommerce.product.entity.ImageEntity> image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.details = details;
		this.quantity = quantity;
		this.sellerNumber = sellerNumber;
		this.category = category;
		this.discount = discount;
		this.image = image;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public UUID getSellerNumber() {
		return sellerNumber;
	}

	public void setSellerNumber(UUID sellerNumber) {
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

	public List<ImageEntity> getImage() {
		return image;
	}

	public void setImage(List<ImageEntity> image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", name=" + name + ", price=" + price + ", details=" + details
				+ ", quantity=" + quantity + ", sellerNumber=" + sellerNumber + ", category=" + category + ", discount="
				+ discount + ", image=" + image + "]";
	}

	
	  
}
