package com.ecommerce.product.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProductResponsePageDate
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-14T19:35:05.706628+05:30[Asia/Calcutta]")

public class ProductResponsePageDate   {
  @JsonProperty("offset")
  private Integer offset = 0;

  @JsonProperty("limit")
  private Integer limit = 15;

  @JsonProperty("totalItems")
  private Long totalItems;

  @JsonProperty("totalPages")
  private Integer totalPages;

  public ProductResponsePageDate offset(Integer offset) {
    this.offset = offset;
    return this;
  }

  /**
   * PageNumber ,The start index of the result set, 0 based
   * @return offset
  */
  @ApiModelProperty(example = "0", value = "PageNumber ,The start index of the result set, 0 based")


  public Integer getOffset() {
    return offset;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  public ProductResponsePageDate limit(Integer limit) {
    this.limit = limit;
    return this;
  }

  /**
   * PageSize, Limit of the result set
   * @return limit
  */
  @ApiModelProperty(example = "15", value = "PageSize, Limit of the result set")


  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public ProductResponsePageDate totalItems(Long totalItems) {
    this.totalItems = totalItems;
    return this;
  }

  /**
   * Get totalItems
   * @return totalItems
  */
  @ApiModelProperty(example = "20", value = "")


  public Long getTotalItems() {
    return totalItems;
  }

  public void setTotalItems(Long totalItems) {
    this.totalItems = totalItems;
  }

  public ProductResponsePageDate totalPages(Integer totalPages) {
    this.totalPages = totalPages;
    return this;
  }

  /**
   * Get totalPages
   * @return totalPages
  */
  @ApiModelProperty(example = "10", value = "")


  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductResponsePageDate productResponsePageDate = (ProductResponsePageDate) o;
    return Objects.equals(this.offset, productResponsePageDate.offset) &&
        Objects.equals(this.limit, productResponsePageDate.limit) &&
        Objects.equals(this.totalItems, productResponsePageDate.totalItems) &&
        Objects.equals(this.totalPages, productResponsePageDate.totalPages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(offset, limit, totalItems, totalPages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductResponsePageDate {\n");
    
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    totalItems: ").append(toIndentedString(totalItems)).append("\n");
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

