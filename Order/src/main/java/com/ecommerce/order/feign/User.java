package com.ecommerce.order.feign;

import java.math.BigDecimal;


public class User {

	  private String id;

	  private String name;

	  private String address;

	  private String email;

	  private BigDecimal phone;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String id, String name, String address, String email, BigDecimal phone) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", phone=" + phone
				+ "]";
	}

	  
}

