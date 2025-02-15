package com.ecommerce.user.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document("SellerData")
public class UserEntity {

	  @Id
	  private String id;
	  
	  private String name;

	  private String address;

	  private String email;

	  private BigDecimal phone;

	  private String password;
	  
	  private Status status;

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(String id, String name, String address, String email, BigDecimal phone, String password,
			Status status) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.status = status;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getPhone() {
		return phone;
	}

	public void setPhone(BigDecimal phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", phone="
				+ phone + ", password=" + password + ", status=" + status + "]";
	}

	
	  
	  
}
