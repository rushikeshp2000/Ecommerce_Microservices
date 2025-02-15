package com.ecommerce.product.entity;

import java.util.List;
import java.util.UUID;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document("Product_1.0.5")
public class ProductEntity extends AuditingClass {
	 
	  @Id
	  private String id; 
	  
	  private String name;

	  private Double price;

	  private String details;

	  private Integer quantity;

	  private String sellerNumber;

	  @Field("product_status")
	  private ProductStatus prodStatus;
	  
	  private String category;

	  private Integer discount;
	  
	  private List<ImageEntity> image;
	  

	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProductEntity(String id, String name, Double price, String details, Integer quantity, String sellerNumber,
			ProductStatus prodStatus, String category, Integer discount, List<ImageEntity> image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.details = details;
		this.quantity = quantity;
		this.sellerNumber = sellerNumber;
		this.prodStatus = prodStatus;
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


	public String getSellerNumber() {
		return sellerNumber;
	}


	public void setSellerNumber(String sellerNumber) {
		this.sellerNumber = sellerNumber;
	}


	public ProductStatus getProdStatus() {
		return prodStatus;
	}


	public void setProdStatus(ProductStatus prodStatus) {
		this.prodStatus = prodStatus;
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
				+ ", quantity=" + quantity + ", sellerNumber=" + sellerNumber + ", prodStatus=" + prodStatus
				+ ", category=" + category + ", discount=" + discount + ", image=" + image + "]";
	}



	
	  
}
