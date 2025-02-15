package com.ecommerce.product.entity;

import org.springframework.stereotype.Component;

@Component
public class PaginationCreater {

	private int totalPages;
	private long totalElements;
	private int number;
	private int numberOfElements;
	public PaginationCreater(int totalPages, long totalElements, int number, int numberOfElements) {
		super();
		this.totalPages = totalPages;
		this.totalElements = totalElements;
		this.number = number;
		this.numberOfElements = numberOfElements;
	}
	public PaginationCreater() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getNumberOfElements() {
		return numberOfElements;
	}
	public void setNumberOfElements(int numberOfElements) {
		this.numberOfElements = numberOfElements;
	}
	@Override
	public String toString() {
		return "PaginationCreater [totalPages=" + totalPages + ", totalElements=" + totalElements + ", number=" + number
				+ ", numberOfElements=" + numberOfElements + "]";
	}
	
	
}
