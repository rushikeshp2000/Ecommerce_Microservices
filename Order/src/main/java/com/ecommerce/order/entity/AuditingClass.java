package com.ecommerce.order.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

public class AuditingClass {
	
	@CreatedDate
	private LocalDateTime createdDate;

	@LastModifiedDate
	private LocalDateTime LastmodifiedDate;
	
	@CreatedBy
	private String createdBy;

	
	
	//@LastModifiedBy
	//private String updatedBy; 
	
	public AuditingClass() {
		super();
		// TODO Auto-generated constructor stub
	}



	public AuditingClass(LocalDateTime createdDate, LocalDateTime lastmodifiedDate, String createdBy) {
		super();
		this.createdDate = createdDate;
		LastmodifiedDate = lastmodifiedDate;
		this.createdBy = createdBy;
	}



	public LocalDateTime getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}



	public LocalDateTime getLastmodifiedDate() {
		return LastmodifiedDate;
	}



	public void setLastmodifiedDate(LocalDateTime lastmodifiedDate) {
		LastmodifiedDate = lastmodifiedDate;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	@Override
	public String toString() {
		return "AuditingClass [createdDate=" + createdDate + ", LastmodifiedDate=" + LastmodifiedDate + ", createdBy="
				+ createdBy + "]";
	}
	
	
}
