package com.ecommerce.order.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document("OrderDetails")
public class OrderEntity extends AuditingClass{

	  @Id
	  private String orderId;

	  private String userId;

	  private String sellerId;

	  private String userName;

	  private String userAddress;

	  private String userPhone;

	  private String userEmail;

	  private String productName;

	  private Double price;

	  private Integer quantity;
	  
	  private Double totalprice;

	public OrderEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderEntity(LocalDateTime createdDate, LocalDateTime lastmodifiedDate, String createdBy) {
		super(createdDate, lastmodifiedDate, createdBy);
		// TODO Auto-generated constructor stub
	}

	public OrderEntity(String orderId, String userId, String sellerId, String userName, String userAddress,
			String userPhone, String userEmail, String productName, Double price, Integer quantity, Double totalprice) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.sellerId = sellerId;
		this.userName = userName;
		this.userAddress = userAddress;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.totalprice = totalprice;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public Double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	@Override
	public String toString() {
		return "OrderEntity [orderId=" + orderId + ", userId=" + userId + ", sellerId=" + sellerId + ", userName="
				+ userName + ", userAddress=" + userAddress + ", userPhone=" + userPhone + ", userEmail=" + userEmail
				+ ", productName=" + productName + ", price=" + price + ", quantity=" + quantity + ", totalprice="
				+ totalprice + "]";
	}

	
	
}

