package com.ecommerce.productService.api.entity;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

@Document("Product")
public class ProductEntity {

	  @Id
	  private String id;
	
	  private String name;

	  private MultipartFile imagefile1;

	  private MultipartFile imagefile2;

	  private MultipartFile imagefile3;

	  private BigDecimal price;

	  private String details;

	  private Integer quantity;

	  private UUID sellerNumber;

	  private String category;

	  private Integer discount;

	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductEntity(String id, String name, MultipartFile imagefile1, MultipartFile imagefile2,
			MultipartFile imagefile3, BigDecimal price, String details, Integer quantity, UUID sellerNumber,
			String category, Integer discount) {
		super();
		this.id = id;
		this.name = name;
		this.imagefile1 = imagefile1;
		this.imagefile2 = imagefile2;
		this.imagefile3 = imagefile3;
		this.price = price;
		this.details = details;
		this.quantity = quantity;
		this.sellerNumber = sellerNumber;
		this.category = category;
		this.discount = discount;
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

	public MultipartFile getImagefile1() {
		return imagefile1;
	}

	public void setImagefile1(MultipartFile imagefile1) {
		this.imagefile1 = imagefile1;
	}

	public MultipartFile getImagefile2() {
		return imagefile2;
	}

	public void setImagefile2(MultipartFile imagefile2) {
		this.imagefile2 = imagefile2;
	}

	public MultipartFile getImagefile3() {
		return imagefile3;
	}

	public void setImagefile3(MultipartFile imagefile3) {
		this.imagefile3 = imagefile3;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
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

	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", name=" + name + ", imagefile1=" + imagefile1 + ", imagefile2="
				+ imagefile2 + ", imagefile3=" + imagefile3 + ", price=" + price + ", details=" + details
				+ ", quantity=" + quantity + ", sellerNumber=" + sellerNumber + ", category=" + category + ", discount="
				+ discount + "]";
	}

	
	  
	  
	  
}
