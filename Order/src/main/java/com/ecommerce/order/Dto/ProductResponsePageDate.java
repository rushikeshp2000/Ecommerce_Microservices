package com.ecommerce.order.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductResponsePageDate {

	
	 private Integer offset = 0;

	  private Integer limit = 15;

	  private Long totalItems;

	  private Integer totalPages;

	public ProductResponsePageDate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductResponsePageDate(Integer offset, Integer limit, Long totalItems, Integer totalPages) {
		super();
		this.offset = offset;
		this.limit = limit;
		this.totalItems = totalItems;
		this.totalPages = totalPages;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Long getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Long totalItems) {
		this.totalItems = totalItems;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	@Override
	public String toString() {
		return "ProductResponsePageDate [offset=" + offset + ", limit=" + limit + ", totalItems=" + totalItems
				+ ", totalPages=" + totalPages + "]";
	}
	  
	  

}
